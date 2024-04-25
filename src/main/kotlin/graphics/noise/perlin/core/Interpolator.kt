package graphics.noise.perlin.core

class Interpolator<T : SpatialData> {

    fun interpolate(position: T, boundaries: List<Coordinate>): Coordinate = interpolate(
        position = position,
        boundaries = boundaries,
        index = 0
    )

    private fun interpolate(position: T, boundaries: List<Coordinate>, index: Int): Coordinate =
        if (index >= position.size) boundaries[0]
        else interpolate(
            position = position,
            boundaries = boundaries.chunked(2).map { interpolate(it[0], it[1], position[index]) },
            index = index + 1
        )

    private fun interpolate(lowPoint: Coordinate, highPoint: Coordinate, distanceFromLowPoint: Coordinate): Coordinate =
        lowPoint + distanceFromLowPoint * (highPoint - lowPoint)

}
