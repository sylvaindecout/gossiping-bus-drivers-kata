package fr.sdecout.gossip

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class DriverIdTest {

    @Test
    fun `should display as string`() {
        val driverId = DriverId(8)

        val string = driverId.toString()

        expectThat(string).isEqualTo("Driver #8")
    }

}
