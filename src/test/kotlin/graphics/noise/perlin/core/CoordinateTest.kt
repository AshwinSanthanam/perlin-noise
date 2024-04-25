package graphics.noise.perlin.core

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class CoordinateTest {
    @Test
    fun `should return the range of coordinates`() {
        listOf(
            Coordinate(5),
            Coordinate(6),
            Coordinate(7),
            Coordinate(8),
            Coordinate(9)
        ) shouldBe (Coordinate(5) ..< Coordinate(10))
    }

    @Test
    fun `should return the origin`() {
        Coordinate(0.0) shouldBe Coordinate.ORIGIN
    }

    @Test
    fun `should add value`() {
        Coordinate(5) + Coordinate(10) shouldBe Coordinate(15)
    }

    @Test
    fun `should subtract value`() {
        Coordinate(5) - Coordinate(10) shouldBe Coordinate(-5)
    }

    @Test
    fun `should multiply value`() {
        Coordinate(3) * Coordinate(7) shouldBe Coordinate(21)
    }

    @Test
    fun `should divide value`() {
        Coordinate(5) / Coordinate(2) shouldBe Coordinate(2.5)
    }
}