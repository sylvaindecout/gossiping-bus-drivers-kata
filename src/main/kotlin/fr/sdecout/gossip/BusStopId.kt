package fr.sdecout.gossip

import fr.sdecout.annotations.DomainDrivenDesign

@DomainDrivenDesign.ValueObject
data class BusStopId(val value: Int) {

    override fun toString(): String = "Stop #$value"

}
