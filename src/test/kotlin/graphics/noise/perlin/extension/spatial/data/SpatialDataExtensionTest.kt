package graphics.noise.perlin.extension.spatial.data

import graphics.noise.perlin.core.Coordinate
import graphics.noise.perlin.core.SpatialData
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SpatialDataExtensionTest {

    @Test
    fun `should return x value in array`() {
        val spatialData1D: SpatialData = SpatialData1D(x = Coordinate(1))
        assertEquals(listOf(Coordinate(1)), spatialData1D.toList())
    }

    @Test
    fun `should return the x, y values in an array`() {
        val spatialData2D: SpatialData = SpatialData2D(x = Coordinate(1), y = Coordinate(2))
        assertEquals(listOf(
            Coordinate(1),
            Coordinate(2)
        ), spatialData2D.toList())
    }

    @Test
    fun `should return x, y, z value in array`() {
        val spatialData3D: SpatialData = SpatialData3D(x = Coordinate(1), y = Coordinate(2), z = Coordinate(3))
        assertEquals(listOf(
            Coordinate(1),
            Coordinate(2),
            Coordinate(3)
        ), spatialData3D.toList())
    }

    @Test
    fun `should create new 1D spatial data`() {
        val spatialData = SpatialData1D(x = Coordinate(1))
        assertEquals(spatialData.breed(listOf(Coordinate(2))), SpatialData1D(x = Coordinate(2)))
    }

    @Test
    fun `should create new 2D spatial data`() {
        val spatialData = SpatialData2D(x = Coordinate(1), y = Coordinate(1))
        assertEquals(spatialData.breed(listOf(
            Coordinate(2),
            Coordinate(2)
        )), SpatialData2D(x = Coordinate(2), y = Coordinate(2)))
    }

    @Test
    fun `should create new 3D spatial data`() {
        val spatialData = SpatialData3D(x = Coordinate(1), y = Coordinate(1), z = Coordinate(1))
        assertEquals(spatialData.breed(listOf(
            Coordinate(2),
            Coordinate(2),
            Coordinate(2)
        )), SpatialData3D(x = Coordinate(2), y = Coordinate(2), z = Coordinate(2)))
    }
}