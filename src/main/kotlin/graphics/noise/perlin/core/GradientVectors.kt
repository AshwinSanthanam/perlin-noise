package graphics.noise.perlin.core

class GradientVectors<SpatialDataType>(
    private val dimension: SpatialDataType,
    private val numberGenerator: () -> Int
) : Iterable<SpatialDataType> where SpatialDataType : SpatialData {

    private val size = 1 shl dimension.size

    private var currentIndex = 0

    override fun iterator(): Iterator<SpatialDataType> = object : Iterator<SpatialDataType> {
        override fun hasNext(): Boolean = currentIndex < size

        override fun next(): SpatialDataType =
            SpatialData.factory<SpatialDataType>(MutableList(dimension.size) { numberGenerator.invoke() }).also { currentIndex++ }
    }
}
