package api_client

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.util.*
import io.ktor.utils.io.*
import io.ktor.utils.io.core.*
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.modules.SerializersModule
import model.*
import kotlin.time.ExperimentalTime
import kotlin.time.days

expect val httpClientEngine : HttpClientEngineFactory<HttpClientEngineConfig>

@OptIn(ExperimentalTime::class)
abstract class BankClient {
    abstract val identityServerUrl : String
    abstract val baseApiUrl : String
    abstract val clientId : String
    abstract val clientSecret : String
    abstract val userid : String
    open val basicAuth: String by lazy { getBase64AuthString(clientId, clientSecret) }

    abstract val accountsPath : String
    abstract val transactionPath : String
    abstract val transactionArchivePath : String//bokførte transaksjoner
    abstract val transferPath : String

    open val serializersModule = SerializersModule {
        @Suppress("UNCHECKED_CAST")
        contextual(AccessToken::class, JWT.serializer() as (KSerializer<AccessToken>))
    }

    val client : HttpClient
        get() = HttpClient(httpClientEngine){
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                ignoreUnknownKeys = true
                serializersModule = this@BankClient.serializersModule
            })
        }
    }

    open suspend fun getAccessToken() : AccessToken? {
        client.use { client ->
            return client.request(identityServerUrl) {
                method = HttpMethod.Post
                header("Accept", "application/json")
                header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
                addTokenRequestAuthHeader()

                addTokenRequestBody()
            }
        }
    }

    internal open fun HttpRequestBuilder.addTokenRequestAuthHeader() {
        header("Authorization", "Basic $basicAuth")
    }
    internal open fun HttpRequestBuilder.addTokenRequestBody() {
        body = "grant_type=client_credentials".toByteArray()
    }

    open suspend fun listAccounts(token: String): AccountResponse {
        client.use { client ->
            return client.request(baseApiUrl+accountsPath) {
                header("Accept", "application/json")
                header("Authorization", "Bearer $token")
            }
        }
    }

    open suspend fun fetchAccount(accountId : String, token: String): Account {
        client.use { client ->
            return client.request("$baseApiUrl$accountsPath$accountId") {
                header("Accept", "application/json")
                addAccessTokenToRequest(token)
            }
        }
    }

    open suspend fun transferMoney(transfer: Transfer, token : String) : Boolean {
        client.use { client ->
            val response = client.request<HttpResponse>("$baseApiUrl$transferPath") {
                header("Content-Type", "application/json")
                addAccessTokenToRequest(token)
                addTransferToRequest(transfer)
                method = HttpMethod.Post
                expectSuccess = false
            }

            if(response.status != HttpStatusCode.NoContent) throw Exception("Error when transferring money: " + (response.readText()))
            return response.status == HttpStatusCode.NoContent
        }
    }

    internal open fun HttpRequestBuilder.addTransferToRequest(transfer: Transfer) {
        body = buildJsonObject {
            put("Amount", transfer.amount)
            put("FromAccountId", transfer.from)
            put("ToAccountId", transfer.to)
            put("Message", transfer.message)
        }
    }

    open suspend fun fetchTransactions(
        token : String,
        accountId : String,
        maxCount : Int? = null,
        startDate : Instant? = null,
        endDate : Instant? = null
    ) : TransactionResponse {
        val startString = instantToDateString(startDate)
        val endString = instantToDateString(endDate)
        client.use { client ->
            return client.request("$baseApiUrl$transactionPath$accountId") {
                header("Accept", "application/json")
                addAccessTokenToRequest(token)
                if(startString != null) parameter("startDate", startString)
                if(endString != null) parameter("endDate",endString)
                if(maxCount != null) parameter("length", maxCount)
            }
        }
    }

    open suspend fun fetchArchivedTransactions(
        token : String,
        accountId : String,
        maxCount : Int? = null,
        startDate : Instant? = null,
        endDate : Instant? = null
    ) : TransactionResponse {
        val startString = instantToDateString(startDate)
        val endString = instantToDateString(endDate)
        client.use { client ->
            return client.request("$baseApiUrl$transactionArchivePath$accountId") {
                header("Accept", "application/json")
                addAccessTokenToRequest(token)
                if(startString != null) parameter("startDate", startString)
                if(endString != null) parameter("endDate",endString)
                if(maxCount != null) parameter("length", maxCount)
            }
        }
    }

    internal open fun instantToDateString(instant : Instant?) = instant
        ?.toLocalDateTime(TimeZone.currentSystemDefault())
        ?.run {
            "$year-${if(monthNumber > 9) monthNumber else "0$monthNumber"}-${if(dayOfMonth > 9) dayOfMonth else "0$dayOfMonth"}"
        }

    internal open fun HttpRequestBuilder.addAccessTokenToRequest(token : String) {
        header("Authorization", "Bearer $token")
    }

    open fun getBase64AuthString(clientId: String, secret: String): String =
        String(
            Base64.encoder.encode(
                "${clientId.encodeURLParameter(true)}:${secret.encodeURLParameter(true)}"
                    .toByteArray()
            )
        )
}