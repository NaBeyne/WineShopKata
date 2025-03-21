package be.athumi.wines

import be.athumi.Wine

class WineBrewedByAlexanderTheGreatWrapper(wine: Wine) : WineWrapper(wine) {
    override fun updateWine() {
        if (wine.price < MIN_PRICE) {
            wine.price = MIN_PRICE
        }
    }
}