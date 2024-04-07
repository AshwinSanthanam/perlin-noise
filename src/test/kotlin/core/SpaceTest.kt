package core

import graphics.noise.perlin.core.point.SpatialData1D
import graphics.noise.perlin.core.space.Space
import graphics.noise.perlin.core.point.SpatialData2D
import graphics.noise.perlin.core.point.SpatialData3D
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpaceTest {

    @Test
    fun `should return all points in 1D space`() {
        val space = Space(SpatialData1D(x = 5), SpatialData1D(x = 10))
        assertEquals(listOf(listOf(10), listOf(11), listOf(12), listOf(13), listOf(14)), space.points())
    }

    @Test
    fun `should return all points in the 2D space`() {
        val space = Space(
            dimension = SpatialData2D(x = 3, y = 5),
            position = SpatialData2D(x = 10, y = 5)
        )
        assertEquals(listOf(
            listOf(10, 5),
            listOf(10, 6),
            listOf(10, 7),
            listOf(10, 8),
            listOf(10, 9),
            listOf(11, 5),
            listOf(11, 6),
            listOf(11, 7),
            listOf(11, 8),
            listOf(11, 9),
            listOf(12, 5),
            listOf(12, 6),
            listOf(12, 7),
            listOf(12, 8),
            listOf(12, 9)
        ), space.points())
    }

    @Test
    fun `should return all points in 3D space`() {
        val space = Space(
            dimension = SpatialData3D(x = 2, y = 3, z = 4),
            position = SpatialData3D(x = 1, y = 1, z = 1)
        )
        assertEquals(
            listOf(
                listOf(1, 1, 1),
                listOf(1, 1, 2),
                listOf(1, 1, 3),
                listOf(1, 1, 4),
                listOf(1, 2, 1),
                listOf(1, 2, 2),
                listOf(1, 2, 3),
                listOf(1, 2, 4),
                listOf(1, 3, 1),
                listOf(1, 3, 2),
                listOf(1, 3, 3),
                listOf(1, 3, 4),
                listOf(2, 1, 1),
                listOf(2, 1, 2),
                listOf(2, 1, 3),
                listOf(2, 1, 4),
                listOf(2, 2, 1),
                listOf(2, 2, 2),
                listOf(2, 2, 3),
                listOf(2, 2, 4),
                listOf(2, 3, 1),
                listOf(2, 3, 2),
                listOf(2, 3, 3),
                listOf(2, 3, 4)
            ), space.points()
        )
    }
}