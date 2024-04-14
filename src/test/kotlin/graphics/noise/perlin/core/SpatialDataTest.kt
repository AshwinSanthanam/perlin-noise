package graphics.noise.perlin.core

import graphics.noise.perlin.extension.spatial.data.SpatialData1D
import graphics.noise.perlin.extension.spatial.data.SpatialData2D
import graphics.noise.perlin.extension.spatial.data.SpatialData3D
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpatialDataTest {
    @Test
    fun `should return x value in array`() {
        val spatialData1D: SpatialData = SpatialData1D(1)
        assertArrayEquals(arrayOf(1), spatialData1D.data)
    }

    @Test
    fun `should return the x, y values in an array`() {
        val spatialData2D: SpatialData = SpatialData2D(1, 2)
        assertArrayEquals(arrayOf(1, 2), spatialData2D.data)
    }

    @Test
    fun `should return x, y, z value in array`() {
        val spatialData3D: SpatialData = SpatialData3D(x = 1, y = 2, z = 3)
        assertArrayEquals(arrayOf(1, 2, 3), spatialData3D.data)
    }

    @Test
    fun `should return SpatialData1D`() {
        assertEquals(SpatialData1D(x = 1), SpatialData.factory(listOf(1)))
    }

    @Test
    fun `should return SpatialData2D`() {
        assertEquals(SpatialData2D(x = 1, y = 2), SpatialData.factory(listOf(1, 2)))
    }

    @Test
    fun `should return SpatialData3D`() {
        assertEquals(SpatialData3D(x = 1, y = 2, z = 3), SpatialData.factory(listOf(1, 2, 3)))
    }
}