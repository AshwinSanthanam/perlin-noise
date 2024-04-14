package graphics.noise.perlin.core

import graphics.noise.perlin.extension.spatial.data.SpatialData1D
import graphics.noise.perlin.extension.spatial.data.SpatialData2D
import graphics.noise.perlin.extension.spatial.data.SpatialData3D
import graphics.noise.perlin.core.Space
import graphics.noise.perlin.core.SpaceCache
import graphics.noise.perlin.extension.spatial.data.SpatialDataFactoryExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class SpaceTest {

    @Nested
    inner class PointsTest {
        @Test
        fun `should return all points in the 1D space`() {
            val space = Space(spatialDataFactory = SpatialDataFactoryExtension(), dimension = SpatialData1D(x = 5))
            assertEquals(listOf(SpatialData1D(x = 0), SpatialData1D(x = 1), SpatialData1D(x = 2), SpatialData1D(x = 3), SpatialData1D(x = 4)), space.points)
        }

        @Test
        fun `should return all points in the 2D space`() {
            val space = Space(spatialDataFactory = SpatialDataFactoryExtension(), dimension = SpatialData2D(x = 3, y = 5))
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
        fun `should return all points in the 3D space`() {
            val space = Space(spatialDataFactory = SpatialDataFactoryExtension(), dimension = SpatialData3D(x = 2, y = 3, z = 4))
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
            val space = Space(spatialDataFactory = SpatialDataFactoryExtension(), dimension = SpatialData1D(x = 5))
            assertEquals(listOf(SpatialData1D(x = 0), SpatialData1D(x = 5)), space.boundaries)
        }

        @Test
        fun `should return all the boundaries of 2D space`() {
            val space = Space(spatialDataFactory = SpatialDataFactoryExtension(), dimension = SpatialData2D(x = 3, y = 5))
            assertEquals(listOf(
                SpatialData2D(x = 0, y = 0),
                SpatialData2D(x = 0, y = 5),
                SpatialData2D(x = 3, y = 0),
                SpatialData2D(x = 3, y = 5)
            ), space.boundaries)
        }

        @Test
        fun `should return all the boundaries of 3D space`() {
            val space = Space(spatialDataFactory = SpatialDataFactoryExtension(), dimension = SpatialData3D(x = 3, y = 5, z = 4))
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
    inner class SpaceCacheTest {
        @Test
        fun `should cache space objects based on dimensions for 1D space`() {
            val spaceCache = SpaceCache<SpatialData1D>()

            assertEquals(
                spaceCache.getOrCreate(spatialDataFactory = SpatialDataFactoryExtension(), SpatialData1D(x = 1)),
                spaceCache.getOrCreate(spatialDataFactory = SpatialDataFactoryExtension(), SpatialData1D(x = 1))
            )
            assertEquals(
                spaceCache.getOrCreate(spatialDataFactory = SpatialDataFactoryExtension(), SpatialData1D(x = 2)),
                spaceCache.getOrCreate(spatialDataFactory = SpatialDataFactoryExtension(), SpatialData1D(x = 2))
            )
        }

        @Test
        fun `should cache space objects based on dimensions for 2D space`() {
            val spaceCache = SpaceCache<SpatialData2D>()

            assertEquals(
                spaceCache.getOrCreate(spatialDataFactory = SpatialDataFactoryExtension(), SpatialData2D(x = 1, y = 1)),
                spaceCache.getOrCreate(spatialDataFactory = SpatialDataFactoryExtension(), SpatialData2D(x = 1, y = 1))
            )
            assertEquals(
                spaceCache.getOrCreate(spatialDataFactory = SpatialDataFactoryExtension(), SpatialData2D(x = 2, y = 2)),
                spaceCache.getOrCreate(spatialDataFactory = SpatialDataFactoryExtension(), SpatialData2D(x = 2, y = 2))
            )
        }
    }
}
