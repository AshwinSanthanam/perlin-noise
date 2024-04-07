package core

import core.point.SpatialData1D
import core.point.SpatialData2D
import core.point.SpatialData3D
import graphics.noise.perlin.core.boundary.SpatialBoundary1D
import graphics.noise.perlin.core.boundary.SpatialBoundary2D
import graphics.noise.perlin.core.boundary.SpatialBoundary3D
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SpatialBoundaryTest {

    @Test
    fun `should return two boundaries for 1D`() {
        val spatialBoundary = SpatialBoundary1D(boundary0 = SpatialData1D(x = 1), boundary1 = SpatialData1D(x = 2))
        assertEquals(listOf(SpatialData1D(x = 1), SpatialData1D(x = 2)), spatialBoundary.boundaries)
    }

    @Test
    fun `should return two boundaries for 2D`() {
        val spatialBoundary = SpatialBoundary2D(
            boundary00 = SpatialData2D(x = 1, y = 1),
            boundary01 = SpatialData2D(x = 2, y = 2),
            boundary10 = SpatialData2D(x = 3, y = 3),
            boundary11 = SpatialData2D(x = 4, y = 4)
        )
        assertEquals(listOf(
            SpatialData2D(x = 1, y = 1),
            SpatialData2D(x = 2, y = 2),
            SpatialData2D(x = 3, y = 3),
            SpatialData2D(x = 4, y = 4)
        ), spatialBoundary.boundaries)
    }

    @Test
    fun `should return two boundaries for 3D`() {
        val spatialBoundary = SpatialBoundary3D(
            boundary000 = SpatialData3D(x = 1, y = 1, z = 1),
            boundary001 = SpatialData3D(x = 2, y = 2, z = 2),
            boundary010 = SpatialData3D(x = 3, y = 3, z = 3),
            boundary011 = SpatialData3D(x = 4, y = 4, z = 4),
            boundary100 = SpatialData3D(x = 5, y = 5, z = 5),
            boundary101 = SpatialData3D(x = 6, y = 6, z = 6),
            boundary110 = SpatialData3D(x = 7, y = 7, z = 7),
            boundary111 = SpatialData3D(x = 8, y = 8, z = 8)
        )
        assertEquals(listOf(
            SpatialData3D(x = 1, y = 1, z = 1),
            SpatialData3D(x = 2, y = 2, z = 2),
            SpatialData3D(x = 3, y = 3, z = 3),
            SpatialData3D(x = 4, y = 4, z = 4),
            SpatialData3D(x = 5, y = 5, z = 5),
            SpatialData3D(x = 6, y = 6, z = 6),
            SpatialData3D(x = 7, y = 7, z = 7),
            SpatialData3D(x = 8, y = 8, z = 8)
        ), spatialBoundary.boundaries)
    }
}