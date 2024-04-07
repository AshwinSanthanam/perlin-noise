package graphics.noise.perlin.core.space

import graphics.noise.perlin.core.point.SpatialData3D

class Space3D(
    override val dimension: SpatialData3D,
    override val position: SpatialData3D
) : Space()
