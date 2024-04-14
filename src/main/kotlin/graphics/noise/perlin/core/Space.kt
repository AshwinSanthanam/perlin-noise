package graphics.noise.perlin.core

class Space<T>(
    private val dimension: T
) where T : SpatialData {

    val points get() = points(axis = 0, coordinates = emptyList())

    val boundaries get() = boundary()

    private fun points(axis: Int, coordinates: List<Int>): List<SpatialData> =
        if (axis >= dimension.size) listOf(SpatialData.factory(coordinates))
        else (0 ..< dimension[axis]).flatMap {
            points(axis = axis + 1, coordinates = coordinates + it)
        }

    private fun boundary(): List<T> = (0..<(1 shl dimension.size)).asSequence()
        .map { Integer.toBinaryString(it) }
        .map { it.map { char -> char == '1' } }
        .map { it.leftPadding(size = dimension.size - it.size) }
        .map { it.zip(dimension) }
        .map { it.map { pair -> if (pair.first) pair.second else 0 } }
        .map { SpatialData.factory<T>(it) }
        .toList()

    private fun List<Boolean>.leftPadding(size: Int) = MutableList(size) { false } + this
}

class SpaceCache<T> where T : SpatialData {
    private val spaceMap = HashMap<T, Space<T>>()

    fun getOrCreate(dimension: T): Space<T> =
        spaceMap[dimension] ?: Space(dimension).also { spaceMap[dimension] = it  }
}

