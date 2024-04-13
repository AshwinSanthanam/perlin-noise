package core.space

import core.point.SpatialData

data class Space<T> (val dimension: T) where T : SpatialData {

    val points get() = Points.generate(dimension)

    val boundaries get() = Boundary.generate(dimension)

}
