package com.amrhal.mvvm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amrhal.mvvm.FakeRoomDatabase.QuotesRepository

class QuoteViewModelFactory(private val quoteRep: QuotesRepository)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRep) as T
    }

}