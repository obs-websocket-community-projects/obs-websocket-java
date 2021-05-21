# Testing with  OBS Scene Collections
The tools in this directory help you to use and create scene collections in order to perform end-to-end integration testing. Ultimately they're just a standardized way of finding and replacing 
filepaths in OBS Scene Collection export files.

## About the Files
`/static`: Put all media files in this directory

`AnonymizedSceneCollection.json`: This is the test scene collection that is committed to source control and should _not_ contain any personal details (e.g. `C:\Users\My Name\...\path\to\project` should be replaced with `REPLACE_ME\path\to\project`).

## Importing the Anonymized Scene Collection into OBS
Run `normalize.py` to take the anonymized scene collection and create a local copy with the absolute paths for this directory.
```
python .\normalize.py "C:\Users\My Name\Downloads"
```
When run, this replaces occurences of `REPLACE_ME` with the absolute 
path to this directory and creates a copy called 
`TestSceneCollection.json` in your downloads folder. 

Now you can import `TestSceneCollection.json` into OBS via 
`Scene Collection > Import`, and then switch to that scene collection
via `Scene Collection > OBS_Test_Scene_Collection`. 

You'll know import was successful if when you make e.g. an image source
visible then you can see it in OBS. You can also inspect the source 
and should see its path, e.g. 
`C:\path\to\project\obs-resources\static\image.jpg` 
instead of `REPLACE_ME\static\image.jpg`.

## Running Tests
Once you have imported the normalized scene collection, you can run the End-To-End tests (in `E2EUnsecuredIT.java`) in one window (or directly from your IDE)...

```
gradlew :clean :integrationTest --info --tests "net.twasi.obsremotejava.test.E2EUnsecuredIT"
```

...And observe OBS in another. 

You'll see print-outs in the window indicating what 
you should see happen in OBS and a countdown to when it will happen:

```
===============================
>> Resetting...
>> ...Ready
>>> OBS SHOULD: Show the red square
> 3
> 2
> 1
```

If the test is 'passing' then you should see the same result in OBS 
(e.g., showing a red square).

## Updating and Anonymizing a Scene Collection
If you are adding additional tests that require changes to the 
existing scene collection and/or media, then follow the below.

### Adding New Media

Unless you want to expose your personal directory to the world (and 
make converting the scene collection paths painful for the next 
developer), please ensure any new media is placed in the `/static` 
directory in this project before using in OBS. You should **not** be 
using files outside the `/static` directory in OBS.

### Updating the Scene Collection
When you are ready, export your scene collection in OBS via `Scene Collection > Export`. 

Once exported, you can now anonymize and update the existing scene
collection in this directory:
```
python .\anonymize.py "C:\Users\My Name\Downloads\MyExport.json"
```

This script finds all occurences of the current directory in 
`MyExport.json` in the above example, replaces them with 
`REPLACE_ME`, and updates `AnonymizedSceneCollection.json` in this
directory. 

You can now safely commit these changes and make the scene
collection and media updates available to the next developer!