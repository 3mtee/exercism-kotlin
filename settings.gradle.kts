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
    "saddle-points",
    "darts",
    "flatten-array",
    "minesweeper",
    "word-count",
    "crypto-square",
    "robot-name",
    "dominoes",
    "rotational-cipher",
    "wordy",
    "run-length-encoding",
    "bank-account",
    "scale-generator",
    "linked-list",
    "perfect-numbers",
    "sum-of-multiples",
    "sieve",
    "yacht",
    "binary-search",
    "grains",
    "robot-simulator",
    "forth",
    "collatz-conjecture",
    "nth-prime",
    "prime-factors",
    "pascals-triangle",
    "complex-numbers",
    "kindergarten-garden",
    "all-your-base",
    "clock",
    "spiral-matrix",
    "matching-brackets",
    "change",
    "etl",
    "grade-school",
    "binary-search-tree",
    "atbash-cipher",
    "say",
    "simple-cipher",
    "rail-fence-cipher",
    "affine-cipher"
)
