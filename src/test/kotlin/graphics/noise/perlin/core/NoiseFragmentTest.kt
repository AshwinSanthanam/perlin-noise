package graphics.noise.perlin.core

import graphics.noise.perlin.extension.spatial.data.SpatialData2D
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import kotlin.math.roundToInt

class NoiseFragmentTest {
    @Test
    fun `generate Image`() {
        val dimension = SpatialData2D(x = Coordinate(5), y = Coordinate(5))
        val space = Space(dimension)
        val noise = NoiseFragment(
            space = space,
            interpolator = Interpolator(),
            gradientVectors = listOf(
                SpatialData2D(x = Coordinate(0), y = Coordinate(1)),
                SpatialData2D(x = Coordinate(0), y = Coordinate(-1)),
                SpatialData2D(x = Coordinate(-1), y = Coordinate(0)),
                SpatialData2D(x = Coordinate(-1), y = Coordinate(0))
            )
        ).noise()

        listOf(
            0.0,
            0.375,
            0.6666666666666667,
            0.8750000000000001,
            1.0,
            0.20833333333333334,
            0.43333333333333335,
            0.6083333333333334,
            0.7333333333333334,
            0.8083333333333333,
            0.4166666666666667,
            0.49166666666666675,
            0.55,
            0.5916666666666667,
            0.6166666666666667,
            0.625,
            0.5499999999999999,
            0.49166666666666664,
            0.45000000000000007,
            0.42500000000000004,
            0.8333333333333334,
            0.6083333333333334,
            0.43333333333333335,
            0.30833333333333335,
            0.2333333333333333
        ) shouldBe noise
    }

    private fun createImage(noise: List<Double>, dimension: SpatialData2D, space: Space<SpatialData2D>) {
        val image = BufferedImage(dimension.x.value.toInt(), dimension.y.value.toInt(), BufferedImage.TYPE_BYTE_GRAY)
        noise.zip(space.points).forEach {
            val (value, spatialData) = it
            val color = (value * 255).roundToInt()
            image.setRGB(spatialData.x.value.toInt(), spatialData.y.value.toInt(), Color(color, color, color).rgb)
        }
        ImageIO.write(image, "jpg", File("build/noise.jpg"))
    }
}