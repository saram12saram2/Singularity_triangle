sealed class DataType {
    data class DoubleType(val value: Double) : DataType()
    data class StringType(val value: String) : DataType()
    data class BooleanType(val value: Boolean) : DataType()
    object UnitType : DataType()

    fun display() {
        when (this) {
            is DoubleType -> println("DoubleType with value $value")
            is StringType -> println("StringType with value $value")
            is BooleanType -> println("BooleanType with value $value")
            is UnitType -> println("UnitType")
        }
    }
}

fun <T> T.displayTypeInfo() {
    when (this) {
        is String -> println("String: $this")
        is Int -> println("Int: $this")
        is Long -> println("Long: $this")
        is Double -> println("Double: $this")
        is Float -> println("Float: $this")
        is Boolean -> println("Boolean: $this")
        is Char -> println("Char: $this")
        is Array<*> -> println("Array of ${this.javaClass.simpleName}: ${this.contentToString()}")
        is List<*> -> println("List: $this")
        is Set<*> -> println("Set: $this")
        is Map<*, *> -> println("Map: $this")
        is DataType -> this.display()
        else -> println("Other type: $this")
    }
}

fun main() {
    "Hello, Kotlin!".displayTypeInfo()
    123.displayTypeInfo()
    3.14159.displayTypeInfo()
    true.displayTypeInfo()
    arrayOf(1, 2, 3).displayTypeInfo()
    listOf("apple", "banana", "cherry").displayTypeInfo()
    setOf("Astana", "Almaty", "Karaganda").displayTypeInfo()
    mapOf("a" to 1, "b" to 2, "c" to 3).displayTypeInfo()
    DataType.DoubleType(99.99).displayTypeInfo()
    DataType.StringType("Kotlin").displayTypeInfo()
    DataType.BooleanType(true).displayTypeInfo()
    DataType.UnitType.displayTypeInfo()
}
