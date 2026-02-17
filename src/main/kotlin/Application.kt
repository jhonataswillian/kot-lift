package com.example

import com.example.plugins.*
import com.example.repositories.ExposedExerciseRepository
import com.example.repositories.ExposedWorkoutRepository
import com.example.routes.exerciseRoutes
import com.example.routes.workoutRoutes
import com.example.services.ExerciseService
import com.example.services.WorkoutService
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureDatabases()
    configureMonitoring()
    configureRouting()
    configureStatusPages()

    val workoutRepository = ExposedWorkoutRepository()
    val workoutService = WorkoutService(workoutRepository)

    val exerciseRepository = ExposedExerciseRepository()
    val exerciseService = ExerciseService(exerciseRepository)

    routing {
        workoutRoutes(workoutService)
        exerciseRoutes(exerciseService)
    }
}
