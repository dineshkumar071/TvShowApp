package com.example.dashboardproject.service

import okhttp3.Headers
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.net.URISyntaxException
import javax.inject.Inject

class HttpInterceptor @Inject constructor():
    Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val authenticationRequest = request.newBuilder().headers(getHeader(request)).build()
        val response: Response = chain.proceed(authenticationRequest)
        return checkStatusCode(response)
    }
    private fun getHeader(request: Request): Headers {
        return request.headers.newBuilder()
            .add("Content-Type", "application/json;charset=utf-8")
            .add("Accept", "application/json")
            .add("API key", "Need to enter API KEY")
            .build()
    }
}

@Throws(IOException::class)
fun checkStatusCode(mResponse: Response): Response {
    return when (mResponse.code) {
        400, 403, 404, 405, 409, 422, 424, 429, 500 -> {
            throw IOException(mResponse.code.toString())
        }
        else -> {
            mResponse
        }
    }
}