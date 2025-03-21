package be.athumi.wines

import be.athumi.Wine

class ConservatoWineWrapper(wine: Wine) : WineWrapper(wine) {
    override fun updateWine() {
        increasePrice()

        decreaseYearsUntilExpiration()

        if (wineIsExpired()) {
            increasePrice()
        }

        adjustPriceLowerThanMinPrice()
    }
}