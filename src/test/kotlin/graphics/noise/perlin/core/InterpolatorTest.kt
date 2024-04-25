package graphics.noise.perlin.core

import graphics.noise.perlin.extension.spatial.data.SpatialData3D
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class InterpolatorTest {
    @Test
    fun `should interpolate 3D spatial data`() {
        Interpolator<SpatialData3D>().interpolate(
            position = SpatialData3D(x = Coordinate(0.5), y = Coordinate(0.2), z = Coordinate(0.7)),
            boundaries = listOf(
                Coordinate(0),
                Coordinate(10),
                Coordinate(20),
                Coordinate(30),
                Coordinate(50),
                Coordinate(60),
                Coordinate(70),
                Coordinate(80)
            )
        ) shouldBe Coordinate(44)
    }
}