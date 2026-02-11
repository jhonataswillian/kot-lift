package com.example.repositories

import com.example.models.Exercise

interface ExerciseRepository {

    suspend fun exercisesByWorkout(workoutId: Int): List<Exercise>

    suspend fun addExercise(exercise: Exercise): Exercise

    suspend fun deleteExercise(id: Int): Boolean
}