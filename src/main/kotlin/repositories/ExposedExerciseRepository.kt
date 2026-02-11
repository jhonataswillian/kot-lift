package com.example.repositories

import com.example.database.Exercises
import com.example.models.Exercise
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq // Importante para o deleteWhere
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class ExposedExerciseRepository : ExerciseRepository {

    private suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }

    private fun resultRowToExercise(row: ResultRow) = Exercise(
        id = row[Exercises.id],
        name = row[Exercises.name],
        weight = row[Exercises.weight],
        sets = row[Exercises.sets],
        reps = row[Exercises.reps],
        workoutId = row[Exercises.workout_id]
    )

    override suspend fun exercisesByWorkout(workoutId: Int): List<Exercise> = dbQuery {
        Exercises
            .selectAll()
            .where{ Exercises.workout_id eq workoutId }
            .map { resultRowToExercise(it) }
    }

    override suspend fun addExercise(exercise: Exercise): Exercise = dbQuery {
        val insertStatement = Exercises.insert {
            it[name] = exercise.name
            it[weight] = exercise.weight
            it[sets] = exercise.sets
            it[reps] = exercise.reps
            it[workout_id] = exercise.workoutId
        }

        val id = insertStatement[Exercises.id]
        exercise.copy(id = id)
    }

    override suspend fun deleteExercise(id: Int): Boolean = dbQuery {
        val rowsDeleted = Exercises.deleteWhere { Exercises.id eq id }
        rowsDeleted > 0
    }
}