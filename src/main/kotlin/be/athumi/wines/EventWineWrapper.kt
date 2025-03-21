package be.athumi.wines

import be.athumi.Wine

private const val EVENT_YEARS_FIRST_PRICE_INCREASE = 8
private const val EVENT_YEARS_SECOND_PRICE_INCREASE = 3

class EventWineWrapper(wine: Wine) : WineWrapper(wine) {
    override fun updateWine() {
        increasePrice()

        if (firstPriceIncreaseHappened() && wine.price < MAX_PRICE) {
            increasePrice()
        }

        if (secondPriceIncreaseHappened() && wine.price < MAX_PRICE) {
            increasePrice()
            increasePrice()
        }

        decreaseYearsUntilExpiration()

        adjustExpiredWinePriceToZero()

        adjustPriceLowerThanMinPrice()
    }

    private fun firstPriceIncreaseHappened(): Boolean {
        return wine.expiresInYears < EVENT_YEARS_FIRST_PRICE_INCREASE
    }

    private fun secondPriceIncreaseHappened(): Boolean {
        return wine.expiresInYears < EVENT_YEARS_SECOND_PRICE_INCREASE
    }
}