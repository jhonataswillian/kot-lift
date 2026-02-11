package com.example.database

import org.jetbrains.exposed.sql.Table

object Exercises : Table("exercises") {

    val id = integer("id").autoIncrement()
    val name = varchar("name", 100)
    val weight = double("weight")
    val sets = integer("sets")
    val reps = integer("reps")

    val workout_id = integer("workout_id").references(Workouts.id)

    override val primaryKey = PrimaryKey(id)
}