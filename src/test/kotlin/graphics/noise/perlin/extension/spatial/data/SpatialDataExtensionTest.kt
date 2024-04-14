package graphics.noise.perlin.extension.spatial.data

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SpatialDataExtensionTest {
    @Test
    fun `should create new 1D spatial data`() {
        val spatialData = SpatialData1D(x = 1)
        assertEquals(spatialData.breed(listOf(2)), SpatialData1D(x = 2))
    }

    @Test
    fun `should create new 2D spatial data`() {
        val spatialData = SpatialData2D(x = 1, y = 1)
        assertEquals(spatialData.breed(listOf(2, 2)), SpatialData2D(x = 2, y = 2))
    }

    @Test
    fun `should create new 3D spatial data`() {
        val spatialData = SpatialData3D(x = 1, y = 1, z = 1)
        assertEquals(spatialData.breed(listOf(2, 2, 2)), SpatialData3D(x = 2, y = 2, z = 2))
    }
}