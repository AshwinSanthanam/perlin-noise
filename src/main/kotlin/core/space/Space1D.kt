package graphics.noise.perlin.core.space

import graphics.noise.perlin.core.point.SpatialData

class Space1D(
    override val dimension: SpatialData,
    override val position: SpatialData
) : Space()