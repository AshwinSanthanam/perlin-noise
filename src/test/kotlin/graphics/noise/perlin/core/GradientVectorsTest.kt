package graphics.noise.perlin.core

import graphics.noise.perlin.extension.spatial.data.SpatialData1D
import graphics.noise.perlin.extension.spatial.data.SpatialData2D
import graphics.noise.perlin.extension.spatial.data.SpatialData3D
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class GradientVectorsTest {
    @Test
    fun `should return the correct number of gradient vectors for 1D space`() {
        val gradientVectors = GradientVectors(dimension = SpatialData1D(x = Coordinate(0))) { Coordinate(5) }
        listOf(
            SpatialData1D(x = Coordinate(5)),
            SpatialData1D(x = Coordinate(5))
        ) shouldBe gradientVectors.toList()
    }

    @Test
    fun `should return the correct number of gradient vectors for 2D space`() {
        val gradientVectors = GradientVectors(dimension = SpatialData2D(x = Coordinate(0), y = Coordinate(0))) { Coordinate(1) }
        listOf(
            SpatialData2D(x = Coordinate(1), y = Coordinate(1)),
            SpatialData2D(x = Coordinate(1), y = Coordinate(1)),
            SpatialData2D(x = Coordinate(1), y = Coordinate(1)),
            SpatialData2D(x = Coordinate(1), y = Coordinate(1))
        ) shouldBe gradientVectors.toList()
    }

    @Test
    fun `should return the correct number of gradient vectors for 3D space`() {
        val gradientVectors = GradientVectors(dimension = SpatialData3D(x = Coordinate(0), y = Coordinate(0), z = Coordinate(0))) { Coordinate(3) }
        listOf(
            SpatialData3D(x = Coordinate(3), y = Coordinate(3), z = Coordinate(3)),
            SpatialData3D(x = Coordinate(3), y = Coordinate(3), z = Coordinate(3)),
            SpatialData3D(x = Coordinate(3), y = Coordinate(3), z = Coordinate(3)),
            SpatialData3D(x = Coordinate(3), y = Coordinate(3), z = Coordinate(3)),
            SpatialData3D(x = Coordinate(3), y = Coordinate(3), z = Coordinate(3)),
            SpatialData3D(x = Coordinate(3), y = Coordinate(3), z = Coordinate(3)),
            SpatialData3D(x = Coordinate(3), y = Coordinate(3), z = Coordinate(3)),
            SpatialData3D(x = Coordinate(3), y = Coordinate(3), z = Coordinate(3))
        ) shouldBe gradientVectors.toList()
    }
}