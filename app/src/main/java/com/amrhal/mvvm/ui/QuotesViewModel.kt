package com.amrhal.mvvm.ui

import androidx.lifecycle.ViewModel
import com.amrhal.mvvm.FakeRoomDatabase.Quote
import com.amrhal.mvvm.FakeRoomDatabase.QuotesRepository

class QuotesViewModel(private val quoteRep: QuotesRepository) : ViewModel() {

    fun addQuote (qoute : Quote){
        quoteRep.addQuote(qoute)

    }
    fun getQuotes() =  quoteRep.getQuote()




}