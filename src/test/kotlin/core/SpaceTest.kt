package core

import core.point.SpatialData1D
import core.space.Space
import core.point.SpatialData2D
import core.point.SpatialData3D
import core.space.RawBoundary
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class SpaceTest {

    @Nested
    inner class PointsTest {
        @Test
        fun `should return all points in 1D space`() {
            val space = Space(dimension = SpatialData1D(x = 5))
            assertEquals(listOf(SpatialData1D(x = 0), SpatialData1D(x = 1), SpatialData1D(x = 2), SpatialData1D(x = 3), SpatialData1D(x = 4)), space.points)
        }

        @Test
        fun `should return all points in the 2D space`() {
            val space = Space(dimension = SpatialData2D(x = 3, y = 5))
            assertEquals(listOf(
                SpatialData2D(x = 0, y = 0),
                SpatialData2D(x = 0, y = 1),
                SpatialData2D(x = 0, y = 2),
                SpatialData2D(x = 0, y = 3),
                SpatialData2D(x = 0, y = 4),
                SpatialData2D(x = 1, y = 0),
                SpatialData2D(x = 1, y = 1),
                SpatialData2D(x = 1, y = 2),
                SpatialData2D(x = 1, y = 3),
                SpatialData2D(x = 1, y = 4),
                SpatialData2D(x = 2, y = 0),
                SpatialData2D(x = 2, y = 1),
                SpatialData2D(x = 2, y = 2),
                SpatialData2D(x = 2, y = 3),
                SpatialData2D(x = 2, y = 4)
            ), space.points)
        }

        @Test
        fun `should return all points in 3D space`() {
            val space = Space(dimension = SpatialData3D(x = 2, y = 3, z = 4))
            assertEquals(
                listOf(
                    SpatialData3D(x = 0, y = 0, z = 0),
                    SpatialData3D(x = 0, y = 0, z = 1),
                    SpatialData3D(x = 0, y = 0, z = 2),
                    SpatialData3D(x = 0, y = 0, z = 3),
                    SpatialData3D(x = 0, y = 1, z = 0),
                    SpatialData3D(x = 0, y = 1, z = 1),
                    SpatialData3D(x = 0, y = 1, z = 2),
                    SpatialData3D(x = 0, y = 1, z = 3),
                    SpatialData3D(x = 0, y = 2, z = 0),
                    SpatialData3D(x = 0, y = 2, z = 1),
                    SpatialData3D(x = 0, y = 2, z = 2),
                    SpatialData3D(x = 0, y = 2, z = 3),
                    SpatialData3D(x = 1, y = 0, z = 0),
                    SpatialData3D(x = 1, y = 0, z = 1),
                    SpatialData3D(x = 1, y = 0, z = 2),
                    SpatialData3D(x = 1, y = 0, z = 3),
                    SpatialData3D(x = 1, y = 1, z = 0),
                    SpatialData3D(x = 1, y = 1, z = 1),
                    SpatialData3D(x = 1, y = 1, z = 2),
                    SpatialData3D(x = 1, y = 1, z = 3),
                    SpatialData3D(x = 1, y = 2, z = 0),
                    SpatialData3D(x = 1, y = 2, z = 1),
                    SpatialData3D(x = 1, y = 2, z = 2),
                    SpatialData3D(x = 1, y = 2, z = 3)
                ), space.points
            )
        }
    }

    @Nested
    inner class BoundaryTest {
        @Test
        fun `should return all the boundaries of 1D space`() {
            val space = Space(dimension = SpatialData1D(x = 5))
            assertEquals(listOf(SpatialData1D(x = 0), SpatialData1D(x = 5)), space.boundaries)
        }

        @Test
        fun `should return all the boundaries of 2D space`() {
            val space = Space(dimension = SpatialData2D(x = 3, y = 5))
            assertEquals(listOf(
                SpatialData2D(x = 0, y = 0),
                SpatialData2D(x = 0, y = 5),
                SpatialData2D(x = 3, y = 0),
                SpatialData2D(x = 3, y = 5)
            ), space.boundaries)
        }

        @Test
        fun `should return all the boundaries in 3D space`() {
            val space = Space(dimension = SpatialData3D(x = 3, y = 5, z = 4))
            assertEquals(
                listOf(
                    SpatialData3D(x = 0, y = 0, z = 0),
                    SpatialData3D(x = 0, y = 0, z = 4),
                    SpatialData3D(x = 0, y = 5, z = 0),
                    SpatialData3D(x = 0, y = 5, z = 4),
                    SpatialData3D(x = 3, y = 0, z = 0),
                    SpatialData3D(x = 3, y = 0, z = 4),
                    SpatialData3D(x = 3, y = 5, z = 0),
                    SpatialData3D(x = 3, y = 5, z = 4)
                ), space.boundaries
            )
        }
    }

    @Nested
    inner class RawBoundaryTest {
        @Test
        fun `should return the respective raw boundary for 1 dimension`() {
            assertEquals(listOf(listOf(false), listOf(true)), RawBoundary.generate(1))
        }

        @Test
        fun `should return the respective raw boundary for 2 dimension`() {
            assertEquals(listOf(
                listOf(false, false),
                listOf(false, true),
                listOf(true, false),
                listOf(true, true),
            ), RawBoundary.generate(2))
        }

        @Test
        fun `should return the respective raw boundary for 3 dimension`() {
            assertEquals(listOf(
                listOf(false, false, false),
                listOf(false, false, true),
                listOf(false, true, false),
                listOf(false, true, true),
                listOf(true, false, false),
                listOf(true, false, true),
                listOf(true, true, false),
                listOf(true, true, true)
            ), RawBoundary.generate(3))
        }

        @Test
        fun `raw boundary cache test`() {
            repeat(2) {
                assertEquals(listOf(listOf(false), listOf(true)), RawBoundary.generate(1))
            }

            repeat(2) {
                assertEquals(listOf(
                    listOf(false, false),
                    listOf(false, true),
                    listOf(true, false),
                    listOf(true, true),
                ), RawBoundary.generate(2))
            }

            assertEquals(listOf(listOf(false), listOf(true)), RawBoundary.generate(1))
            assertEquals(listOf(
                listOf(false, false),
                listOf(false, true),
                listOf(true, false),
                listOf(true, true),
            ), RawBoundary.generate(2))
        }
    }
}