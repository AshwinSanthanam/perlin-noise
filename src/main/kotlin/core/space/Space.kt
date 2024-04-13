package core.space

import core.point.SpatialData

data class Space<T> (
    val dimension: T,
    val position: T
) where T : SpatialData {

    val points by lazy { points(0, emptyList()) }

    val boundaries by lazy { boundaries() }

    private val size by lazy { dimension.data.size }

    private fun points(axis: Int, coordinates: List<Int>): List<T> {
        if (axis >= dimension.data.size) return listOf(SpatialData.spatialDataFactory(coordinates))
        return (0 ..< dimension.data[axis]).flatMap {
            points(axis + 1, coordinates + (it + position.data[axis]))
        }
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
        .map { SpatialData.spatialDataFactory(it) }
}

internal object RawBoundary {
    private val rawBoundaryMap = HashMap<Int, RawBoundaryType>()

    fun generate(dimensions: Int): RawBoundaryType {
        return if (!rawBoundaryMap.containsKey(dimensions)) {
            rawBoundaryInternal(dimensions).also { rawBoundaryMap[dimensions] = it }
        } else rawBoundaryMap[dimensions]!!
    }

    private fun rawBoundaryInternal(dimensions: Int) = (0..<(1 shl dimensions))
        .map { Integer.toBinaryString(it) }
        .map { binaryString -> binaryString
            .map { it == '1' }
            .leftPadding(size = dimensions - binaryString.length)
        }

    private fun List<Boolean>.leftPadding(size: Int) = MutableList(size) { false }.plus(this)
}

internal typealias RawBoundaryType = List<List<Boolean>>
