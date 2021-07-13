import api_client.SBankenBankClient
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

val userId = ""
val clientId = ""
val clientSecret = ""

class Test {
    @Test
    fun test() {
        runBlocking {
            val client = SBankenBankClient(userId,clientId,clientSecret)
            val token = client.getAccessToken(clientId, clientSecret)
            val accounts = client.listAccounts(userId,token!!.access_token)
            println(token)
            println(accounts)
        }
    }
}