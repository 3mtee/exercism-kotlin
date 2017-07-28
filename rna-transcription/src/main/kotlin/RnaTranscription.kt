val DNA_RNA_MAP = mapOf('G' to 'C', 'C' to 'G', 'T' to 'A', 'A' to 'U')

fun transcribeToRna(dna: String): String {
    return dna.map { DNA_RNA_MAP[it] }.joinToString("")
}
