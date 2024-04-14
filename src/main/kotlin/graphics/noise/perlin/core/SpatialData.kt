package graphics.noise.perlin.core

abstract class SpatialData : Iterable<Int> {
    protected abstract val data: List<Int>

    val size get() = data.size

    override fun iterator(): Iterator<Int> = data.iterator()

    operator fun get(index: Int): Int = data[index]
}
