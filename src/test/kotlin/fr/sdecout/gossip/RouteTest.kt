package fr.sdecout.gossip

import fr.sdecout.gossip.MinuteOfDay.Companion.startOfDay
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class RouteTest {

    @Test
    fun `should resolve bus stop at selected start of the day`() {
        val route = Route(1, 2, 3)

        val busStop = route.busStopAt(startOfDay())

        expectThat(busStop).isEqualTo(BusStopId(1))
    }

    @Test
    fun `should resolve bus stop at the end of the route`() {
        val route = Route(1, 2, 3)

        val busStop = route.busStopAt(MinuteOfDay(2))

        expectThat(busStop).isEqualTo(BusStopId(3))
    }

    @Test
    fun `should resolve bus stop at selected minute of the day`() {
        val route = Route(1, 2, 3)

        val busStop = route.busStopAt(MinuteOfDay(7))

        expectThat(busStop).isEqualTo(BusStopId(2))
    }

}
