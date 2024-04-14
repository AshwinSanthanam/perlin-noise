package graphics.noise.perlin.core

import graphics.noise.perlin.extension.spatial.data.SpatialData1D
import graphics.noise.perlin.extension.spatial.data.SpatialData2D
import graphics.noise.perlin.extension.spatial.data.SpatialData3D
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GradientVectorsTest {
    @Test
    fun `should return the correct number of gradient vectors for 1D space`() {
        val gradientVectors = GradientVectors(dimension = SpatialData1D(x = 0)) { 5 }
        assertEquals(
            listOf(
                SpatialData1D(x = 5),
                SpatialData1D(x = 5)
            ),
            gradientVectors.toList()
        )
    }

    @Test
    fun `should return the correct number of gradient vectors for 2D space`() {
        val gradientVectors = GradientVectors(dimension = SpatialData2D(x = 0, y = 0)) { 1 }
        assertEquals(
            listOf(
                SpatialData2D(x = 1, y = 1),
                SpatialData2D(x = 1, y = 1),
                SpatialData2D(x = 1, y = 1),
                SpatialData2D(x = 1, y = 1)
            ),
            gradientVectors.toList()
        )
    }

    @Test
    fun `should return the correct number of gradient vectors for 3D space`() {
        val gradientVectors = GradientVectors(dimension = SpatialData3D(x = 0, y = 0, z = 0)) { 3 }
        assertEquals(
            listOf(
                SpatialData3D(x = 3, y = 3, z = 3),
                SpatialData3D(x = 3, y = 3, z = 3),
                SpatialData3D(x = 3, y = 3, z = 3),
                SpatialData3D(x = 3, y = 3, z = 3),
                SpatialData3D(x = 3, y = 3, z = 3),
                SpatialData3D(x = 3, y = 3, z = 3),
                SpatialData3D(x = 3, y = 3, z = 3),
                SpatialData3D(x = 3, y = 3, z = 3)
            ),
            gradientVectors.toList()
        )
    }
}