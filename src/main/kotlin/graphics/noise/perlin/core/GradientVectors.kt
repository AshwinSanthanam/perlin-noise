package graphics.noise.perlin.core

@Suppress("UNCHECKED_CAST")
class GradientVectors<SpatialDataType>(
    private val dimension: SpatialDataType,
    private val coordinateGenerator: () -> Coordinate
) : Iterable<SpatialDataType> where SpatialDataType : SpatialData {

    private val size = 1 shl dimension.size

    private var currentIndex = 0

    override fun iterator(): Iterator<SpatialDataType> = object : Iterator<SpatialDataType> {
        override fun hasNext(): Boolean = currentIndex < size

        override fun next(): SpatialDataType =
            dimension.breed(MutableList(dimension.size) { coordinateGenerator.invoke() }).also { currentIndex++ } as SpatialDataType
    }
}
