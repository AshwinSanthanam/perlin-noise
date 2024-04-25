package graphics.noise.perlin.extension.spatial.data

import graphics.noise.perlin.core.Coordinate
import graphics.noise.perlin.core.SpatialData

data class SpatialData1D(
    val x: Coordinate
) : SpatialData() {
    override val data = listOf(x)

    override fun breed(data: List<Coordinate>): SpatialData {
        return SpatialData1D(data[0])
    }
}
