# Contributing

## 📘 Notice to Developers: Repository Transfer 📘
On June 21st, 2021, this repository was transferred from the `Twasi` Organization to the 
`obs-websocket-community-projects` Organization. This was done to better align this library with the 
greater Palakis' OBS Websocket plugin community, and provide better administrative tools.

Remotes will continue to operate as normal, due to GitHub automatic redirects. However, to avoid 
confusion GitHub strongly recommends you update those remotes. 

If you haven't updated your remote, you can check like so; the below example shows an old remote:
```
C:\Users\...\websocket-obs-java>git remote -v
origin  https://github.com/Twasi/websocket-obs-java.git (fetch)
origin  https://github.com/Twasi/websocket-obs-java.git (push)
```
You can update and verify your remote is correct like this:
```
C:\Users\...\websocket-obs-java>git remote set-url origin https://github.com/obs-websocket-community-projects/obs-websocket-java.git
(no output)
C:\Users\...\websocket-obs-java>git remote -v
origin  https://github.com/obs-websocket-community-projects/obs-websocket-java.git (fetch)
origin  https://github.com/obs-websocket-community-projects/obs-websocket-java.git (push)
```
See [Transferring a repository](https://docs.github.com/en/github/administering-a-repository/managing-repository-settings/transferring-a-repository)
for more information.

## Testing

### Unit and Integration Tests
These tests can be run completely standalone and do not require an instance of OBS (though, they
may try to simulate bad network connections). These should always run automatically in CI/CD flows.

```
gradlew client:test
gradlew client:integrationTest
```

### End-To-End Automated Tests
These tests only exercise the authentication process with OBS Websockets (and not OS/env specific OBS features, such as Browser or VLC media sources). They are divided into the 'secure' and 'unsecure' portions. 

The 'secure' portions require OBS Websockets to have authentication enabled with the password set to `password`, and are automated via CI/CD with the help of the [obs-websocket-docker](https://github.com/TinaTiel/obs-websocket-docker) docker library. 

```
gradlew client:endToEndUnsecuredTest
```

The 'unsecure' portions require OBS Websockets authentication be disabled, and at this time must be run manually.

```
gradlew client:endToEndSecuredTest
```

### End-To-End Manual Tests

Unfortunately, there is incomplete feature parity between Windows and Linux distributions of OBS 
(Windows having the lion's share of features). This means that it isn't possible to exercise all
features offered by OBS (and OBS Websockets) unless run on a Windows environment and under specific
conditions. 

Therefore, the tests in the `endToEndManualTest` module require running manually in a local 
environment meeting these requirements:

  - Windows 10 OS
  - OBS 27+
  - OBS Websockets 5+
  - VLC Media Player
  - Scene Collection from this project installed (See [OBS Resources](obs-resources/README.md) 
    for more information)

These tests are run manually, and require you to follow the prompts during the test and watch for the results in OBS; you cannot run these test using a Docker image.

```
gradlew client:endToEndManualTest
```

### Example Project
We provide an example project to help people understand how to use this library. At this time, we verify only during CI/CD that it compiles.

```
gradlew example:build
```

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
  - Use Lombok to generate getters, setters, builders, toString, etc. to keep DTO
    boilerplate more manageable. Exceptions to this should be considered carefully where customization
    makes sense (for example, in the ObsCommunicator and ObsRemoteController builders).
  - Avoid switch-case statements to handle serialization/deserialization. Instead, register Gson 
    TypeAdapters and include unit tests to verify serialization/deserialization works as expected.
    
## CI/CD

All CI/CD is governed by push-to-branch naming semantics, and the [VERSION](VERSION) file. All are 
executed by GitHub Actions (see [.github/workflows](.github/workflows)).
  - [build.gradle](build.gradle) manages pushing releases or snapshots with other metadata to maven central.
  - Version is configured by the [VERSION](VERSION) file.
  - Release/Snapshot is governed by the `IS_RELEASE` env var set to 'YES' or not.
  - Pushes to `develop` trigger snapshot releases to maven central. Creds are in GH secrets.
  - Pushes to `release/*` trigger releases to maven central. Creds are in GH secrets.
  - Pushes to `master` creates a git tag using the VERSION file.

### Publishing Snapshots
Snapshots are available to developers wanting to use the latest version of this library.
While not perfect, any pushes to develop should (1) Compile, (2) pass unit tests, and (3) have been
checked manually as described above. 

Provided these are satisfied, this is how you can publish a snapshot:
1. Create a branch from `develop` and work on it.
1. Create a PR for merge into the `develop` branch.
1. Merge into `develop`; this triggers a SNAPSHOT release

### Publishing Releases
Releases are available to the general-public as official releases on Maven Central. In addition 
to meeting code standards, they also include release notes and a tag in git.

To make an official release, follow this process:
1. When you want to release what is on the `develop` branch, create a new branch with the 
   name `release/A.B.C`.
1. Push the new release branch; this will create a new release in Maven Central.
1. Create a PR to merge that branch into `master`. Include in that PR any release notes for that 
   release; see [Release 1.3.0](https://github.com/Twasi/websocket-obs-java/pull/44) for an 
   example, if you're not sure what to write.
1. Merge the PR into master; this will create a tag on master using the current VERSION
1. Checkout the `develop` branch and increment the patch version; this way, future pushes to 
   develop will be against the snapshot of that version. 
