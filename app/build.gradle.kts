/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.7/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    alias(libs.plugins.jvm)

    // Apply the application plugin to add support for building a CLI application in Java.
    application

    id("org.cyclonedx.bom") version "1.8.2"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
    // Try github for internal packages.
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/navikt/appsec-internal-test")
        credentials {
            username = System.getenv("GITHUB_ACTOR") as String? ?: "github"
            password = System.getenv("GITHUB_TOKEN") as String?
        }
    }
}

dependencies {
    implementation("com.github.navikt:appsec-internal-test:625605ff5d1d78d8a9fce5e621367470ad47793b")
    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    // Use the JUnit 5 integration.
    testImplementation(libs.junit.jupiter.engine)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation(libs.guava)
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "org.example.AppKt"
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

tasks.cyclonedxBom {
    setOutputFormat("json")
}
