package graphics.noise.perlin.core

abstract class SpatialData : Iterable<Coordinate> {
    protected abstract val data: List<Coordinate>

    abstract fun breed(data: List<Coordinate>): SpatialData

    val size get() = data.size

    override fun iterator(): Iterator<Coordinate> = data.iterator()

    operator fun get(index: Int): Coordinate = data[index]

    infix operator fun minus(other: SpatialData): SpatialData = spatialBinaryOperation(other, Coordinate::minus)

    infix operator fun times(other: SpatialData): SpatialData = spatialBinaryOperation(other, Coordinate::times)

    private fun spatialBinaryOperation(other: SpatialData, coordinateBinaryOperation: (Coordinate, Coordinate) -> Coordinate): SpatialData =
        this.zip(other).map { coordinateBinaryOperation.invoke(it.first, it.second) }.let { breed(it) }
}
