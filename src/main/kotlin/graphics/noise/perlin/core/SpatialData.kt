package graphics.noise.perlin.core

abstract class SpatialData : Iterable<Coordinate> {
    protected abstract val data: List<Coordinate>

    abstract fun breed(data: List<Coordinate>): SpatialData

    val size get() = data.size

    override fun iterator(): Iterator<Coordinate> = data.iterator()

    operator fun get(index: Int): Coordinate = data[index]
}
