package be.athumi.wines

import be.athumi.Wine

class WineBrewedByAlexanderTheGreatWrapper(wine: Wine) : WineWrapper(wine) {
    override fun updateWine() {
        adjustPriceLowerThanMinPrice()
    }
}