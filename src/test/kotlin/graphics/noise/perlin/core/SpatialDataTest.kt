package graphics.noise.perlin.core

import graphics.noise.perlin.extension.spatial.data.SpatialData3D
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class SpatialDataTest {

    @Test
    fun `should subtract spatial data`() {
        SpatialData3D(
            x = Coordinate(1),
            y = Coordinate(2),
            z = Coordinate(3)
        ) - SpatialData3D(
            x = Coordinate(5),
            y = Coordinate(2),
            z = Coordinate(0)
        ) shouldBe SpatialData3D(
            x = Coordinate(-4),
            y = Coordinate(0),
            z = Coordinate(3)
        )
    }

    @Test
    fun `should multiply spatial data`() {
        SpatialData3D(
            x = Coordinate(1),
            y = Coordinate(2),
            z = Coordinate(3)
        ) * SpatialData3D(
            x = Coordinate(5),
            y = Coordinate(2),
            z = Coordinate(0)
        ) shouldBe SpatialData3D(
            x = Coordinate(5),
            y = Coordinate(4),
            z = Coordinate(0)
        )
    }
}