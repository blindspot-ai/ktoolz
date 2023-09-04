# ktoolz
[![GitHub version](https://badge.fury.io/gh/blindspot-ai%2Fktoolz.svg)](https://badge.fury.io/gh/blindspot-ai%2Fktoolz)

**No longer maintained!**

This library is no longer maintained, please use the successor library `katlib` https://github.com/LukasForst/katlib

---

Collection of Kotlin extension functions and utilities. 

## Using Ktoolz
Ktoolz is hosted on [JCenter](https://bintray.com) and therefore one must include to the project.
```kotlin
repositories {
    jcenter()
}
```
Then to import Ktoolz to Gradle project use:
```Kotlin
implementation("ai.blindspot.ktoolz:ktoolz:1.1.0")
```
Or with Groovy DSL
```groovy
implementation 'ai.blindspot.ktoolz:ktoolz:1.1.0'
```
To import Ktoolz to Maven project use:
```xml
<dependency>
  <groupId>ai.blindspot.ktoolz</groupId>
  <artifactId>ktoolz</artifactId>
  <version>1.1.0</version>
</dependency>
```



## Deployment
The Ktoolz library is currently hosted on the JCenter repository.
To deploy the library to JCenter repository one must set up deployment secrets,
the secrets should be stored in the file `ktoolz.properties`, that is not tracked by the git.
The file has following structure:
```properties
bintray.user=<user>
bintray.apiKey=<api.key>
```
To publish the library, one must execute `./gradlew bintrayUpload` or using the `Makefile` - `make publish`.

To release a new version of the Ktoolz simply call `make release VERSION=0.0.0` where `0.0.0` is the new version. 

## Maintainers
[Lukas Forst](https://github.com/LukasForst) and [Petr Eichler](https://github.com/Petr-Eichler)
