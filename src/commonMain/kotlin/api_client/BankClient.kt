package api_client

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.statement.use
import io.ktor.http.*
import io.ktor.util.*
import io.ktor.utils.io.charsets.Charsets.UTF_8
import io.ktor.utils.io.core.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonTransformingSerializer
import kotlinx.serialization.modules.SerializersModule
import model.AccessToken
import model.Account
import model.AccountResponse
import model.JWT

expect val httpClientEngine : HttpClientEngineFactory<HttpClientEngineConfig>

abstract class BankClient {
    abstract val identityServerUrl : String
    abstract val baseApiUrl : String
    abstract val clientId : String
    abstract val clientSecret : String
    abstract val userid : String
    val basicAuth: String by lazy { getBase64AuthString(clientId, clientSecret) }

    abstract val accountsPath : String

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

    open suspend fun getAccessToken(clientId : String, clientSecret : String) : AccessToken? {
        client.use { client ->
            return client.request(identityServerUrl) {
                method = HttpMethod.Post
                header("Accept", "application/json")
                addTokenRequestAuthHeader()
                header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
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

    open suspend fun listAccounts(userId: String, token: String): AccountResponse {
        client.use { client ->
            return client.request(baseApiUrl+accountsPath) {
                header("Accept", "application/json")
                header("Authorization", "Bearer $token")
                header("customerId", userId)
            }
        }
    }

    open suspend fun listAccountTransfers(userId: String, token: String): AccountResponse {
        client.use { client ->
            return client.request(baseApiUrl+accountsPath) {
                header("Accept", "application/json")
                header("Authorization", "Bearer $token")
                header("customerId", userId)
            }
        }
    }

    @OptIn(InternalAPI::class)
    open fun getBase64AuthString(clientId: String, secret: String): String =
        String(
            Base64.encoder.encode(
                "${clientId.encodeURLParameter(true)}:${secret.encodeURLParameter(true)}"
                    .toByteArray()
            )
        )
}