package graphics.noise.perlin.core

data class Coordinate(val value: Double) {
    constructor(value: Int): this(value.toDouble())

    infix operator fun rangeUntil(other: Coordinate): Iterable<Coordinate> {
        return (this.value.toInt() ..< other.value.toInt()).map { Coordinate(it) }
    }

    companion object {
        public val ORIGIN get() = Coordinate(0.0)
    }
}