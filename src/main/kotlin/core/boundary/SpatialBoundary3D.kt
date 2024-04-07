package graphics.noise.perlin.core.boundary

import core.boundary.SpatialBoundary
import core.point.SpatialData3D

data class SpatialBoundary3D(
    val boundary000: SpatialData3D,
    val boundary001: SpatialData3D,
    val boundary010: SpatialData3D,
    val boundary011: SpatialData3D,
    val boundary100: SpatialData3D,
    val boundary101: SpatialData3D,
    val boundary110: SpatialData3D,
    val boundary111: SpatialData3D
) : SpatialBoundary<SpatialData3D> {
    override val boundaries = listOf(
        boundary000,
        boundary001,
        boundary010,
        boundary011,
        boundary100,
        boundary101,
        boundary110,
        boundary111
    )
}