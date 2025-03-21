package be.athumi.wines

import be.athumi.Wine

open class RegularWineWrapper(wine: Wine) : WineWrapper(wine) {
    override fun updatePrice() {
        decreasePrice()
        if (wineIsExpired()) {
            decreasePrice()
        }
    }

    override fun updateYearsUntilExpiration() {
        decreaseYearsUntilExpiration()
    }
}