package hashmap.core

class HashKey<T>(private val value: T) {
    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HashKey<*>

        return value == other.value
    }
}