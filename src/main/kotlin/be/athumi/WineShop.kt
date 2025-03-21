package be.athumi

import be.athumi.wines.ConservatoWineWrapper
import be.athumi.wines.EventWineWrapper
import be.athumi.wines.RegularWineWrapper
import be.athumi.wines.WineBrewedByAlexanderTheGreatWrapper

private const val EVENT_IDENTIFIER = "Event"
private const val CONSERVATO_IDENTIFIER = "Conservato"
private const val WINE_BREWED_BY_ALEXANDER_THE_GREAT = "Wine brewed by Alexander the Great"

class WineShop(var items: List<Wine>) {
    fun updateWines() {
        for (wine in items) {
            updateWine(wine)
        }
    }

    private fun updateWine(wine: Wine) {
        when {
            wine.name.contains(CONSERVATO_IDENTIFIER) -> ConservatoWineWrapper(wine).updateWine()
            wine.name.startsWith(EVENT_IDENTIFIER) -> EventWineWrapper(wine).updateWine()
            wine.name == WINE_BREWED_BY_ALEXANDER_THE_GREAT -> WineBrewedByAlexanderTheGreatWrapper(wine).updateWine()
            else -> RegularWineWrapper(wine).updateWine()
        }
    }
}