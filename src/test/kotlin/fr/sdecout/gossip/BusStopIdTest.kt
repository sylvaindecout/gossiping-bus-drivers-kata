package fr.sdecout.gossip

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class BusStopIdTest {

    @Test
    fun `should display as string`() {
        val busStopId = BusStopId(8)

        val string = busStopId.toString()

        expectThat(string).isEqualTo("Stop #8")
    }

}
