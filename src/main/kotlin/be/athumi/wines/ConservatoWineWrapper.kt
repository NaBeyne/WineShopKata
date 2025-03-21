package be.athumi.wines

import be.athumi.Wine

class ConservatoWineWrapper(wine: Wine) : WineWrapper(wine) {
    override fun updatePrice() {
        increasePrice()
        if (wineIsExpired()) {
            increasePrice()
        }
    }

    override fun updateYearsUntilExpiration() {
        decreaseYearsUntilExpiration()
    }
}