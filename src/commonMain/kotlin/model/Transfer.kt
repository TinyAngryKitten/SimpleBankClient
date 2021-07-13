package model

import kotlinx.serialization.Serializable

@Serializable
data class Transfer(
    val to : String,
    val from : String,
    val amount : Double,
    val message : String
)