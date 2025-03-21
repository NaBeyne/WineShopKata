package be.athumi.wines

import be.athumi.Wine

class RegularWineWrapper(wine: Wine) : WineWrapper(wine) {
    override fun updateWine() {
        if (wine.price > MIN_PRICE) {
            wine.price--
        }

        wine.expiresInYears--

        if (wine.expiresInYears < MIN_YEARS && wine.price > MIN_PRICE) {
            wine.price--
        }

        if (wine.price < MIN_PRICE) {
            wine.price = MIN_PRICE
        }
    }
}