package be.athumi.wines

import be.athumi.Wine

abstract class WineWrapper(var wine: Wine) {
    protected companion object {
        const val MIN_PRICE = 0
        const val MAX_PRICE = 100
        const val MIN_YEARS = 0
    }

    abstract fun updateWine()

    fun wineIsExpired(): Boolean {
        return wine.expiresInYears < MIN_YEARS
    }

    fun decreaseYearsUntilExpiration() {
        wine.expiresInYears--
    }

    fun increasePrice() {
        if (priceIsLowerThanMaxPrice()) {
            wine.price++
        }
    }

    fun decreasePrice() {
        if (priceIsGreaterThanMinPrice()) {
            wine.price--
        }
    }

    fun adjustPriceLowerThanMinPrice() {
        if (priceIsLowerThanMinPrice()) {
            setPriceToMinPrice()
        }
    }

    fun adjustExpiredWinePriceToZero() {
        if (wineIsExpired()) {
            setPriceToMinPrice()
        }
    }

    private fun priceIsLowerThanMinPrice(): Boolean {
        return wine.price < MIN_PRICE
    }

    private fun priceIsLowerThanMaxPrice(): Boolean {
        return wine.price < MAX_PRICE
    }

    private fun priceIsGreaterThanMinPrice(): Boolean {
        return wine.price > MIN_PRICE
    }

    private fun setPriceToMinPrice() {
        wine.price = MIN_PRICE
    }
}