package graphics.noise.perlin.extension.spatial.data

import graphics.noise.perlin.core.SpatialData
import graphics.noise.perlin.core.SpatialDataFactory

@Suppress("UNCHECKED_CAST")
class SpatialDataFactoryExtension : SpatialDataFactory() {

    override fun <T : SpatialData> extension(data: List<Int>): T? = when (data.size) {
        1 -> SpatialData1D(x = data[0])
        2 -> SpatialData2D(x = data[0], y = data[1])
        3 -> SpatialData3D(x = data[0], y = data[1], z = data[2])
        else -> null
    } as T?
}