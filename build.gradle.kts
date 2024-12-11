plugins {
    kotlin("jvm") version "2.1.0"
    idea
    id("org.jetbrains.gradle.plugin.idea-ext") version "1.1.9"
    id("com.gradleup.shadow") version "9.0.0-beta4"
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "idea")
    apply(plugin = "org.jetbrains.gradle.plugin.idea-ext")
    apply(plugin = "com.gradleup.shadow")

    group = "io.github.runkang10.openss"
    version = "1.0.0"

    repositories {
        mavenCentral()
        gradlePluginPortal()

        maven("https://repo.papermc.io/repository/maven-public/") {
            name = "papermc-repo"
        }
        maven("https://oss.sonatype.org/content/groups/public/") {
            name = "sonatype"
        }
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
    }

    tasks.build {
        dependsOn(tasks.shadowJar)
    }

    tasks.jar {
        enabled = false
    }

    kotlin {
        jvmToolchain(21)
    }
}