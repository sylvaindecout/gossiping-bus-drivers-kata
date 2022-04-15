package fr.sdecout.gossip

import fr.sdecout.annotations.DomainDrivenDesign

@DomainDrivenDesign.Entity
data class Driver(val id: DriverId, val route: Route, val knownGossips: Set<DriverId> = setOf(id)) {

    fun addGossips(gossips: Collection<DriverId>) = this.copy(knownGossips = this.knownGossips + gossips)

}
