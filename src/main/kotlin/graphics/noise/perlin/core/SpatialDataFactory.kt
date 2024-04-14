package graphics.noise.perlin.core

@Suppress("UNCHECKED_CAST")
open class SpatialDataFactory {

    fun <T : SpatialData> create(data: List<Int>): T = extension(data) ?: default(data)

    protected open fun <T> extension(data: List<Int>): T? where T : SpatialData = null

    private fun <T> default(data: List<Int>): T where T : SpatialData =  object : SpatialData() {
        override val data get() = data
    } as T
}
