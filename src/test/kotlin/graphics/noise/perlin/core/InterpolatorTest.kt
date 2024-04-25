package graphics.noise.perlin.core

import graphics.noise.perlin.extension.spatial.data.SpatialData3D
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class InterpolatorTest {
    @Test
    fun `should interpolate 3D spatial data`() {
        Interpolator<SpatialData3D>().interpolate(
            position = SpatialData3D(x = 0.5, y = 0.2, z = 0.7),
            boundaries = listOf(
                0.0,
                10.0,
                20.0,
                30.0,
                50.0,
                60.0,
                70.0,
                80.0
            )
        ) shouldBe 44.0
    }
}