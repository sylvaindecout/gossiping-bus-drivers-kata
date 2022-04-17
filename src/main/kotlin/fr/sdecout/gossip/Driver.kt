package fr.sdecout.gossip

import fr.sdecout.annotations.DomainDrivenDesign

@DomainDrivenDesign.Entity
data class Driver(
    val id: DriverId,
    val route: Route,
    val currentIndexInRoute: Int = 0,
    val knownGossips: Set<DriverId> = setOf(id)
) {

    init {
        if (currentIndexInRoute !in 0 until route.length) {
            throw IndexOutOfBoundsException("Current index ($currentIndexInRoute) is out of found for route with length ${route.length}")
        }
    }

    fun addGossips(gossips: Collection<DriverId>) = this.copy(
        currentIndexInRoute = (currentIndexInRoute + 1) % route.length,
        knownGossips = this.knownGossips + gossips
    )

}
