package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Exercise (
    val id: Int? = null,
    val name: String,
    val weight: Double,
    val sets: Int,
    val reps: Int,
    val workoutId: Int
) {}