package graphics.noise.perlin.core

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SpatialDataFactoryTest {
    @Test
    fun `should return the default spatial data implementation when there is no match in extension`() {
        val spatialData: SpatialData = SpatialDataFactory().create(listOf(1, 2, 3, 4, 5))
        assertEquals(spatialData.toList(), listOf(1, 2, 3, 4, 5))
    }

    @Test
    fun `should return the implementation from extension on match`() {
        val spatialData: SpatialData = SpatialDataFactory().create(listOf(1, 2, 3, 4, 5))

        val spatialDataFactoryExtension = object: SpatialDataFactory() {
            @Suppress("UNCHECKED_CAST")
            override fun <T : SpatialData> extension(data: List<Int>): T? {
                return spatialData as T?
            }
        }

        assertEquals(
            spatialDataFactoryExtension.create(emptyList()),
            spatialData
        )
    }
}