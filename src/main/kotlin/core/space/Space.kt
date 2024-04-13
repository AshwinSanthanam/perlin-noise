package core.space

import core.point.SpatialData

data class Space<T> (val dimension: T) where T : SpatialData {

    val points get() = Points.generate(dimension)

    val boundaries get() = boundaries()

    private val size get() = dimension.data.size

    private fun boundaries(): List<T> = RawBoundary.generate(size)
        .map { rawBoundary -> rawBoundary
            .zip(dimension.data)
            .map {
                if (it.first) it.second
                else 0
            }
        }
        .map { SpatialData.factory(it) }
}
