package core.point

data class SpatialData1D(
    val x: Int
) : SpatialData {
    override val data = arrayOf(x)
}
