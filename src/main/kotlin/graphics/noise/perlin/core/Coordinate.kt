package graphics.noise.perlin.core

data class Coordinate(val value: Double) {
    constructor(value: Int): this(value.toDouble())

    infix operator fun rangeUntil(other: Coordinate): Iterable<Coordinate> {
        return (this.value.toInt() ..< other.value.toInt()).map { Coordinate(it) }
    }

    infix operator fun minus(other: Coordinate): Coordinate = Coordinate(this.value - other.value)

    infix operator fun times(other: Coordinate): Coordinate = Coordinate(this.value * other.value)

    companion object {
        val ORIGIN get() = Coordinate(0.0)
    }
}