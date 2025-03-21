package be.athumi.unittests

import be.athumi.Wine
import be.athumi.wines.EventWineWrapper
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class EventWineWrapperTest {

    @Test
    fun updateEventWineTest() {
        val wine = Wine("Wine", 5, 10)
        EventWineWrapper(wine).updateWine()
        assertEquals(6, wine.price)
        assertEquals(9, wine.expiresInYears)
    }

    @Test
    fun updateEventWineWithFirstPriceIncreaseTest() {
        val wine = Wine("Wine", 5, 7)
        EventWineWrapper(wine).updateWine()
        assertEquals(7, wine.price)
        assertEquals(6, wine.expiresInYears)
    }

    @Test
    fun updateEventWineWithSecondPriceIncreaseTest() {
        val wine = Wine("Wine", 5, 2)
        EventWineWrapper(wine).updateWine()
        assertEquals(9, wine.price)
        assertEquals(1, wine.expiresInYears)
    }

    @Test
    fun updateExpiredEventWineTest() {
        val wine = Wine("Wine", 5, 0)
        EventWineWrapper(wine).updateWine()
        assertEquals(0, wine.price)
        assertEquals(-1, wine.expiresInYears)
    }

    @Test
    fun updateEventWineWithMaxPriceTest() {
        val wine = Wine("Wine", 100, 10)
        EventWineWrapper(wine).updateWine()
        assertEquals(100, wine.price)
        assertEquals(9, wine.expiresInYears)
    }

    @Test
    fun updateEventWineWithPriceLowerThanMinPriceTest() {
        val wine = Wine("Wine", -5, 10)
        EventWineWrapper(wine).updateWine()
        assertEquals(0, wine.price)
        assertEquals(9, wine.expiresInYears)
    }

}