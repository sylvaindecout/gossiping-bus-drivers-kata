package fr.sdecout.gossip

data class Gossips(val minuteOfDay: MinuteOfDay = MinuteOfDay.startOfDay(), val drivers: Set<Driver>) {

    val allDriversAreOnBoard: Boolean by lazy { drivers.all { it.knownGossips == allDriverIds } }

    private val allDriverIds: Set<DriverId> by lazy { drivers.map { it.id }.toSet() }

    private val driverPositions: Map<DriverId, BusStopId> by lazy {
        drivers.associate { it.id to it.route.busStopAt(it.currentIndexInRoute) }
    }

    private val driversPerBusStop: Map<BusStopId, List<Driver>> by lazy {
        drivers.groupBy { driverPositions[it.id]!! }
    }

    fun next(): Gossips? = minuteOfDay
        .takeUnless { it == MinuteOfDay.endOfDay() }
        ?.let { Gossips(
            minuteOfDay = it.next(),
            drivers = drivers.map { driver -> addGossipsTo(driver) }.toSet()
        ) }

    private fun addGossipsTo(driver: Driver) = driver.addGossips(
        driversAtSameLocationsAs(driver.id).flatMap { it.knownGossips }
    )

    private fun driversAtSameLocationsAs(driver: DriverId) = driversPerBusStop[driverPositions[driver]]!!.toSet()

}
