package graphics.noise.perlin.extension.spatial.data

import graphics.noise.perlin.core.Coordinate
import graphics.noise.perlin.core.SpatialData

data class SpatialData2D(
    val x: Coordinate,
    val y: Coordinate
) : SpatialData() {
    override val data = listOf(x, y)

    override fun breed(data: List<Coordinate>): SpatialData = SpatialData2D(x = data[0], y = data[1])
}
