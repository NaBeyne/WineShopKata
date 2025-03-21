package be.athumi.unittests

import be.athumi.Wine
import be.athumi.wines.RegularWineWrapper
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RegularWineWrapperTest {

    @Test
    fun updateRegularWineTest() {
        val wine = Wine("Wine", 5, 10)
        RegularWineWrapper(wine).updateWine()
        assertEquals(4, wine.price)
        assertEquals(9, wine.expiresInYears)
    }

    @Test
    fun updateExpiredRegularWineTest() {
        val wine = Wine("Wine", 5, 0)
        RegularWineWrapper(wine).updateWine()
        assertEquals(3, wine.price)
        assertEquals(-1, wine.expiresInYears)
    }

    @Test
    fun updateRegularWineWithMinPriceTest() {
        val wine = Wine("Wine", 0, 10)
        RegularWineWrapper(wine).updateWine()
        assertEquals(0, wine.price)
        assertEquals(9, wine.expiresInYears)
    }

    @Test
    fun updateRegularWineWithPriceLowerThanMinPriceTest() {
        val wine = Wine("Wine", -5, 10)
        RegularWineWrapper(wine).updateWine()
        assertEquals(0, wine.price)
        assertEquals(9, wine.expiresInYears)
    }

}