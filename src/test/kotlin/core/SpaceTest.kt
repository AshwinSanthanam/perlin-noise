package core

import core.point.SpatialData1D
import core.point.SpatialData2D
import core.point.SpatialData3D
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class SpaceTest {

    @Nested
    inner class PointsTest {
        @Test
        fun `should return all points in 1D space`() {
            val space = Space(SpatialData1D(x = 5), SpatialData1D(x = 10))
            assertEquals(listOf(SpatialData1D(x = 10), SpatialData1D(x = 11), SpatialData1D(x = 12), SpatialData1D(x = 13), SpatialData1D(x = 14)), space.points)
        }

        @Test
        fun `should return all points in the 2D space`() {
            val space = Space(
                dimension = SpatialData2D(x = 3, y = 5),
                position = SpatialData2D(x = 10, y = 5)
            )
            assertEquals(listOf(
                SpatialData2D(x = 10, y = 5),
                SpatialData2D(x = 10, y = 6),
                SpatialData2D(x = 10, y = 7),
                SpatialData2D(x = 10, y = 8),
                SpatialData2D(x = 10, y = 9),
                SpatialData2D(x = 11, y = 5),
                SpatialData2D(x = 11, y = 6),
                SpatialData2D(x = 11, y = 7),
                SpatialData2D(x = 11, y = 8),
                SpatialData2D(x = 11, y = 9),
                SpatialData2D(x = 12, y = 5),
                SpatialData2D(x = 12, y = 6),
                SpatialData2D(x = 12, y = 7),
                SpatialData2D(x = 12, y = 8),
                SpatialData2D(x = 12, y = 9)
            ), space.points)
        }

        @Test
        fun `should return all points in 3D space`() {
            val space = Space(
                dimension = SpatialData3D(x = 2, y = 3, z = 4),
                position = SpatialData3D(x = 1, y = 1, z = 1)
            )
            assertEquals(
                listOf(
                    SpatialData3D(x = 1, y = 1, z = 1),
                    SpatialData3D(x = 1, y = 1, z = 2),
                    SpatialData3D(x = 1, y = 1, z = 3),
                    SpatialData3D(x = 1, y = 1, z = 4),
                    SpatialData3D(x = 1, y = 2, z = 1),
                    SpatialData3D(x = 1, y = 2, z = 2),
                    SpatialData3D(x = 1, y = 2, z = 3),
                    SpatialData3D(x = 1, y = 2, z = 4),
                    SpatialData3D(x = 1, y = 3, z = 1),
                    SpatialData3D(x = 1, y = 3, z = 2),
                    SpatialData3D(x = 1, y = 3, z = 3),
                    SpatialData3D(x = 1, y = 3, z = 4),
                    SpatialData3D(x = 2, y = 1, z = 1),
                    SpatialData3D(x = 2, y = 1, z = 2),
                    SpatialData3D(x = 2, y = 1, z = 3),
                    SpatialData3D(x = 2, y = 1, z = 4),
                    SpatialData3D(x = 2, y = 2, z = 1),
                    SpatialData3D(x = 2, y = 2, z = 2),
                    SpatialData3D(x = 2, y = 2, z = 3),
                    SpatialData3D(x = 2, y = 2, z = 4),
                    SpatialData3D(x = 2, y = 3, z = 1),
                    SpatialData3D(x = 2, y = 3, z = 2),
                    SpatialData3D(x = 2, y = 3, z = 3),
                    SpatialData3D(x = 2, y = 3, z = 4)
                ), space.points
            )
        }
    }

    @Nested
    inner class BoundaryTest {
        @Test
        fun `should return all the boundaries of 1D space`() {
            val space = Space(
                dimension = SpatialData1D(x = 5),
                position = SpatialData1D(x = 2)
            )
            assertEquals(listOf(SpatialData1D(x = 2), SpatialData1D(x = 7)), space.boundaries)
        }

        @Test
        fun `should return all the boundaries of 2D space`() {
            val space = Space(
                dimension = SpatialData2D(x = 3, y = 5),
                position = SpatialData2D(x = 1, y = 2)
            )
            assertEquals(listOf(
                SpatialData2D(x = 1, y = 2),
                SpatialData2D(x = 1, y = 7),
                SpatialData2D(x = 4, y = 2),
                SpatialData2D(x = 4, y = 7)
            ), space.boundaries)
        }

        @Test
        fun `should return all the boundaries in 3D space`() {
            val space = Space(
                dimension = SpatialData3D(x = 3, y = 5, z = 4),
                position = SpatialData3D(x = 1, y = 2, z = 3)
            )
            assertEquals(
                listOf(
                    SpatialData3D(x = 1, y = 2, z = 3),
                    SpatialData3D(x = 1, y = 2, z = 7),
                    SpatialData3D(x = 1, y = 7, z = 3),
                    SpatialData3D(x = 1, y = 7, z = 7),
                    SpatialData3D(x = 4, y = 2, z = 3),
                    SpatialData3D(x = 4, y = 2, z = 7),
                    SpatialData3D(x = 4, y = 7, z = 3),
                    SpatialData3D(x = 4, y = 7, z = 7)
                ), space.boundaries
            )
        }
    }
}