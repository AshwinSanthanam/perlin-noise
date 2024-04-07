package graphics.noise.perlin.core.boundary

import core.boundary.SpatialBoundary
import core.point.SpatialData2D

data class SpatialBoundary2D(
    val boundary00: SpatialData2D,
    val boundary01: SpatialData2D,
    val boundary10: SpatialData2D,
    val boundary11: SpatialData2D
) : SpatialBoundary<SpatialData2D> {

    override val boundaries = listOf(boundary00, boundary01, boundary10, boundary11)
}