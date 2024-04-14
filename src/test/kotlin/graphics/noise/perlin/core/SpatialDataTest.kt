package graphics.noise.perlin.core

import graphics.noise.perlin.extension.spatial.data.SpatialData1D
import graphics.noise.perlin.extension.spatial.data.SpatialData2D
import graphics.noise.perlin.extension.spatial.data.SpatialData3D
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpatialDataTest {
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
}