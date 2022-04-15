package fr.sdecout.gossip

data class Schedule(val driverRoutes: Map<DriverId, Route>) {

    constructor(vararg driverRoutes: Route) : this(driverRoutes
        .mapIndexed { id, route -> DriverId(id) to route }
        .toMap())

    fun numberOfStopsToHaveAllDriversOnBoard(): Int? =
        advanceUntilAllDriversOnBoard(Gossips(drivers = driverRoutes.toDrivers()))?.minuteOfDay?.value

    private fun advanceUntilAllDriversOnBoard(gossips: Gossips): Gossips? = if (gossips.allDriversAreOnBoard)
        gossips else
        gossips.next()?.let { advanceUntilAllDriversOnBoard(it) }

    private fun Map<DriverId, Route>.toDrivers(): Set<Driver> = this
        .map { Driver(id = it.key, route = it.value) }
        .toSet()

}
