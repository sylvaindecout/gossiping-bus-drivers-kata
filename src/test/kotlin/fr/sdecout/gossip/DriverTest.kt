package fr.sdecout.gossip

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.containsExactlyInAnyOrder
import strikt.assertions.isEqualTo
import strikt.assertions.message

class DriverTest {

    @Test
    fun `should fail to initialize from current index out of bounds`() {
        expectThrows<IndexOutOfBoundsException> {
            Driver(
                id = DriverId(1),
                route = Route(1, 2, 3),
                currentIndexInRoute = 3
            )
        }.message.isEqualTo("Current index (3) is out of found for route with length 3")
    }

    @Test
    fun `should add gossips`() {
        val driver = Driver(
            id = DriverId(1),
            route = Route(1, 2, 3),
            currentIndexInRoute = 2,
            knownGossips = setOf(DriverId(1), DriverId(2))
        )
        val newGossips = setOf(DriverId(2), DriverId(3))

        val updatedDriver = driver.addGossips(newGossips)

        expectThat(updatedDriver.knownGossips).containsExactlyInAnyOrder(
            DriverId(1), DriverId(2), DriverId(3)
        )
    }

    @Test
    fun `should go to next index in route when gossips are added`() {
        val driver = Driver(
            id = DriverId(1),
            route = Route(1, 2, 3),
            currentIndexInRoute = 2,
            knownGossips = setOf(DriverId(1), DriverId(2))
        )
        val newGossips = setOf(DriverId(2), DriverId(3))

        val updatedDriver = driver.addGossips(newGossips)

        expectThat(updatedDriver.currentIndexInRoute).isEqualTo(0)
    }

}
