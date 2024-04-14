package graphics.noise.perlin.extension.spatial.data

import graphics.noise.perlin.core.SpatialData

data class SpatialData2D(
    val x: Int,
    val y: Int
) : SpatialData {
    override val data = arrayOf(x, y)
}
