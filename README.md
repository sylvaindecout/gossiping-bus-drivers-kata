# Gossiping bus drivers kata

[![Tests](https://github.com/sylvaindecout/gossiping-bus-drivers-kata/actions/workflows/gradle.yml/badge.svg?branch=main)](https://github.com/sylvaindecout/gossiping-bus-drivers-kata/actions/workflows/gradle.yml) [![Gitmoji](https://img.shields.io/badge/gitmoji-%20%F0%9F%98%9C%20%F0%9F%98%8D-FFDD67.svg)](https://gitmoji.dev)

## Usage

*Note: This project depends on a personal GitHub Package Registry. In order to build locally, it is necessary to set
USERNAME and TOKEN environment variables. Instructions for the generation of a token are available in 
[Creating a personal access token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token).*

Run tests: `./gradlew test`

Run mutation coverage: `./gradlew pitest`

## Problem

Source: [r/dailyprogrammer](https://www.reddit.com/r/dailyprogrammer/comments/4gqm90/20160427_challenge_264_intermediate_gossiping_bus/)

### Description
Bus drivers like to gossip, everyone knows that. And bus drivers can gossip when they end up at the same stop. So now we are going to calculate after how many stops all the bus drivers know all the gossips. 

You will be given a number of bus routes that the drivers follow. Each driver starts with one gossip. Each route is appointed to 1 driver. When 2 or more drivers are at the same stop (even if it is the start), they can exchange all the gossips they know. 

A route looks like this: `1 2 3 4` and is repeated over the whole day like this `1 2 3 4 1 2 3 4 1 2 3 …` If a driver starts and stops at the same stop then that is also repeated. (e.g. route: `1 2 3 1`, day: `1 2 3 1 1 2 3 1 1 2 …`)

All drivers take 1 minute to go from one stop to another and the gossip exchange happens instantly. 

All drivers drive 8 hours a day, so you have a maximum of 480 minutes to get all the gossiping around.

### Input Description
You will receive all the driver routes. Not all drivers have a route of the same length.

#### Example 1
```
3 1 2 3
3 2 3 1
4 2 3 4 5
```
#### Example 2
```
2 1 2
5 2 8
```

### Output Description
The number of stops it takes to have all drivers on board with the latest gossips. 

If there is even one driver who does not have all the gossips by the end of the day, the answer is `never`.

#### Example 1
```
5
```

#### Example 1
```
never
```

### Challenge Input

#### Input 1
```
7 11 2 2 4 8 2 2
3 0 11 8
5 11 8 10 3 11
5 9 2 5 0 3
7 4 8 2 8 1 0 5
3 6 8 9
4 2 11 3 3
```

#### Input 2
```
12 23 15 2 8 20 21 3 23 3 27 20 0
21 14 8 20 10 0 23 3 24 23 0 19 14 12 10 9 12 12 11 6 27 5
8 18 27 10 11 22 29 23 14
13 7 14 1 9 14 16 12 0 10 13 19 16 17
24 25 21 4 6 19 1 3 26 11 22 28 14 14 27 7 20 8 7 4 1 8 10 18 21
13 20 26 22 6 5 6 23 26 2 21 16 26 24
6 7 17 2 22 23 21
23 14 22 28 10 23 7 21 3 20 24 23 8 8 21 13 15 6 9 17 27 17 13 14
23 13 1 15 5 16 7 26 22 29 17 3 14 16 16 18 6 10 3 14 10 17 27 25
25 28 5 21 8 10 27 21 23 28 7 20 6 6 9 29 27 26 24 3 12 10 21 10 12 17
26 22 26 13 10 19 3 15 2 3 25 29 25 19 19 24 1 26 22 10 17 19 28 11 22 2 13
8 4 25 15 20 9 11 3 19
24 29 4 17 2 0 8 19 11 28 13 4 16 5 15 25 16 5 6 1 0 19 7 4 6
16 25 15 17 20 27 1 11 1 18 14 23 27 25 26 17 1
```
