package be.athumi.wines

import be.athumi.Wine

private const val EVENT_YEARS_FIRST_PRICE_INCREASE = 8
private const val EVENT_YEARS_SECOND_PRICE_INCREASE = 3

class EventWineWrapper(wine: Wine) : WineWrapper(wine) {
    override fun updatePrice() {
        increasePrice()

        if (firstPriceIncreaseHappened()) {
            increasePrice()
        }

        if (secondPriceIncreaseHappened()) {
            increasePrice()
            increasePrice()
        }

        adjustExpiredWinePriceToZero()
    }

    override fun updateYearsUntilExpiration() {
        decreaseYearsUntilExpiration()
    }

    private fun firstPriceIncreaseHappened(): Boolean {
        return wine.expiresInYears < EVENT_YEARS_FIRST_PRICE_INCREASE
    }

    private fun secondPriceIncreaseHappened(): Boolean {
        return wine.expiresInYears < EVENT_YEARS_SECOND_PRICE_INCREASE
    }
}