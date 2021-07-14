package api_client

import io.ktor.client.engine.*
import io.ktor.client.engine.js.*

actual val httpClientEngine: HttpClientEngineFactory<HttpClientEngineConfig>
    get() = Js