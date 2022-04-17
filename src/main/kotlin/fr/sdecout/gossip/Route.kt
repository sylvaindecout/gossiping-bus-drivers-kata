package fr.sdecout.gossip

import fr.sdecout.annotations.DomainDrivenDesign

@DomainDrivenDesign.ValueObject
data class Route(val busStops: List<BusStopId>) {

    constructor(vararg busStops: Int) : this(busStops.map { BusStopId(it) })

    val length: Int by lazy { busStops.size }

    fun busStopAt(index: Int): BusStopId = busStops[index]

}
