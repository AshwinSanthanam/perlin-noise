package graphics.noise.perlin.extension.spatial.data

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SpatialDataFactoryExtensionTest {

    @Test
    fun `should return SpatialData1D`() {
        assertEquals(SpatialData1D(x = 1), SpatialDataFactoryExtension().create(listOf(1)))
    }

    @Test
    fun `should return SpatialData2D`() {
        assertEquals(SpatialData2D(x = 1, y = 2), SpatialDataFactoryExtension().create(listOf(1, 2)))
    }

    @Test
    fun `should return SpatialData3D`() {
        assertEquals(SpatialData3D(x = 1, y = 2, z = 3), SpatialDataFactoryExtension().create(listOf(1, 2, 3)))
    }

}