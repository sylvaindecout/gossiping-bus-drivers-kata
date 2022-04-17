package fr.sdecout.gossip

import fr.sdecout.gossip.MinuteOfDay.Companion.endOfDay
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isFalse
import strikt.assertions.isNull
import strikt.assertions.isTrue

class GossipsTest {

    @Test
    fun `should check that all drivers are on board`() {
        val gossips = Gossips(drivers = setOf(
            Driver(id = DriverId(1), route = Route(1, 2), knownGossips = setOf(DriverId(1), DriverId(2))),
            Driver(id = DriverId(2), route = Route(3, 2), knownGossips = setOf(DriverId(1), DriverId(2)))
        ))

        val check = gossips.allDriversAreOnBoard

        expectThat(check).isTrue()
    }

    @Test
    fun `should not check that all drivers are on board if some are missing`() {
        val gossips = Gossips(drivers = setOf(
            Driver(id = DriverId(1), route = Route(1, 2), knownGossips = setOf(DriverId(1), DriverId(2))),
            Driver(id = DriverId(2), route = Route(3, 2), knownGossips = setOf(DriverId(1)))
        ))

        val check = gossips.allDriversAreOnBoard

        expectThat(check).isFalse()
    }

    @Test
    fun `should stop time at the end of the day`() {
        val gossips = Gossips(endOfDay(), setOf(
            Driver(id = DriverId(1), route = Route(1, 2), knownGossips = setOf(DriverId(1), DriverId(2))),
            Driver(id = DriverId(2), route = Route(3, 2), knownGossips = setOf(DriverId(1)))
        ))

        val next = gossips.next()

        expectThat(next).isNull()
    }

    @Test
    fun `should increment minute of the day when time passes`() {
        val gossips = Gossips(MinuteOfDay(9), setOf(
            Driver(id = DriverId(1), route = Route(1, 2), currentIndexInRoute = 1, knownGossips = setOf(DriverId(1), DriverId(2))),
            Driver(id = DriverId(2), route = Route(3, 2), currentIndexInRoute = 1, knownGossips = setOf(DriverId(1)))
        ))

        val next = gossips.next()

        expectThat(next?.minuteOfDay).isEqualTo(MinuteOfDay(10))
    }

    @Test
    fun `should add new gossips when time passes`() {
        val gossips = Gossips(MinuteOfDay(9), setOf(
            Driver(id = DriverId(1), route = Route(1, 2), currentIndexInRoute = 1, knownGossips = setOf(DriverId(1), DriverId(2))),
            Driver(id = DriverId(2), route = Route(3, 2), currentIndexInRoute = 1, knownGossips = setOf(DriverId(1)))
        ))

        val next = gossips.next()

        expectThat(next?.drivers).isEqualTo(setOf(
            Driver(id = DriverId(1), route = Route(1, 2), currentIndexInRoute = 0, knownGossips = setOf(DriverId(1), DriverId(2))),
            Driver(id = DriverId(2), route = Route(3, 2), currentIndexInRoute = 0, knownGossips = setOf(DriverId(1), DriverId(2)))
        ))
    }

}
