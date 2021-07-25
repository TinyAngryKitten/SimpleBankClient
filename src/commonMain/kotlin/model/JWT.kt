package model

import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.Instant
import kotlinx.datetime.until
import kotlin.time.ExperimentalTime
import kotlinx.serialization.Serializable
import kotlin.time.seconds

@OptIn(ExperimentalTime::class)
@Serializable
data class JWT(
    override val access_token : String,
    val expires_in : Int,
    val token_type : String,
    val scope : String,
    val time_created : Instant = Clock.System.now().plus(expires_in.seconds)
) : AccessToken {
    override val valid_until = time_created.plus(expires_in.seconds)
    override val isValid: Boolean
        get() = valid_until.until(Clock.System.now(), DateTimeUnit.SECOND) > 0
}