package be.athumi.unittests

import be.athumi.Wine
import be.athumi.wines.EcoWineWrapper
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class EcoWineWrapperTest {

    @Test
    fun updateEcoWineTest() {
        val wine = Wine("Wine", 5, 10)
        EcoWineWrapper(wine).updateWine()
        assertEquals(3, wine.price)
        assertEquals(9, wine.expiresInYears)
    }

    @Test
    fun updateExpiredEcoWineTest() {
        val wine = Wine("Wine", 5, 0)
        EcoWineWrapper(wine).updateWine()
        assertEquals(1, wine.price)
        assertEquals(-1, wine.expiresInYears)
    }

    @Test
    fun updateEcoWineWithMinPriceTest() {
        val wine = Wine("Wine", 0, 10)
        EcoWineWrapper(wine).updateWine()
        assertEquals(0, wine.price)
        assertEquals(9, wine.expiresInYears)
    }

    @Test
    fun updateEcoWineWithPriceLowerThanMinPriceTest() {
        val wine = Wine("Wine", -5, 10)
        EcoWineWrapper(wine).updateWine()
        assertEquals(0, wine.price)
        assertEquals(9, wine.expiresInYears)
    }

}