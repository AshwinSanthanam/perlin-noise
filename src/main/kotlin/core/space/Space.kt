package graphics.noise.perlin.core.space

import graphics.noise.perlin.core.point.SpatialData

data class Space(
    val dimension: SpatialData,
    val position: SpatialData
) {
    fun points(): List<SpatialData> {
        return points(0, emptyList())
    }

    private fun points(axis: Int, coordinates: List<Int>): List<SpatialData> {
        if (axis >= dimension.data.size) return listOf(SpatialData.spatialDataFactory(coordinates))
        return (0 ..< dimension.data[axis]).flatMap {
            points(axis + 1, coordinates + (it + position.data[axis]))
        }
    }
}