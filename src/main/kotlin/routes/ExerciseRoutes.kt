package com.example.routes

import com.example.dto.CreateExerciseRequest
import com.example.services.ExerciseService
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.exerciseRoutes(service: ExerciseService) {

    route("/exercises") {
        // Criar Exercício
        post {
            val exercise = call.receive<CreateExerciseRequest>()
            val newExercise = service.create(exercise)
            call.respond(HttpStatusCode.Created, newExercise)
        }

        // Deletar Exercício
        delete("/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id == null) {
                call.respond(HttpStatusCode.BadRequest, "Invalid ID")
                return@delete
            }

            val deleted = service.delete(id)
            if (deleted) {
                call.respond(HttpStatusCode.NoContent)
            } else {
                call.respond(HttpStatusCode.NotFound, "Exercise Not Found")
            }
        }
    }

    route("/workouts/{id}/exercises") {
        get {
            val workoutId = call.parameters["id"]?.toIntOrNull()
            if (workoutId == null) {
                call.respond(HttpStatusCode.BadRequest, "Invalid Workout ID")
                return@get
            }

            val exercises = service.findAllByWorkout(workoutId)
            call.respond(HttpStatusCode.OK, exercises)
        }
    }
}