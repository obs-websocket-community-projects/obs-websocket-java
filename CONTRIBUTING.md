# Contributing

## Testing
Many tests can be run without OBS. However, as a Windows distribution of an OBS container is difficult
to come by, you will need to run many integration tests against a local instance.

Generally speaking, unless in the `manual` folder, tests can be run without intervention against 
an unsecured OBS instance (no password required). 

In `manual/OBSCommunicatorSecuredIT.java`, you need to enable authentication in OBS using `password`
as the password. 

Finally, in `ObsRemoteE23ObservationIT` you need to install the included scene collection and media
files and follow the test prompts while observing the results in OBS. See 
[OBS Resources](obs-resources/README.md) for more information about setup for this test.

## Pull Request / Code Guidelines

### Branching
All Pull requests must be directed against the `develop` branch. Unless you are a contributor, you 
will need to fork this repository and make a pull request for your fork. If you review a PR, we 
recommend you use the GitHub CLI to pull the PR so that you can pull the code (e.g. if the fork branch
is in a private repository).

You can follow whichever convention you would like for the names of your branches, but we recommend
that if working against a specific issue you reference the issue number (e.g. `topic-NN`) to make
the purpose of your branch more clear.

### Code Conventions & Best Practices
  - Only push code that compiles.
  - Try to follow Google style conventions.
  - Include small unit tests when possible.
  - Manual tests need to pass before filing PRs.
  - Update the manual observation integration test where applicable; allow other developers to 
    easily verify your code works as expected without requiring them to write their own.
  - If you are adding a new feature (for example, setting the current scene), then include any 
    tangential features (in this example, getting the current scene, and registering for
    "scene changed" events) to provide feature-completeness for users of this library.
  - When possible, use Lombok to generate getters, setters, builders, toString, etc. to keep DTO
    boilerplate more manageable. Exceptions to this should be considered carefully where customization
    makes sense (for example, in the ObsCommunicator and ObsRemoteController builders).
  - Avoid switch-case statements to handle serialization/deserialization. Instead, register Gson 
    TypeAdapters and include a small unit test for a sample of cases (doing all are not necessary; just 
    a few to demonstrate your TypeAdapter works as expected).
    
## Releases
TODO