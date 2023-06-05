package hashmap

class HashMapFirstRealization(size: Int) {
    private val array = Array<String?>(size) { null }

    fun put(key: Int, value: String) {
        if (key >= array.size) throw IllegalStateException("Array index out of bounds")

        array[key] = value
    }

    fun get(key: Int): String? {
        if (key >= array.size) return null

        return array[key]
    }
}

fun main() {
    val hashMap = HashMapFirstRealization(size = 18)

    hashMap.put(0, "Hello World")
    hashMap.put(1, "Hello World 1")
    hashMap.put(2, "Hello World 2")
    hashMap.put(17, "Hello World 2")

    println(hashMap.get(0))
    println(hashMap.get(1))
    println(hashMap.get(2))
    println(hashMap.get(3))
}