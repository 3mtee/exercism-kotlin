pluginManagement {
    val kotlinVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion
    }
}

rootProject.name = "exercism-kotlin"
include(
    "hello-world",
    "rna-transcription",
    "pangram",
    "two-fer",
    "hamming",
    "raindrops",
    "isogram"
)
