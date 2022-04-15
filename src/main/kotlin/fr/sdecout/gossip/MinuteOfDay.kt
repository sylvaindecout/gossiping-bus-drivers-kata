package fr.sdecout.gossip

import fr.sdecout.annotations.DomainDrivenDesign
import java.time.LocalTime

@DomainDrivenDesign.ValueObject
data class MinuteOfDay(val value: Int) {

    init {
        if (value !in 0..480) throw IllegalArgumentException("Invalid value: $value")
    }

    private val asLocalTime: LocalTime by lazy { LocalTime.parse("09:00").plusMinutes(value.toLong()) }

    fun next() = MinuteOfDay(this.value + 1)

    override fun toString(): String = "$asLocalTime"

    companion object {
        fun startOfDay() = MinuteOfDay(0)
        fun endOfDay() = MinuteOfDay(480)
    }

}
