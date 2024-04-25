package graphics.noise.perlin.extension.spatial.data

import graphics.noise.perlin.core.SpatialData

data class SpatialData1D(
    val x: Double
) : SpatialData() {
    override val data = listOf(x)

    override fun breed(data: List<Double>): SpatialData {
        return SpatialData1D(data[0])
    }
}
