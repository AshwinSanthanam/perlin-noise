package graphics.noise.perlin.core

class NoiseFragment<T : SpatialData>(
    private val space: Space<T>,
    private val gradientVectors: List<T>,
    private val interpolator: Interpolator<T>
) {
    fun noise(): List<Double> {
        val noise = space.points.map { point ->
            val distanceVectors = space.boundaries.map { point - it }
            val dotProducts = distanceVectors.zip(gradientVectors).map { it.first * it.second }
            interpolator.interpolate(space.relative(point), dotProducts).value
        }
        val min = noise.minOf { it }
        val max = noise.maxOf { it }
        return noise.map { (it - min) / (max - min) }
    }
}