package graphics.noise.perlin.extension.spatial.data

import graphics.noise.perlin.core.SpatialData

data class SpatialData1D(
    val x: Int
) : SpatialData() {
    override val data = arrayOf(x)
}
