package graphics.noise.perlin.extension.spatial.data

import graphics.noise.perlin.core.SpatialData

data class SpatialData3D(
    val x: Int,
    val y: Int,
    val z: Int
) : SpatialData() {
    override val data = arrayOf(x, y, z)
}