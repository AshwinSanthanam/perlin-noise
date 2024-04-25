package graphics.noise.perlin.extension.spatial.data

import graphics.noise.perlin.core.SpatialData

data class SpatialData2D(
    val x: Double,
    val y: Double
) : SpatialData() {
    override val data = listOf(x, y)

    override fun breed(data: List<Double>): SpatialData = SpatialData2D(x = data[0], y = data[1])
}
