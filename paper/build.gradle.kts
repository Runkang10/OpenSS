dependencies {
    paperweight.paperDevBundle("1.21.4-R0.1-SNAPSHOT")
}

tasks.shadowJar {
    archiveBaseName.set("OpenSS-PAPER")
    archiveClassifier.set("")
    archiveVersion.set(project.version.toString())
}

tasks.processResources {
    val data = mapOf(
        "name" to rootProject.name,
        "description" to description,
        "prefix" to rootProject.extra["prefix"] as String,
        "version" to version,
        "configVersion" to rootProject.extra["configVersion"] as String
    )
    filteringCharset = "UTF-8"
    inputs.properties(data)
    filesMatching("**/paper-plugin.yml") {
        expand(data)
    }
}
