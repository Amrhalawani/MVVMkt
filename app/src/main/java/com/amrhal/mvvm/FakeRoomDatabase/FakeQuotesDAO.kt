package com.amrhal.mvvm.FakeRoomDatabase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuotesDAO {

    private val quotesList = mutableListOf<Quote>()
    private val quotesLiveData = MutableLiveData<List<Quote>>()

    init { // initializer block
        quotesLiveData.value = quotesList
    }

    fun addQuote(qoute: Quote) {
        quotesList.add(qoute)
        quotesLiveData.value = quotesList
    }

    fun getQuotes() = quotesLiveData as LiveData<List<Quote>>
}

