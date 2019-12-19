package com.example.globoplay_desafio_mobile.ui.home

interface HomeFragmentPresenterInterface {
    fun attachView(homeFragmentView: HomeFragmentView)

    fun makeRequest()
}