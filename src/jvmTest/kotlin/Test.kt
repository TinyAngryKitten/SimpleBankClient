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
            val accounts = client.listAccounts(token!!.access_token)
            val account = client.fetchAccount("D37446FB027A0252200ECA750A95337F", token.access_token)
            println(token)
            println(accounts)
            println(account)
        }
    }
}