package be.athumi

class WineShop(var items: List<Wine>) {
    fun updateWines() {
        val wineWrapperFactory = WineWrapperFactory()
        for (wine in items) {
            wineWrapperFactory.getWrappedWine(wine).updateWine()
        }
    }
}