package model

import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.Instant
import kotlinx.datetime.until

interface AccessToken {
    val access_token : String
    val valid_until : Instant
    val isValid : Boolean
}

val AccessToken?.isValid : Boolean
    get() = false