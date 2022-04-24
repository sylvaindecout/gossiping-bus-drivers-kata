package fr.sdecout.gossip

import fr.sdecout.annotations.DomainDrivenDesign

@JvmInline
@DomainDrivenDesign.ValueObject
value class BusStopId(private val value: Int) {

    override fun toString(): String = "Stop #$value"

}
