package fr.sdecout.gossip

import fr.sdecout.gossip.MinuteOfDay.Companion.endOfDay
import fr.sdecout.gossip.MinuteOfDay.Companion.startOfDay
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.isEqualTo
import strikt.assertions.message

class MinuteOfDayTest {

    @Test
    fun `should fail to initialize from value below 0`() {
        expectThrows<IllegalArgumentException> { MinuteOfDay(-1) }
            .message.isEqualTo("Invalid value: -1")
    }

    @Test
    fun `should fail to initialize from value above 480`() {
        expectThrows<IllegalArgumentException> { MinuteOfDay(481) }
            .message.isEqualTo("Invalid value: 481")
    }

    @Test
    fun `should increment`() {
        val minuteOfDay = MinuteOfDay(38)

        val nextMinuteOfDay = minuteOfDay.next()

        expectThat(nextMinuteOfDay).isEqualTo(MinuteOfDay(39))
    }

    @Test
    fun `should display as string`() {
        val minuteOfDay = MinuteOfDay(38)

        val string = minuteOfDay.toString()

        expectThat(string).isEqualTo("09:38")
    }

    @Test
    fun `should display start of day as string`() {
        val minuteOfDay = startOfDay()

        val string = minuteOfDay.toString()

        expectThat(string).isEqualTo("09:00")
    }

    @Test
    fun `should display end of day as string`() {
        val minuteOfDay = endOfDay()

        val string = minuteOfDay.toString()

        expectThat(string).isEqualTo("17:00")
    }

}
