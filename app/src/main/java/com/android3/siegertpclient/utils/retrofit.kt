package com.android3.siegertpclient.utils

import retrofit2.Retrofit

class retrofit {

    private val retrofit : Retrofit

    init {
        retrofit = Retrofit.Builder()
        .baseUrl("https://our.server.com/")
            .build()
        //Todo Include baseURL
    }

}