package com.example.plugins

import com.example.database.Exercises
import com.example.database.Workouts
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDatabases() {
    val driverClassName = environment.config.property("storage.driverClassName").getString()
    val jdbcURL = environment.config.property("storage.jdbcURL").getString()
    val user = environment.config.property("storage.user").getString()
    val password = environment.config.property("storage.password").getString()

    val database = Database.connect(
        url = jdbcURL,
        user = user,
        driver = driverClassName,
        password = password,
    )

    transaction {
        SchemaUtils.create(Workouts, Exercises)
    }
}