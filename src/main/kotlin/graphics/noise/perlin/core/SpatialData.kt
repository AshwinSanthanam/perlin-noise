package graphics.noise.perlin.core

import graphics.noise.perlin.extension.spatial.data.SpatialData1D
import graphics.noise.perlin.extension.spatial.data.SpatialData2D
import graphics.noise.perlin.extension.spatial.data.SpatialData3D

abstract class SpatialData : Iterable<Int> {
    protected abstract val data: Array<Int>

    val size get() = data.size

    override fun iterator(): Iterator<Int> = data.iterator()

    operator fun get(index: Int): Int = data[index]

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun <T> factory(data: List<Int>): T where T : SpatialData {
            return when (data.size) {
                1 -> SpatialData1D(x = data[0])
                2 -> SpatialData2D(x = data[0], y = data[1])
                3 -> SpatialData3D(x = data[0], y = data[1], z = data[2])
                else -> throw NotImplementedError("SpatialData not implemented for ${data.size}")
            } as T
        }
    }
}
