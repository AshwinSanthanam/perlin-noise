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
            interpolator.interpolate(space.relative(point), dotProducts)
        }
        val min = noise.min()
        val max = noise.max()
        return noise.map { (it - min) / (max - min) }
    }
}