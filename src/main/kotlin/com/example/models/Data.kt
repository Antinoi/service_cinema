package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Data(val id: Int, val data: Int, val time: Pair<Int, Int>)
