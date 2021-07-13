package api_client

import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*

actual val httpClientEngine: HttpClientEngineFactory<HttpClientEngineConfig>
    get() = CIO