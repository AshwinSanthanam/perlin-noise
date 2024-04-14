package core.space

import core.point.SpatialData

class Space<T>(
    private val dimension: T
) where T : SpatialData {

    val points get() = points(axis = 0, coordinates = emptyList())

    val boundaries get() = boundary()

    private fun points(axis: Int, coordinates: List<Int>): List<SpatialData> =
        if (axis >= dimension.data.size) listOf(SpatialData.factory(coordinates))
        else (0 ..< dimension.data[axis]).flatMap {
            points(axis = axis + 1, coordinates = coordinates + it)
        }

    private fun boundary(): List<T> = (0..<(1 shl dimension.data.size))
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

class SpaceCache<T> where T : SpatialData {
    private val spaceMap = HashMap<T, Space<T>>()

    fun getOrCreate(dimension: T): Space<T> =
        spaceMap[dimension] ?: Space(dimension).also { spaceMap[dimension] = it  }
}

