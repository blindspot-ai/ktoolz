# ktoolz
[![GitHub version](https://badge.fury.io/gh/blindspot-ai%2Fktoolz.svg)](https://badge.fury.io/gh/blindspot-ai%2Fktoolz)

Collection of Kotlin extension functions and utilities. 

## Using ktoolz
ktoolz is hosted on GitHub Packages and therefore one must include to the project. Unfortunately GH Packages do not 
support anonymous access to maven repositories, so you need to generate new PAT (Personal access token) to access 
the package.
```kotlin
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/blindspot-ai/ktoolz")
        credentials {
            username = "token"
            password = "<YOUR_PAT>"
        }
    }
}
```
Then to import ktoolz to Gradle project use:
```Kotlin
implementation("ai.blindspot.ktoolz:ktoolz:1.1.0")
```
Or with Groovy DSL
```groovy
implementation 'ai.blindspot.ktoolz:ktoolz:1.1.0'
```
To import ktoolz to Maven project use:
```xml
<dependency>
  <groupId>ai.blindspot.ktoolz</groupId>
  <artifactId>ktoolz</artifactId>
  <version>1.1.0</version>
</dependency>
```



## Deployment
The library packages are deployed to GitHub Packages using GitHub Actions. Make sure that `build.gradle.kts` has 
the correct version set and then create release in GitHub. The package will be deployed automatically.

To release a new version of the Ktoolz simply call `make release VERSION=0.0.0` where `0.0.0` is the new version. 

## Maintainers
[Lukas Forst](https://github.com/LukasForst) and [Petr Eichler](https://github.com/Petr-Eichler)
