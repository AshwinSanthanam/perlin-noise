package graphics.noise.perlin.core

class Interpolator<T : SpatialData> {

    fun interpolate(position: T, boundaries: List<Coordinate>): Coordinate {
        var currentBoundaryList = boundaries
        for (coordinate in position) {
            val newBoundaryList = mutableListOf<Coordinate>()
            for (j in currentBoundaryList.indices step 2) {
                newBoundaryList += interpolate(currentBoundaryList[j], currentBoundaryList[j + 1], coordinate)
            }
            currentBoundaryList = newBoundaryList
        }
        return currentBoundaryList[0]
    }

    private fun interpolate(lowPoint: Coordinate, highPoint: Coordinate, distanceFromLowPoint: Coordinate): Coordinate {
        return lowPoint + distanceFromLowPoint * (highPoint - lowPoint)
    }

}