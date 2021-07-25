package model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class TransactionResponse(
    val availableItems : Int,
    val items: List<Transaction>
)

@Serializable
data class Transaction(
    val accountingDate : LocalDateTime,
    val amount : Double,
    val text : String,
    val transactionType : String,
    val transactionTypeText : String,
    val isReservation : Boolean,
    val source : String,
    val otherAccountNumber : String? = null,
    val cardDetails: CardDetails? = null,
    val transactionDetail: TransactionDetail? = null
) {
    override fun equals(other: Any?): Boolean =
        if(other is Transaction)
            if(transactionId != null && transactionId == other.transactionId) true
            else accountingDate compareWith other.accountingDate &&
            amount compareWith other.amount &&
            text compareWith other.text &&
            transactionType compareWith other.transactionType &&
            transactionTypeText compareWith other.transactionTypeText &&
            isReservation compareWith other.isReservation &&
            source compareWith other.source &&
            otherAccountNumber compareWith other.otherAccountNumber &&
            cardDetails compareWith other.cardDetails &&
            transactionDetail compareWith other.transactionDetail
        else false

    private val transactionId : String? = cardDetails?.transactionId ?: transactionDetail?.transactionId

    private infix fun <T : Any?> T.compareWith(other : T?) : Boolean =
        //ignore fields where one or both are null,
        //in case one of the transactions are from a time where this field was unavailable.
        //It should (hopefully and most likely) be possible to always differentiate transactions by the fields that are present anyways
        if(this == null || other == null) true
        else this == other
}

@Serializable
data class CardDetails(
    val cardNumber : String,
    val currencyAmount : Double,
    val currencyRate : Double,
    val merchantCategoryCode : String,
    val merchantCategoryDescription : String,
    val merchantCity : String,
    val merchantName : String,
    val originalCurrencyCode : String,
    val purchaseDate : LocalDateTime,
    val transactionId : String
)

@Serializable
data class TransactionDetail(
    val formattedDAccountNumber : String,
    val transactionId : String,
    val cid : String,
    val receiverName : String,
    val numericReference : Long,
    val payerName : String,
    val registrationDate : LocalDateTime
)