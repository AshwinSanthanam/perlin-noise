package core.boundary

import core.point.SpatialData

interface SpatialBoundary<T> where T : SpatialData {
    val boundaries: List<T>
}
