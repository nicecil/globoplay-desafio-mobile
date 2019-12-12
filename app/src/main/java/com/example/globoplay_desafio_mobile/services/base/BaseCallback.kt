package com.example.globoplay_desafio_mobile.services.base

import retrofit2.Call
import retrofit2.Response

interface BaseCallback<T> {
    fun onResponse(response: Response<T>)

    fun onGeneralError(call: Call<T>, t: Throwable)
}