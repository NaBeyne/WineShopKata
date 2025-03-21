package be.athumi

private const val WINE_BREWED_BY_ALEXANDER_THE_GREAT = "Wine brewed by Alexander the Great"

private const val EVENT_IDENTIFIER = "Event"
private const val CONSERVATO_IDENTIFIER = "Conservato"

private const val MIN_YEARS = 0
private const val MIN_PRICE = 0
private const val MAX_PRICE = 100

private const val EVENT_YEARS_FIRST_PRICE_INCREASE = 8
private const val EVENT_YEARS_SECOND_PRICE_INCREASE = 3

class WineShop(var items: List<Wine>) {
    fun updateWines() {
        for (wine in items) {
            updateWine(wine)
        }
    }

    private fun updateWine(wine: Wine) {
        when {
            wine.name.contains(CONSERVATO_IDENTIFIER) -> handleConservatoWine(wine)
            wine.name.startsWith(EVENT_IDENTIFIER) -> handleEventWine(wine)
            wine.name == WINE_BREWED_BY_ALEXANDER_THE_GREAT -> handleWineBrewedByAlexanderTheGreat(wine)
            else -> handleRegularWine(wine)
        }
    }

    private fun handleConservatoWine(wine: Wine) {
        if (wine.price < MAX_PRICE) {
            wine.price++
        }

        wine.expiresInYears--

        if (wine.expiresInYears < MIN_YEARS && wine.price < MAX_PRICE) {
            wine.price++
        }

        if (wine.price < MIN_PRICE) {
            wine.price = MIN_PRICE
        }
    }

    private fun handleEventWine(wine: Wine) {
        if (wine.price < MAX_PRICE) {
            wine.price++

            if (wine.name.startsWith(EVENT_IDENTIFIER)) {
                if (wine.expiresInYears < EVENT_YEARS_FIRST_PRICE_INCREASE && wine.price < MAX_PRICE) {
                    wine.price++
                }

                if (wine.expiresInYears < EVENT_YEARS_SECOND_PRICE_INCREASE && wine.price < MAX_PRICE) {
                    wine.price += 2
                }
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

    private fun handleWineBrewedByAlexanderTheGreat(wine: Wine) {
        if (wine.price < MIN_PRICE) {
            wine.price = MIN_PRICE
        }
    }

    private fun handleRegularWine(wine: Wine) {
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