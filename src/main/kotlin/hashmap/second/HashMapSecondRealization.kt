package hashmap.second

class HashMapSecondRealization {
    private val values = Array<String?>(16) { null }
    private val keys = Array<Int?>(16) { null }
    private var currentHashIndex = 0

    fun <T> put(key: HashKey<T>, value: String) {
        val hashCode = key.hashCode()
        addHashCode(hashCode)

        values[getArrayHashIndexByHashCode(hashCode)] = value
    }

    fun <T> get(key: HashKey<T>): String? {
        val hashCode = key.hashCode()
        if (getArrayHashIndexByHashCode(hashCode) >= values.size) return null

        return values[getArrayHashIndexByHashCode(hashCode)]
    }

    fun getAll(): Array<String?> {
        return values
    }

    fun getAllKeys(): Array<Int?> {
        return keys
    }

    private fun getArrayHashIndexByHashCode(hashCode: Int): Int {
        var value: Int? = null

        for (index in 0..currentHashIndex) {
            if (keys[index] == hashCode) {
                value = index
            }
        }

        if (value == null) throw IllegalStateException("Array key index was not found")
        return value
    }

    private fun addHashCode(hashCode: Int) {
        keys[currentHashIndex] = hashCode
        currentHashIndex++
    }

}

fun main() {
    val hashMap = HashMapSecondRealization()

    hashMap.put(HashKey(0), "Hello World 1")
    hashMap.put(HashKey("1"), "Hello World 2")
    hashMap.put(HashKey(5), "Hello World 3")
    hashMap.put(HashKey(true), "Hello World 4")

    println(hashMap.get(HashKey(0)))
    println(hashMap.get(HashKey("1")))
    println(hashMap.get(HashKey(5)))
    println(hashMap.get(HashKey(true)))
}
