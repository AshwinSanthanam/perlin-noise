package graphics.noise.perlin.core

class Space<T>(
    private val dimension: T
) where T : SpatialData {

    val points get() = points(axis = 0, coordinates = emptyList())

    val boundaries get() = boundary()

    @Suppress("UNCHECKED_CAST")
    fun relative(point: T): T = (point / dimension) as T

    @Suppress("UNCHECKED_CAST")
    private fun points(axis: Int, coordinates: List<Double>): List<T> =
        if (axis >= dimension.size) listOf(dimension.breed(coordinates) as T)
        else (0 ..< dimension[axis].toInt()).map(Int::toDouble).flatMap {
            points(axis = axis + 1, coordinates = coordinates + it)
        }

    @Suppress("UNCHECKED_CAST")
    private fun boundary(): List<T> = (0..<(1 shl dimension.size)).asSequence()
        .map { Integer.toBinaryString(it) }
        .map { it.map { char -> char == '1' } }
        .map { it.leftPadding(size = dimension.size - it.size) }
        .map { it.zip(dimension) }
        .map { it.map { pair -> if (pair.first) pair.second else 0.0 } }
        .map { dimension.breed(it) as T }
        .toList()

    private fun List<Boolean>.leftPadding(size: Int) = MutableList(size) { false } + this
}

class SpaceCache<T> where T : SpatialData {
    private val spaceMap = HashMap<T, Space<T>>()

    fun getOrCreate(dimension: T): Space<T> =
        spaceMap[dimension] ?: Space(dimension).also { spaceMap[dimension] = it  }
}
