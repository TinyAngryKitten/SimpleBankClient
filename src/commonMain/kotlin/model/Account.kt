package model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class AccountResponse(
    val availableItems : Int,
    val items: List<Account>
    )

@Serializable
data class Account(
    @JsonNames("accountId", "AccountId")
    val id : String,
    @JsonNames("accountNumber", "AccountNumber")
    val number : String,
    @JsonNames("ownerCustomerId", "accountOwner", "AccountOwner")
    val owner : String,
    @JsonNames("accountName", "AccountName")
    val name : String,
    @JsonNames("accountType", "AccountType")
    val type : String,
    @JsonNames("Available")
    val available : Double,
    @JsonNames("Balance")
    val balance : Double,
    )