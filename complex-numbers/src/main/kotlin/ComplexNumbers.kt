import kotlin.math.*

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {
    val abs = sqrt(real * real + imag * imag)

    operator fun plus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(this.real + other.real, this.imag + other.imag)
    }

    operator fun minus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(this.real - other.real, this.imag - other.imag)
    }

    operator fun times(other: ComplexNumber): ComplexNumber {
        val real = this.real * other.real - this.imag * other.imag
        val imag = this.real * other.imag + this.imag * other.real
        return ComplexNumber(real, imag)
    }

    operator fun div(other: ComplexNumber): ComplexNumber {
        val real =
            (this.real * other.real + this.imag * other.imag) / (other.real * other.real + other.imag * other.imag)
        val imag =
            (this.imag * other.real - this.real * other.imag) / (other.real * other.real + other.imag * other.imag)
        return ComplexNumber(real, imag)
    }

    fun conjugate(): ComplexNumber = ComplexNumber(this.real, -this.imag)
}

fun exponential(c: ComplexNumber): ComplexNumber = if (c.real == 0.0) {
    ComplexNumber(cos(c.imag), sin(c.imag))
} else {
    ComplexNumber(E.pow(c.real)) * exponential(ComplexNumber(imag = c.imag))
}
