package core.space

import core.point.SpatialData

data class Space<T> (val dimension: T) where T : SpatialData {

    val points get() = Points.generate(dimension)

    val boundaries get() = boundaries()

    private fun boundaries(): List<T> = Boundary.generate(dimension)
}
