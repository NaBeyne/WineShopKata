package be.athumi.wines

import be.athumi.Wine

abstract class WineWrapper(var wine: Wine) {
    protected companion object {
        const val MIN_PRICE = 0
        const val MAX_PRICE = 100
        const val MIN_YEARS = 0
    }

    abstract fun updateWine()
}