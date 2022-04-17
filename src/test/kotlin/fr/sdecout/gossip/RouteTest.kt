package fr.sdecout.gossip

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.isEqualTo
import strikt.assertions.message

class RouteTest {

    @Test
    fun `should resolve length`() {
        val route = Route(1, 2, 3)

        val length = route.length

        expectThat(length).isEqualTo(3)
    }

    @Test
    fun `should resolve bus stop at index 0`() {
        val route = Route(1, 2, 3)

        val busStop = route.busStopAt(0)

        expectThat(busStop).isEqualTo(BusStopId(1))
    }

    @Test
    fun `should resolve bus stop at last valid index`() {
        val route = Route(1, 2, 3)

        val busStop = route.busStopAt(2)

        expectThat(busStop).isEqualTo(BusStopId(3))
    }

    @Test
    fun `should resolve bus stop at index out of bounds`() {
        val route = Route(1, 2, 3)

        expectThrows<IndexOutOfBoundsException> { route.busStopAt(3) }
            .message.isEqualTo("Index 3 out of bounds for length 3")
    }

}
