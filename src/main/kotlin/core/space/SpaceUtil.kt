package core.space

import core.point.SpatialData

internal object Points {
    private val pointsMap = HashMap<SpatialData, List<SpatialData>>()

    fun generate(dimension: SpatialData): List<SpatialData> =
        pointsMap[dimension] ?: generate(dimension = dimension, axis = 0, coordinates = emptyList()).also { pointsMap[dimension] = it }

    private fun generate(dimension: SpatialData, axis: Int, coordinates: List<Int>): List<SpatialData> =
        if (axis >= dimension.data.size) listOf(SpatialData.factory(coordinates))
        else (0 ..< dimension.data[axis]).flatMap {
            generate(dimension = dimension, axis = axis + 1, coordinates = coordinates + it)
        }
}


internal object RawBoundary {
    private val rawBoundaryMap = HashMap<Int, RawBoundaryType>()

    fun generate(dimensions: Int): RawBoundaryType =
        rawBoundaryMap[dimensions] ?: rawBoundary(dimensions).also { rawBoundaryMap[dimensions] = it }

    private fun rawBoundary(dimensions: Int) = (0..<(1 shl dimensions))
        .map { Integer.toBinaryString(it) }
        .map { binaryString -> binaryString
            .map { it == '1' }
            .leftPadding(size = dimensions - binaryString.length)
        }

    private fun List<Boolean>.leftPadding(size: Int) = MutableList(size) { false } + this
}

internal typealias RawBoundaryType = List<List<Boolean>>