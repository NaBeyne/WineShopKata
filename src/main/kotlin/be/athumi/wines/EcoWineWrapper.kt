package be.athumi.wines

import be.athumi.Wine

class EcoWineWrapper(wine: Wine) : RegularWineWrapper(wine) {
    override fun updatePrice() {
        repeat(2) {
            super.updatePrice()
        }
    }
}