pluginManagement {
    val kotlinVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion
    }
}

rootProject.name = "exercism-kotlin"
include("hello-world")
include("rna-transcription")
include("pangram")
include("two-fer")

