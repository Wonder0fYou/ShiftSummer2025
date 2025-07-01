package ru.shift.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import ru.shift.remote.api.TokenProvider
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val tokenProvider: TokenProvider,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val token = tokenProvider.getToken()

        val authorizationRequest = request.newBuilder()
            .header("Authorization", "Bearer $token")
            .build()

        return chain.proceed(authorizationRequest)
    }
}