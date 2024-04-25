package graphics.noise.perlin.extension.spatial.data

import graphics.noise.perlin.core.Coordinate
import graphics.noise.perlin.core.SpatialData

data class SpatialData3D(
    val x: Coordinate,
    val y: Coordinate,
    val z: Coordinate
) : SpatialData() {
    override val data = listOf(x, y, z)
    override fun breed(data: List<Coordinate>): SpatialData = SpatialData3D(x = data[0], y = data[1], z = data[2])
}