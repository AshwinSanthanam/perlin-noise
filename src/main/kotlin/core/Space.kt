package core

import core.point.SpatialData

data class Space<T> (
    val dimension: T,
    val position: T
) where T : SpatialData {

    val points = points(0, emptyList())

    val boundaries: List<T> = boundaries()

    private val size get() = dimension.data.size

    private fun points(axis: Int, coordinates: List<Int>): List<T> {
        if (axis >= dimension.data.size) return listOf(SpatialData.spatialDataFactory(coordinates))
        return (0 ..< dimension.data[axis]).flatMap {
            points(axis + 1, coordinates + (it + position.data[axis]))
        }
    }

    private fun boundaries(): List<T> = rawBoundaries(size)
        .map { rawBoundaries -> rawBoundaries
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
        .map { SpatialData.spatialDataFactory(it) }

    private fun rawBoundaries(dimensions: Int) = (0..<(1 shl dimensions))
        .map { Integer.toBinaryString(it) }
        .map { binaryString -> binaryString
            .map { it == '1' }
            .leftPadding(size = dimensions - binaryString.length)
        }

    private fun List<Boolean>.leftPadding(size: Int) = MutableList(size) { false }.plus(this)

}