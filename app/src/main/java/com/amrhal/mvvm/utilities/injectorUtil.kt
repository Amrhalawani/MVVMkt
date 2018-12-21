package com.amrhal.mvvm.utilities

import com.amrhal.mvvm.FakeRoomDatabase.FakeDatabase
import com.amrhal.mvvm.FakeRoomDatabase.QuotesRepository
import com.amrhal.mvvm.ui.QuoteViewModelFactory

object injectorUtil {
    // instead of using dagger 2 or DI, this is an sample of injector

    fun provideQouteViewModelFactory():QuoteViewModelFactory{

        val quotesRepository = QuotesRepository.getInstance(FakeDatabase.getInstance().qoateDao)
        return QuoteViewModelFactory(quotesRepository)

    }
}