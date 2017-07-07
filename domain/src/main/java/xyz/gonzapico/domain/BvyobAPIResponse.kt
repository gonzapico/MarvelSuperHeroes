package xyz.gonzapico.domain

/**
 * Created by gfernandez on 6/27/17.
 */
class SuperHeroesAPIResponse(
    val superheroes: List<SuperHero>
)

class SuperHero(
    val name: String,
    val photo: String,
    val realName: String,
    val height: String,
    val power: String,
    val abilities: String
)
