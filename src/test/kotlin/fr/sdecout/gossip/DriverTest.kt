package fr.sdecout.gossip

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class DriverTest {

    @Test
    fun `should add gossips`() {
        val driver = Driver(
            id = DriverId(1),
            route = Route(1, 2, 3),
            knownGossips = setOf(DriverId(1), DriverId(2))
        )
        val newGossips = setOf(DriverId(2), DriverId(3))

        val updatedDriver = driver.addGossips(newGossips)

        expectThat(updatedDriver).isEqualTo(Driver(
            id = DriverId(1),
            route = Route(1, 2, 3),
            knownGossips = setOf(DriverId(1), DriverId(2), DriverId(3))
        ))
    }

}
