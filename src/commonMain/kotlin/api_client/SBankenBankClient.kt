package api_client

class SBankenBankClient(
    override val userid : String,
    override val clientId : String,
    override val clientSecret : String
    ) : BankClient() {
    override val identityServerUrl: String = "https://auth.sbanken.no/identityserver/connect/token"
    override val baseApiUrl: String = "https://publicapi.sbanken.no/apibeta/api/v2/"

    override val accountsPath: String = "Accounts/"
    override val transactionPath: String = "Transactions/"
    override val transactionArchivePath: String = "Transactions/archive/"
    override val transferPath: String = "Transfers/"
}