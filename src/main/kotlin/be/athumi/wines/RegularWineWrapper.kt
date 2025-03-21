package be.athumi.wines

import be.athumi.Wine

class RegularWineWrapper(wine: Wine) : WineWrapper(wine) {
    override fun updateWine() {
        decreasePrice()

        decreaseYearsUntilExpiration()

        if (wineIsExpired()) {
            decreasePrice()
        }

        adjustPriceLowerThanMinPrice()
    }
}