package com.example.services

import com.example.dto.CreateExerciseRequest
import com.example.dto.toModel
import com.example.models.Exercise
import com.example.repositories.ExerciseRepository

class ExerciseService(private val repository: ExerciseRepository){

    suspend fun create(request: CreateExerciseRequest): Exercise {
        if (request.weight < 0) { throw IllegalArgumentException("O peso não pode ser negativo") }
        val model = request.toModel()
        return repository.addExercise(model)
    }

    suspend fun findAllByWorkout(workoutId: Int): List<Exercise> {
        return repository.exercisesByWorkout(workoutId)
    }

    suspend fun delete(id: Int): Boolean {
        return repository.deleteExercise(id)
    }
}