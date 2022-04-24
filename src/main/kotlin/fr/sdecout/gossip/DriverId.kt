package fr.sdecout.gossip

import fr.sdecout.annotations.DomainDrivenDesign

@JvmInline
@DomainDrivenDesign.ValueObject
value class DriverId(private val value: Int) {

    override fun toString(): String = "Driver #$value"

}
