package model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class Transfer(
    @JsonNames("ToAccountId")
    val to : String,
    @JsonNames("FromAccountId")
    val from : String,
    @JsonNames("Amount")
    val amount : Int,
    @JsonNames("Message")
    val message : String
)