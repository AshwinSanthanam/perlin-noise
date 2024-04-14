package graphics.noise.perlin.extension.spatial.data

import graphics.noise.perlin.core.SpatialData

data class SpatialData2D(
    val x: Int,
    val y: Int
) : SpatialData() {
    override val data = listOf(x, y)

    override fun breed(data: List<Int>): SpatialData = SpatialData2D(x = data[0], y = data[1])
}
