package graphics.noise.perlin.core.space

import graphics.noise.perlin.core.point.SpatialData2D

data class Space2D(
    override val dimension: SpatialData2D,
    override val position: SpatialData2D
) : Space()
