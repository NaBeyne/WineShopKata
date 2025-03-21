package be.athumi.wines

import be.athumi.Wine

class WineBrewedByAlexanderTheGreatWrapper(wine: Wine) : WineWrapper(wine) {
    override fun updatePrice() {
        // Price needs no update for WineBrewedByAlexanderTheGreat
    }

    override fun updateYearsUntilExpiration() {
        // ExpiresInYears needs no update for WineBrewedByAlexanderTheGreat
    }
}