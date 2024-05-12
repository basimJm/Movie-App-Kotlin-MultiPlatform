package com.blackhand.moviekmp.data.remote

import com.blackhand.moviekmp.common.utils.Constants.BASE_URL
import com.blackhand.moviekmp.common.utils.Constants.MY_TOKEN
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal abstract class KtorClient {
    // define client side
    val client = HttpClient {
        // install plugin
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
                coerceInputValues = true
            })
        }
    }

    //create extension  function from http request builder to pass base url and end point  and header for each http request
    fun HttpRequestBuilder.pathUrl(endPoint: String) {
        url {
            takeFrom(BASE_URL)
            path(endPoint)
            header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZWExNjBkNjI5ODNlOTI0NTY5ZDdmZjJlNDFkMjY0YSIsInN1YiI6IjY2M2ZmOWQ5NzM2MTM4NjA3ZDdlOTNiYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.BoyXFVspJ0TDci91ItnYDVtNgLrhsD1fNoOWCIaJYhI")
        }
    }
}