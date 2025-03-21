package be.athumi

private const val WINE_BREWED_BY_ALEXANDER_THE_GREAT = "Wine brewed by Alexander the Great"
private const val BOURDEAUX_CONSERVATO = "Bourdeaux Conservato"
private const val BOURGOGNE_CONSERVATO = "Bourgogne Conservato"

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
        if (wine.name != BOURDEAUX_CONSERVATO && wine.name != BOURGOGNE_CONSERVATO && !wine.name.startsWith(EVENT_IDENTIFIER)) {
            if (wine.price > MIN_PRICE && wine.name != WINE_BREWED_BY_ALEXANDER_THE_GREAT) {
                wine.price--
            }
        } else {
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
            }
        }

        if (wine.name != WINE_BREWED_BY_ALEXANDER_THE_GREAT) {
            wine.expiresInYears--
        } else if (wine.price < MIN_PRICE) {
            wine.price = MIN_PRICE
        }

        if (wine.expiresInYears < MIN_YEARS) {
            if (!wine.name.contains(CONSERVATO_IDENTIFIER)) {
                if (!wine.name.contains(EVENT_IDENTIFIER)) {
                    if (wine.price > MIN_PRICE && wine.name != WINE_BREWED_BY_ALEXANDER_THE_GREAT) {
                        wine.price--
                    }
                } else {
                    wine.price = MIN_PRICE
                }
            } else {
                if (wine.price < MAX_PRICE) {
                    wine.price++
                }
            }
        }

        if (wine.price < MIN_PRICE) {
            wine.price = MIN_PRICE
        }
    }
}