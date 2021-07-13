package api_client

import io.ktor.client.engine.*

actual val httpClientEngine: HttpClientEngineFactory<HttpClientEngineConfig>
    get() = Js