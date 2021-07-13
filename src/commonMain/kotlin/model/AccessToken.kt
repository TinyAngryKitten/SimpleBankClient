package model

import kotlinx.datetime.Instant

interface AccessToken {
    val access_token : String
    val valid_until : Instant
}