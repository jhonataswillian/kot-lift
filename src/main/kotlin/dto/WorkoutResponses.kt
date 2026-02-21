package com.example.dto

import com.example.models.Exercise
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class WorkoutReport(
    val workoutId: Int,
    val totalVolume: Double,
    val exerciseCount: Int
) {}

@Serializable
data class WorkoutDetailsResponse(
    val id: Int,
    val name: String,
    val description: String,
    val durationMinutes: Int,
    val date: LocalDateTime,
    val exercises: List<Exercise>
) {}