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
    "largest-series-product",
    "phone-number",
    "nucleotide-count",
    "series",
    "matrix",
    "roman-numerals",
    "isbn-verifier",
    "armstrong-numbers",
    "resistor-color-trio",
    "transpose",
    "difference-of-squares",
    "leap",
    "secret-handshake",
    "space-age",
    "allergies",
    "meetup",
    "custom-set",
    "triangle",
    "saddle-points"
)
