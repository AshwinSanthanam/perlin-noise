package graphics.noise.perlin.core

import graphics.noise.perlin.extension.spatial.data.SpatialData1D
import graphics.noise.perlin.extension.spatial.data.SpatialData2D
import graphics.noise.perlin.extension.spatial.data.SpatialData3D
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class SpaceTest {

    @Test
    fun `should return the relative position`() {
        val space = Space(SpatialData3D(x = 10.0, y = 10.0, z = 10.0))

        val relativePoint = space.relative(SpatialData3D(x = 3.0, y = 4.0, z = 5.0))

        relativePoint shouldBe SpatialData3D(x = 0.3, y = 0.4, z = 0.5)
    }

    @Nested
    inner class PointsTest {
        @Test
        fun `should return all points in the 1D space`() {
            val space = Space(dimension = SpatialData1D(x = 5.0))
            listOf(
                SpatialData1D(x = 0.0),
                SpatialData1D(x = 1.0),
                SpatialData1D(x = 2.0),
                SpatialData1D(x = 3.0),
                SpatialData1D(x = 4.0)
            ) shouldBe space.points
        }

        @Test
        fun `should return all points in the 2D space`() {
            val space = Space(dimension = SpatialData2D(x = 3.0, y = 5.0))
            listOf(
                SpatialData2D(x = 0.0, y = 0.0),
                SpatialData2D(x = 0.0, y = 1.0),
                SpatialData2D(x = 0.0, y = 2.0),
                SpatialData2D(x = 0.0, y = 3.0),
                SpatialData2D(x = 0.0, y = 4.0),
                SpatialData2D(x = 1.0, y = 0.0),
                SpatialData2D(x = 1.0, y = 1.0),
                SpatialData2D(x = 1.0, y = 2.0),
                SpatialData2D(x = 1.0, y = 3.0),
                SpatialData2D(x = 1.0, y = 4.0),
                SpatialData2D(x = 2.0, y = 0.0),
                SpatialData2D(x = 2.0, y = 1.0),
                SpatialData2D(x = 2.0, y = 2.0),
                SpatialData2D(x = 2.0, y = 3.0),
                SpatialData2D(x = 2.0, y = 4.0)
            ) shouldBe space.points
        }

        @Test
        fun `should return all points in the 3D space`() {
            val space = Space(dimension = SpatialData3D(x = 2.0, y = 3.0, z = 4.0))
            listOf(
                SpatialData3D(x = 0.0, y = 0.0, z = 0.0),
                SpatialData3D(x = 0.0, y = 0.0, z = 1.0),
                SpatialData3D(x = 0.0, y = 0.0, z = 2.0),
                SpatialData3D(x = 0.0, y = 0.0, z = 3.0),
                SpatialData3D(x = 0.0, y = 1.0, z = 0.0),
                SpatialData3D(x = 0.0, y = 1.0, z = 1.0),
                SpatialData3D(x = 0.0, y = 1.0, z = 2.0),
                SpatialData3D(x = 0.0, y = 1.0, z = 3.0),
                SpatialData3D(x = 0.0, y = 2.0, z = 0.0),
                SpatialData3D(x = 0.0, y = 2.0, z = 1.0),
                SpatialData3D(x = 0.0, y = 2.0, z = 2.0),
                SpatialData3D(x = 0.0, y = 2.0, z = 3.0),
                SpatialData3D(x = 1.0, y = 0.0, z = 0.0),
                SpatialData3D(x = 1.0, y = 0.0, z = 1.0),
                SpatialData3D(x = 1.0, y = 0.0, z = 2.0),
                SpatialData3D(x = 1.0, y = 0.0, z = 3.0),
                SpatialData3D(x = 1.0, y = 1.0, z = 0.0),
                SpatialData3D(x = 1.0, y = 1.0, z = 1.0),
                SpatialData3D(x = 1.0, y = 1.0, z = 2.0),
                SpatialData3D(x = 1.0, y = 1.0, z = 3.0),
                SpatialData3D(x = 1.0, y = 2.0, z = 0.0),
                SpatialData3D(x = 1.0, y = 2.0, z = 1.0),
                SpatialData3D(x = 1.0, y = 2.0, z = 2.0),
                SpatialData3D(x = 1.0, y = 2.0, z = 3.0)
            ) shouldBe space.points
        }
    }

    @Nested
    inner class BoundaryTest {
        @Test
        fun `should return all the boundaries of 1D space`() {
            val space = Space(dimension = SpatialData1D(x = 5.0))
            listOf(SpatialData1D(x = 0.0), SpatialData1D(x = 5.0)) shouldBe space.boundaries
        }

        @Test
        fun `should return all the boundaries of 2D space`() {
            val space = Space(dimension = SpatialData2D(x = 3.0, y = 5.0))
            listOf(
                SpatialData2D(x = 0.0, y = 0.0),
                SpatialData2D(x = 0.0, y = 5.0),
                SpatialData2D(x = 3.0, y = 0.0),
                SpatialData2D(x = 3.0, y = 5.0)
            ) shouldBe space.boundaries
        }

        @Test
        fun `should return all the boundaries of 3D space`() {
            val space = Space(dimension = SpatialData3D(x = 3.0, y = 5.0, z = 4.0))
            listOf(
                SpatialData3D(x = 0.0, y = 0.0, z = 0.0),
                SpatialData3D(x = 0.0, y = 0.0, z = 4.0),
                SpatialData3D(x = 0.0, y = 5.0, z = 0.0),
                SpatialData3D(x = 0.0, y = 5.0, z = 4.0),
                SpatialData3D(x = 3.0, y = 0.0, z = 0.0),
                SpatialData3D(x = 3.0, y = 0.0, z = 4.0),
                SpatialData3D(x = 3.0, y = 5.0, z = 0.0),
                SpatialData3D(x = 3.0, y = 5.0, z = 4.0)
            ) shouldBe space.boundaries
        }
    }

    @Nested
    inner class SpaceCacheTest {
        @Test
        fun `should cache space objects based on dimensions for 1D space`() {
            val spaceCache = SpaceCache<SpatialData1D>()

            spaceCache.getOrCreate(SpatialData1D(x = 1.0)) shouldBe
                    spaceCache.getOrCreate(SpatialData1D(x = 1.0))

            spaceCache.getOrCreate(SpatialData1D(x = 2.0)) shouldBe
                    spaceCache.getOrCreate(SpatialData1D(x = 2.0))
        }

        @Test
        fun `should cache space objects based on dimensions for 2D space`() {
            val spaceCache = SpaceCache<SpatialData2D>()

            spaceCache.getOrCreate(SpatialData2D(x = 1.0, y = 1.0)) shouldBe
                spaceCache.getOrCreate(SpatialData2D(x = 1.0, y = 1.0))

            spaceCache.getOrCreate(SpatialData2D(x = 2.0, y = 2.0)) shouldBe
                spaceCache.getOrCreate(SpatialData2D(x = 2.0, y = 2.0))
        }
    }
}
