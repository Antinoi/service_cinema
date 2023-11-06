package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Seans(val id: Int, val filmId: Int, val dataId: Int, val zalId: Int, val cost: Int)
