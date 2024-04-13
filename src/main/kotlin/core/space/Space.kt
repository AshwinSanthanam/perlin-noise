package core.space

import core.point.SpatialData

data class Space<T> (
    val dimension: T,
    val position: T
) where T : SpatialData {

    val points by lazy { points(0, emptyList()) }

    val boundaries by lazy { boundaries() }

    private val size by lazy { dimension.data.size }

    private fun points(axis: Int, coordinates: List<Int>): List<T> =
        if (axis >= dimension.data.size) listOf(SpatialData.factory(coordinates))
        else (0 ..< dimension.data[axis]).flatMap {
            points(axis = axis + 1, coordinates = coordinates + (it + position.data[axis]))
        }

    private fun boundaries(): List<T> = RawBoundary.generate(size)
        .map { rawBoundary -> rawBoundary
            .zip(dimension.data)
            .map {
                if (it.first) it.second
                else 0
            }
        }
        .map { boundaries -> boundaries
            .zip(position.data)
            .map { it.first + it.second }
        }
        .map { SpatialData.factory(it) }
}
