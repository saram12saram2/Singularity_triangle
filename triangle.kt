import kotlin.math.*

data class Point(val x: Double, val y: Double)

class Triangle(private var p1: Point, private var p2: Point, private var p3: Point) {
    init {
        if (isCollinear()) {
            throw IllegalArgumentException("The vertices must not be collinear.")
        }
    }

    fun print() {
        println("Triangle vertices:")
        println("P1: $p1")
        println("P2: $p2")
        println("P3: $p3")
    }

    val perimeter: Double
        get() = p1.distanceTo(p2) + p2.distanceTo(p3) + p3.distanceTo(p1)

    val area: Double
        get() = abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)) / 2)

    private fun isCollinear(): Boolean = area == 0.0

    fun rotate(degrees: Double) {
        val radians = Math.toRadians(degrees)
        val center = findCenter()

        p1 = p1.rotatePoint(center, radians)
        p2 = p2.rotatePoint(center, radians)
        p3 = p3.rotatePoint(center, radians)
    }

    private fun Point.distanceTo(other: Point): Double =
        sqrt((other.x - this.x).pow(2) + (other.y - this.y).pow(2))

    private fun findCenter(): Point =
        Point((p1.x + p2.x + p3.x) / 3, (p1.y + p2.y + p3.y) / 3)

    private fun Point.rotatePoint(center: Point, radians: Double): Point {
        val dx = this.x - center.x
        val dy = this.y - center.y
        val rotatedX = dx * cos(radians) - dy * sin(radians) + center.x
        val rotatedY = dx * sin(radians) + dy * cos(radians) + center.y
        return Point(rotatedX, rotatedY)
    }
}

fun main() {
    val triangle = Triangle(Point(1.0, 1.0), Point(1.0, 3.0), Point(3.0, 1.0))
    println("perimeter: ${triangle.perimeter}")
    println("area: ${triangle.area}")
    println("Before rotation:")
    triangle.print()

    triangle.rotate(180.0)
    println("After rotation:")
    triangle.print()
}
