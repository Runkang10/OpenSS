plugins {
    kotlin("jvm") version "2.1.0"
    idea
    id("io.papermc.paperweight.userdev") version "1.7.7"
    id("org.jetbrains.gradle.plugin.idea-ext") version "1.1.9"
    id("com.gradleup.shadow") version "9.0.0-beta4"
}

val prefix = name.uppercase()
rootProject.extra["prefix"] = prefix
rootProject.extra["configVersion"] = "0.0.1"

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "idea")
    apply(plugin = "org.jetbrains.gradle.plugin.idea-ext")
    apply(plugin = "com.gradleup.shadow")
    apply(plugin = "io.papermc.paperweight.userdev")

    rootProject.extra["prefix"]
    description = "A ScreenShare plugin for modern Minecraft."
    group = "io.github.runkang10.openss"
    version = "1.0.0"
    rootProject.extra["configVersion"]

    repositories {
        mavenCentral()
        gradlePluginPortal()

        maven("https://repo.papermc.io/repository/maven-public/") {
            name = "papermc-repo"
        }
        maven("https://oss.sonatype.org/content/groups/public/") {
            name = "sonatype"
        }
        maven("https://jitpack.io")

    }

    dependencies {
        paperweight.paperDevBundle("1.21.4-R0.1-SNAPSHOT")
        implementation("com.github.NEZNAMY", "TAB-API", "5.0.3")
        compileOnly("com.github.NEZNAMY", "TAB-API", "5.0.3")
        implementation("com.github.DevLeoko.AdvancedBan:AdvancedBan:v2.3.0")
        compileOnly("com.github.DevLeoko.AdvancedBan:AdvancedBan:v2.3.0")
        implementation("net.luckperms:api:5.4")
        compileOnly("net.luckperms:api:5.4")
        implementation(kotlin("stdlib-jdk8"))
    }

    tasks {
        assemble {
            dependsOn(reobfJar)
        }
        build {
            dependsOn(assemble)
            dependsOn(shadowJar)
        }
        jar {
            enabled = false
        }
    }

    kotlin {
        jvmToolchain(21)
    }
}