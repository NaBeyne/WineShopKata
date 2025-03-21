package be.athumi.unittests

import be.athumi.Wine
import be.athumi.wines.ConservatoWineWrapper
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ConservatoWineWrapperTest {

    @Test
    fun updateConservatoWineTest() {
        val wine = Wine("Wine", 5, 10)
        ConservatoWineWrapper(wine).updateWine()
        assertEquals(6, wine.price)
        assertEquals(9, wine.expiresInYears)
    }

    @Test
    fun updateExpiredConservatoWineTest() {
        val wine = Wine("Wine", 5, 0)
        ConservatoWineWrapper(wine).updateWine()
        assertEquals(7, wine.price)
        assertEquals(-1, wine.expiresInYears)
    }

    @Test
    fun updateConservatoWineWithMaxPriceTest() {
        val wine = Wine("Wine", 100, 10)
        ConservatoWineWrapper(wine).updateWine()
        assertEquals(100, wine.price)
        assertEquals(9, wine.expiresInYears)
    }

    @Test
    fun updateConservatoWineWithPriceLowerThanMinPriceTest() {
        val wine = Wine("Wine", -5, 10)
        ConservatoWineWrapper(wine).updateWine()
        assertEquals(0, wine.price)
        assertEquals(9, wine.expiresInYears)
    }

}