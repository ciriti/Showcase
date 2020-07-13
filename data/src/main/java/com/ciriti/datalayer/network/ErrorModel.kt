package com.ciriti.datalayer.network

fun errorMapLocation(errorCode: Int): Throwable = when (errorCode) {
    in 300..399 -> RedirectException(ErrorMessage.REDIRECT)
    in 400..499 -> ClientErrorException(ErrorMessage.CLIENT_ERROR)
    in 500..599 -> ServerException(ErrorMessage.SERVER_ERROR)
    else -> GenericException(ErrorMessage.GENERIC_ERROR)
}

object ErrorMessage {
    const val REDIRECT = "Redirection message"
    const val CLIENT_ERROR = "Client error message"
    const val SERVER_ERROR = "Server error message"
    const val GENERIC_ERROR = "Generic error message"
}

class RedirectException(message: String = "") : RuntimeException(message)
class ClientErrorException(message: String = "") : RuntimeException(message)
class ServerException(message: String = "") : RuntimeException(message)
class GenericException(message: String = "") : RuntimeException(message)
