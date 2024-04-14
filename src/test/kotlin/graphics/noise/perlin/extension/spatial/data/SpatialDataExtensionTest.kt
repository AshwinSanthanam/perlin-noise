package graphics.noise.perlin.extension.spatial.data

import graphics.noise.perlin.core.SpatialData
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SpatialDataExtensionTest {

    @Test
    fun `should return x value in array`() {
        val spatialData1D: SpatialData = SpatialData1D(1)
        assertEquals(listOf(1), spatialData1D.toList())
    }

    @Test
    fun `should return the x, y values in an array`() {
        val spatialData2D: SpatialData = SpatialData2D(1, 2)
        assertEquals(listOf(1, 2), spatialData2D.toList())
    }

    @Test
    fun `should return x, y, z value in array`() {
        val spatialData3D: SpatialData = SpatialData3D(x = 1, y = 2, z = 3)
        assertEquals(listOf(1, 2, 3), spatialData3D.toList())
    }

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