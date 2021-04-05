import org.gradle.jvm.tasks.Jar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `maven-publish`
    jacoco // for test coverage reports

    kotlin("jvm") version Versions.kotlin

    id("io.gitlab.arturbosch.detekt") version Versions.detekt
}

group = "ai.blindspot.ktoolz"
version = "1.1.0"

repositories {
    mavenCentral()
    jcenter {
        content {
            // Only download the 'kotlinx-html-jvm' module from JCenter, but nothing else.
            // detekt needs 'kotlinx-html-jvm' for the HTML report.
            // TODO: remove this section, when JetBrains (and detekt) fully migrate to other repository
            includeModule("org.jetbrains.kotlinx", "kotlinx-html-jvm")
        }
    }
}

detekt {
    parallel = true
    config = files(rootDir.resolve("detekt-config.yml"))
    buildUponDefaultConfig = true
}

dependencies {
    implementation(Libs.kotlinStdlib) // kotlin std
    implementation(Libs.slf4j) // logging API
    implementation(Libs.kotlinLogging) // logging DSL

    // testing
    testImplementation(TestLibs.kotlinTest) // kotlin idiomatic testing
    testImplementation(TestLibs.kotlinTestJunit5) // kotlin.test wrapper for Junit5
    testImplementation(TestLibs.mockk) // mock framework
    testImplementation(TestLibs.logbackClassic) // logging framework for the tests
    testImplementation(TestLibs.junitApi) // junit testing framework
    testImplementation(TestLibs.junitParams) // generated parameters for tests

    testRuntimeOnly(TestLibs.junitEngine) // testing runtime
}

tasks {
    // when check is executed, detekt and test coverage verification must be run as well
    check {
        dependsOn(detekt, jacocoTestCoverageVerification) // fails when the code coverage is below value specified in Props.codeCoverageMinimum
    }

    // generate test reports for the Sonarqube and in the human-readable form
    jacocoTestReport {
        dependsOn(test)

        reports {
            csv.isEnabled = false
            xml.isEnabled = true
            html.isEnabled = true
        }
    }

    // set up verification for test coverage
    jacocoTestCoverageVerification {
        dependsOn(jacocoTestReport)
    }

    withType<Test> {
        useJUnitPlatform()
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

// deployment configuration - deploy with sources and documentation
val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

val javadocJar by tasks.creating(Jar::class) {
    archiveClassifier.set("javadoc")
    from(tasks.javadoc)
}

val publicationName = "ktoolz"
publishing {
    publications {
        register(publicationName, MavenPublication::class) {
            from(components["java"])
            artifact(sourcesJar)
            artifact(javadocJar)
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/blindspot-ai/ktoolz")
            credentials {
                username = Props.githubActor.getOrNull()
                password = Props.githubToken.getOrNull()
            }
        }
    }
}
