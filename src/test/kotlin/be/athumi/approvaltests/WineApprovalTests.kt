package be.athumi.approvaltests

import be.athumi.Wine
import be.athumi.WineShop
import org.approvaltests.Approvals
import org.junit.jupiter.api.Test

class WineApprovalTests {

    private val wines = listOf(
        Wine("Standard Wine", 20, 10),
        Wine("Another Standard Wine", 7, 5),
        Wine("Negative Standard Wine", -5, 5),
        Wine("Bourdeaux Conservato", 0, 2),
        Wine("Bourgogne Conservato", 98, 2),
        Wine("Wine brewed by Alexander the Great", 150, 0),
        Wine("Wine brewed by Alexander the Great", 80, -1),
        Wine("Wine brewed by Alexander the Great", -1, 10),
        Wine("Event Wine", 20, 15),
        Wine("Event Wine", 49, 10),
        Wine("Event Wine", 99, 2),
        Wine("Eco Brilliant Wine", 6, 3)
    )

    @Test
    fun updateWineShopFor1Years() {
        updateWineShopForAmountOfYears(1)
    }

    @Test
    fun updateWineShopFor2Years() {
        updateWineShopForAmountOfYears(2)
    }

    @Test
    fun updateWineShopFor3Years() {
        updateWineShopForAmountOfYears(3)
    }

    @Test
    fun updateWineShopFor5Years() {
        updateWineShopForAmountOfYears(5)
    }

    @Test
    fun updateWineShopFor10Years() {
        updateWineShopForAmountOfYears(10)
    }

    @Test
    fun updateWineShopFor20Years() {
        updateWineShopForAmountOfYears(20)
    }

    @Test
    fun updateWineShopFor30Years() {
        updateWineShopForAmountOfYears(30)
    }

    @Test
    fun updateWineShopFor50Years() {
        updateWineShopForAmountOfYears(50)
    }

    private fun updateWineShopForAmountOfYears(amountOfYears: Int) {
        val wineShop = WineShop(wines)
        Approvals.verifyAll("Years", (0..amountOfYears)) { year ->
            """-------- year $year --------${'\n'}${wines.joinToString("\n")}""".trimIndent()
                .also {  wineShop.updateWines() }
        }
    }
}