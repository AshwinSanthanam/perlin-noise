package graphics.noise.perlin.core

import graphics.noise.perlin.extension.spatial.data.SpatialData1D
import graphics.noise.perlin.extension.spatial.data.SpatialData2D
import graphics.noise.perlin.extension.spatial.data.SpatialData3D
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class SpaceTest {

    @Nested
    inner class PointsTest {
        @Test
        fun `should return all points in the 1D space`() {
            val space = Space(dimension = SpatialData1D(x = Coordinate(5)))
            assertEquals(listOf(SpatialData1D(x = Coordinate(0)), SpatialData1D(x = Coordinate(1)), SpatialData1D(x = Coordinate(2)), SpatialData1D(x = Coordinate(3)), SpatialData1D(x = Coordinate(4))), space.points)
        }

        @Test
        fun `should return all points in the 2D space`() {
            val space = Space(dimension = SpatialData2D(x = Coordinate(3), y = Coordinate(5)))
            assertEquals(listOf(
                SpatialData2D(x = Coordinate(0), y = Coordinate(0)),
                SpatialData2D(x = Coordinate(0), y = Coordinate(1)),
                SpatialData2D(x = Coordinate(0), y = Coordinate(2)),
                SpatialData2D(x = Coordinate(0), y = Coordinate(3)),
                SpatialData2D(x = Coordinate(0), y = Coordinate(4)),
                SpatialData2D(x = Coordinate(1), y = Coordinate(0)),
                SpatialData2D(x = Coordinate(1), y = Coordinate(1)),
                SpatialData2D(x = Coordinate(1), y = Coordinate(2)),
                SpatialData2D(x = Coordinate(1), y = Coordinate(3)),
                SpatialData2D(x = Coordinate(1), y = Coordinate(4)),
                SpatialData2D(x = Coordinate(2), y = Coordinate(0)),
                SpatialData2D(x = Coordinate(2), y = Coordinate(1)),
                SpatialData2D(x = Coordinate(2), y = Coordinate(2)),
                SpatialData2D(x = Coordinate(2), y = Coordinate(3)),
                SpatialData2D(x = Coordinate(2), y = Coordinate(4))
            ), space.points)
        }

        @Test
        fun `should return all points in the 3D space`() {
            val space = Space(dimension = SpatialData3D(x = Coordinate(2), y = Coordinate(3), z = Coordinate(4)))
            assertEquals(
                listOf(
                    SpatialData3D(x = Coordinate(0), y = Coordinate(0), z = Coordinate(0)),
                    SpatialData3D(x = Coordinate(0), y = Coordinate(0), z = Coordinate(1)),
                    SpatialData3D(x = Coordinate(0), y = Coordinate(0), z = Coordinate(2)),
                    SpatialData3D(x = Coordinate(0), y = Coordinate(0), z = Coordinate(3)),
                    SpatialData3D(x = Coordinate(0), y = Coordinate(1), z = Coordinate(0)),
                    SpatialData3D(x = Coordinate(0), y = Coordinate(1), z = Coordinate(1)),
                    SpatialData3D(x = Coordinate(0), y = Coordinate(1), z = Coordinate(2)),
                    SpatialData3D(x = Coordinate(0), y = Coordinate(1), z = Coordinate(3)),
                    SpatialData3D(x = Coordinate(0), y = Coordinate(2), z = Coordinate(0)),
                    SpatialData3D(x = Coordinate(0), y = Coordinate(2), z = Coordinate(1)),
                    SpatialData3D(x = Coordinate(0), y = Coordinate(2), z = Coordinate(2)),
                    SpatialData3D(x = Coordinate(0), y = Coordinate(2), z = Coordinate(3)),
                    SpatialData3D(x = Coordinate(1), y = Coordinate(0), z = Coordinate(0)),
                    SpatialData3D(x = Coordinate(1), y = Coordinate(0), z = Coordinate(1)),
                    SpatialData3D(x = Coordinate(1), y = Coordinate(0), z = Coordinate(2)),
                    SpatialData3D(x = Coordinate(1), y = Coordinate(0), z = Coordinate(3)),
                    SpatialData3D(x = Coordinate(1), y = Coordinate(1), z = Coordinate(0)),
                    SpatialData3D(x = Coordinate(1), y = Coordinate(1), z = Coordinate(1)),
                    SpatialData3D(x = Coordinate(1), y = Coordinate(1), z = Coordinate(2)),
                    SpatialData3D(x = Coordinate(1), y = Coordinate(1), z = Coordinate(3)),
                    SpatialData3D(x = Coordinate(1), y = Coordinate(2), z = Coordinate(0)),
                    SpatialData3D(x = Coordinate(1), y = Coordinate(2), z = Coordinate(1)),
                    SpatialData3D(x = Coordinate(1), y = Coordinate(2), z = Coordinate(2)),
                    SpatialData3D(x = Coordinate(1), y = Coordinate(2), z = Coordinate(3))
                ), space.points
            )
        }
    }

    @Nested
    inner class BoundaryTest {
        @Test
        fun `should return all the boundaries of 1D space`() {
            val space = Space(dimension = SpatialData1D(x = Coordinate(5)))
            assertEquals(listOf(SpatialData1D(x = Coordinate(0)), SpatialData1D(x = Coordinate(5))), space.boundaries)
        }

        @Test
        fun `should return all the boundaries of 2D space`() {
            val space = Space(dimension = SpatialData2D(x = Coordinate(3), y = Coordinate(5)))
            assertEquals(listOf(
                SpatialData2D(x = Coordinate(0), y = Coordinate(0)),
                SpatialData2D(x = Coordinate(0), y = Coordinate(5)),
                SpatialData2D(x = Coordinate(3), y = Coordinate(0)),
                SpatialData2D(x = Coordinate(3), y = Coordinate(5))
            ), space.boundaries)
        }

        @Test
        fun `should return all the boundaries of 3D space`() {
            val space = Space(dimension = SpatialData3D(x = Coordinate(3), y = Coordinate(5), z = Coordinate(4)))
            assertEquals(
                listOf(
                    SpatialData3D(x = Coordinate(0), y = Coordinate(0), z = Coordinate(0)),
                    SpatialData3D(x = Coordinate(0), y = Coordinate(0), z = Coordinate(4)),
                    SpatialData3D(x = Coordinate(0), y = Coordinate(5), z = Coordinate(0)),
                    SpatialData3D(x = Coordinate(0), y = Coordinate(5), z = Coordinate(4)),
                    SpatialData3D(x = Coordinate(3), y = Coordinate(0), z = Coordinate(0)),
                    SpatialData3D(x = Coordinate(3), y = Coordinate(0), z = Coordinate(4)),
                    SpatialData3D(x = Coordinate(3), y = Coordinate(5), z = Coordinate(0)),
                    SpatialData3D(x = Coordinate(3), y = Coordinate(5), z = Coordinate(4))
                ), space.boundaries
            )
        }
    }

    @Nested
    inner class SpaceCacheTest {
        @Test
        fun `should cache space objects based on dimensions for 1D space`() {
            val spaceCache = SpaceCache<SpatialData1D>()

            assertEquals(
                spaceCache.getOrCreate(SpatialData1D(x = Coordinate(1))),
                spaceCache.getOrCreate(SpatialData1D(x = Coordinate(1)))
            )
            assertEquals(
                spaceCache.getOrCreate(SpatialData1D(x = Coordinate(2))),
                spaceCache.getOrCreate(SpatialData1D(x = Coordinate(2)))
            )
        }

        @Test
        fun `should cache space objects based on dimensions for 2D space`() {
            val spaceCache = SpaceCache<SpatialData2D>()

            assertEquals(
                spaceCache.getOrCreate(SpatialData2D(x = Coordinate(1), y = Coordinate(1))),
                spaceCache.getOrCreate(SpatialData2D(x = Coordinate(1), y = Coordinate(1)))
            )
            assertEquals(
                spaceCache.getOrCreate(SpatialData2D(x = Coordinate(2), y = Coordinate(2))),
                spaceCache.getOrCreate(SpatialData2D(x = Coordinate(2), y = Coordinate(2)))
            )
        }
    }
}
