package graphics.noise.perlin.extension.spatial.data

import graphics.noise.perlin.core.SpatialData
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class SpatialDataExtensionTest {

    @Test
    fun `should return x value in array`() {
        val spatialData1D: SpatialData = SpatialData1D(x = 1.0)
        listOf(1.0) shouldBe spatialData1D.toList()
    }

    @Test
    fun `should return the x, y values in an array`() {
        val spatialData2D: SpatialData = SpatialData2D(x = 1.0, y = 2.0)
        listOf(
            1.0,
            2.0
        ) shouldBe spatialData2D.toList()
    }

    @Test
    fun `should return x, y, z value in array`() {
        val spatialData3D: SpatialData = SpatialData3D(x = 1.0, y = 2.0, z = 3.0)
        listOf(
            1.0,
            2.0,
            3.0
        ) shouldBe spatialData3D.toList()
    }

    @Test
    fun `should create new 1D spatial data`() {
        val spatialData = SpatialData1D(x = 1.0)
        spatialData.breed(listOf(2.0)) shouldBe SpatialData1D(x = 2.0)
    }

    @Test
    fun `should create new 2D spatial data`() {
        val spatialData = SpatialData2D(x = 1.0, y = 1.0)
        spatialData.breed(listOf(
            2.0,
            2.0
        )) shouldBe SpatialData2D(x = 2.0, y = 2.0)
    }

    @Test
    fun `should create new 3D spatial data`() {
        val spatialData = SpatialData3D(x = 1.0, y = 1.0, z = 1.0)
        spatialData.breed(listOf(
            2.0,
            2.0,
            2.0
        )) shouldBe SpatialData3D(x = 2.0, y = 2.0, z = 2.0)
    }
}