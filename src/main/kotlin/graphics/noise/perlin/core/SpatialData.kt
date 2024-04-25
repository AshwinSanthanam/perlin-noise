package graphics.noise.perlin.core

abstract class SpatialData : Iterable<Double> {
    protected abstract val data: List<Double>

    abstract fun breed(data: List<Double>): SpatialData

    val size get() = data.size

    override fun iterator(): Iterator<Double> = data.iterator()

    operator fun get(index: Int): Double = data[index]

    infix operator fun minus(other: SpatialData): SpatialData = spatialBinaryOperation(other, Double::minus)

    infix operator fun times(other: SpatialData): Double = spatialBinaryOperation(other, Double::times).reduce(Double::plus)

    infix operator fun div(other: SpatialData): SpatialData = spatialBinaryOperation(other, Double::div)

    private fun spatialBinaryOperation(other: SpatialData, coordinateBinaryOperation: (Double, Double) -> Double): SpatialData =
        this.zip(other).map { coordinateBinaryOperation.invoke(it.first, it.second) }.let { breed(it) }
}
