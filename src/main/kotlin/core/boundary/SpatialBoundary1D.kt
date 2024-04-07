package graphics.noise.perlin.core.boundary

import core.boundary.SpatialBoundary
import core.point.SpatialData1D

data class SpatialBoundary1D(
    val boundary0: SpatialData1D,
    val boundary1: SpatialData1D
) : SpatialBoundary<SpatialData1D> {

    override val boundaries = listOf(boundary0, boundary1)
}