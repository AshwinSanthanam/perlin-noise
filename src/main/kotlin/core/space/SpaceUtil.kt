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


internal object Boundary {
    private val boundaryMap = HashMap<SpatialData, List<SpatialData>>()

    @Suppress("UNCHECKED_CAST")
    fun <T> generate(dimension: T): List<T> where T : SpatialData =
        boundaryMap[dimension] as List<T>? ?: generateInternal<T>(dimension).also { boundaryMap[dimension] = it }

    private fun <T> generateInternal(dimension: SpatialData): List<T> where T : SpatialData = (0..<(1 shl dimension.data.size))
        .map { Integer.toBinaryString(it) }
        .map { binaryString -> binaryString
            .map { it == '1' }
            .leftPadding(size = dimension.data.size - binaryString.length)
        }.map { rawBoundary -> rawBoundary
            .zip(dimension.data)
            .map {
                if (it.first) it.second
                else 0
            }
        }
        .map { SpatialData.factory(it) }

    private fun List<Boolean>.leftPadding(size: Int) = MutableList(size) { false } + this
}
