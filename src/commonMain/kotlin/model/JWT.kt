package model

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor

@OptIn(ExperimentalTime::class)
@Serializable
data class JWT(
    override val access_token : String,
    val expires_in : Int,
    val token_type : String,
    val scope : String,
    val time_created : Instant = Clock.System.now().plus(Duration.seconds(expires_in))
) : AccessToken {
    override val valid_until = time_created.plus(Duration.seconds(expires_in))
}