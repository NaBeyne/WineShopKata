package be.athumi

import be.athumi.wines.*

private const val EVENT_IDENTIFIER = "Event"
private const val CONSERVATO_IDENTIFIER = "Conservato"
private const val WINE_BREWED_BY_ALEXANDER_THE_GREAT = "Wine brewed by Alexander the Great"

class WineWrapperFactory {

    fun getWrappedWine(wine: Wine) : WineWrapper {
        return when {
            wine.name.contains(CONSERVATO_IDENTIFIER) -> ConservatoWineWrapper(wine)
            wine.name.startsWith(EVENT_IDENTIFIER) -> EventWineWrapper(wine)
            wine.name == WINE_BREWED_BY_ALEXANDER_THE_GREAT -> WineBrewedByAlexanderTheGreatWrapper(wine)
            else -> RegularWineWrapper(wine)
        }
    }

}