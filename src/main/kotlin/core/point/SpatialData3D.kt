package core.point

data class SpatialData3D(
    val x: Int,
    val y: Int,
    val z: Int
) : SpatialData {
    override val data = arrayOf(x, y, z)
}