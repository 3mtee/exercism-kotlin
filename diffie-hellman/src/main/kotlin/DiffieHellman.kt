import java.math.BigInteger
import java.util.*

object DiffieHellman {

    fun privateKey(prime: BigInteger): BigInteger {
        var key: BigInteger
        do {
            key = BigInteger(prime.bitLength(), Random())
        } while (key < BigInteger.ONE || key >= prime)
        return key
    }

    fun publicKey(p: BigInteger, g: BigInteger, privateKey: BigInteger): BigInteger = g.modPow(privateKey, p)

    fun secret(prime: BigInteger, publicKey: BigInteger, privateKey: BigInteger): BigInteger =
        publicKey.modPow(privateKey, prime)
}
