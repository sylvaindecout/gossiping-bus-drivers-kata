package fr.sdecout.gossip

import fr.sdecout.annotations.DomainDrivenDesign
import java.time.LocalTime

@JvmInline
@DomainDrivenDesign.ValueObject
value class MinuteOfDay(val value: Int) {

    init {
        if (value !in 0..480) throw IllegalArgumentException("Invalid value: $value")
    }

    fun next() = MinuteOfDay(this.value + 1)

    override fun toString(): String = LocalTime.parse("09:00").plusMinutes(value.toLong()).toString()

    companion object {
        fun startOfDay() = MinuteOfDay(0)
        fun endOfDay() = MinuteOfDay(480)
    }

}
