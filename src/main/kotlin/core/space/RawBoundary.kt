package core.space

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