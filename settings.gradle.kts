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
    "isogram",
    "pig-latin",
    "anagram",
    "diamond",
    "bob",
    "beer-song",
    "resistor-color",
    "resistor-color-duo",
    "acronym",
    "reverse-string",
    "dnd-character",
    "gigasecond",
    "luhn",
    "scrabble-score",
    "largest-series-product"
)
