package graphics.noise.perlin.core

import graphics.noise.perlin.extension.spatial.data.SpatialData3D
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class SpatialDataTest {

    @Test
    fun `should subtract spatial data`() {
        SpatialData3D(
            x = 1.0,
            y = 2.0,
            z = 3.0
        ) - SpatialData3D(
            x = 5.0,
            y = 2.0,
            z = 0.0
        ) shouldBe SpatialData3D(
            x = -4.0,
            y = 0.0,
            z = 3.0
        )
    }

    @Test
    fun `should multiply spatial data`() {
        SpatialData3D(
            x = 1.0,
            y = 2.0,
            z = 3.0
        ) * SpatialData3D(
            x = 5.0,
            y = 2.0,
            z = 0.0
        ) shouldBe 9.0
    }

    @Test
    fun `should divide spatial data`() {
        SpatialData3D(
            x = 1.0,
            y = 2.0,
            z = 3.0
        ) / SpatialData3D(
            x = 5.0,
            y = 2.0,
            z = 2.0
        ) shouldBe SpatialData3D(
            x = 0.2,
            y = 1.0,
            z = 1.5
        )
    }
}