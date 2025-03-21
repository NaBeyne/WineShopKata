package be.athumi.wines

import be.athumi.Wine

private const val EVENT_YEARS_FIRST_PRICE_INCREASE = 8
private const val EVENT_YEARS_SECOND_PRICE_INCREASE = 3

class EventWineWrapper(wine: Wine) : WineWrapper(wine) {
    override fun updateWine() {
        if (wine.price < MAX_PRICE) {
            wine.price++

            if (wine.expiresInYears < EVENT_YEARS_FIRST_PRICE_INCREASE && wine.price < MAX_PRICE) {
                wine.price++
            }

            if (wine.expiresInYears < EVENT_YEARS_SECOND_PRICE_INCREASE && wine.price < MAX_PRICE) {
                wine.price += 2
            }

            if (wine.expiresInYears < MIN_YEARS) {
                wine.price = MIN_PRICE
            }
        }

        wine.expiresInYears--

        if (wine.expiresInYears < MIN_YEARS) {
            wine.price = MIN_PRICE
        }
    }
}