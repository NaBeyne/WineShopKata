package be.athumi.unittests

import be.athumi.Wine
import be.athumi.wines.WineBrewedByAlexanderTheGreatWrapper
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WineBrewedByAlexanderTheGreatWrapperTest {

    @Test
    fun updateWineBrewedByAlexanderTheGreatTest() {
        val wine = Wine("Wine", 80, 10)
        WineBrewedByAlexanderTheGreatWrapper(wine).updateWine()
        assertEquals(80, wine.price)
        assertEquals(10, wine.expiresInYears)
    }

    @Test
    fun updateWineBrewedByAlexanderTheGreatWithPriceLowerThanMinPriceTest() {
        val wine = Wine("Wine", -1, 10)
        WineBrewedByAlexanderTheGreatWrapper(wine).updateWine()
        assertEquals(0, wine.price)
        assertEquals(10, wine.expiresInYears)
    }

}