package graphics.noise.perlin.core

class Interpolator<T : SpatialData> {

    fun interpolate(position: T, boundaries: List<Double>): Double = interpolate(
        position = position,
        boundaries = boundaries,
        index = 0
    )

    private fun interpolate(position: T, boundaries: List<Double>, index: Int): Double =
        if (index >= position.size) boundaries[0]
        else interpolate(
            position = position,
            boundaries = boundaries.chunked(2).map { interpolate(it[0], it[1], position[index]) },
            index = index + 1
        )

    private fun interpolate(lowPoint: Double, highPoint: Double, distanceFromLowPoint: Double): Double =
        lowPoint + distanceFromLowPoint * (highPoint - lowPoint)

}
