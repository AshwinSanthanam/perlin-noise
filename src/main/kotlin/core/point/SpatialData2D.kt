package graphics.noise.perlin.core.point

data class SpatialData2D(
    val x: Int,
    val y: Int
) : SpatialData {
    override val data = arrayOf(x, y)
}
