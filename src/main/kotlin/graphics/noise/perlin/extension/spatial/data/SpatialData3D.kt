package graphics.noise.perlin.extension.spatial.data

import graphics.noise.perlin.core.SpatialData

data class SpatialData3D(
    val x: Double,
    val y: Double,
    val z: Double
) : SpatialData() {
    override val data = listOf(x, y, z)
    override fun breed(data: List<Double>): SpatialData = SpatialData3D(x = data[0], y = data[1], z = data[2])
}