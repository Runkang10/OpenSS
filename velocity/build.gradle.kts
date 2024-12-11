dependencies {
    compileOnly("com.velocitypowered:velocity-api:3.4.0-SNAPSHOT")
}

tasks.shadowJar {
    archiveBaseName.set("OpenSS-VELOCITY")
    archiveClassifier.set("")
    archiveVersion.set(project.version.toString())
}