package fr.sdecout.gossip

import fr.sdecout.annotations.DomainDrivenDesign

@DomainDrivenDesign.ValueObject
data class DriverId(val value: Int) {

    override fun toString(): String = "Driver #$value"

}
