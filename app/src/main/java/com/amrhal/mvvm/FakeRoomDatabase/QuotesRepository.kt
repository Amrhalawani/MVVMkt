package com.amrhal.mvvm.FakeRoomDatabase

class QuotesRepository private constructor( private val quotesDao: FakeQuotesDAO){
     //private cuz we wanna make declaration from get instance not form the constructor

fun addQuote(quote:Quote){
    quotesDao.addQuote(quote)

}
    fun getQuote() = quotesDao.getQuotes()

    companion object {
        @Volatile private var instance: QuotesRepository? = null // volatile means that writes to this field are immediately made visible to other threads.

        fun getInstance(quotesDaoInstance: FakeQuotesDAO) = instance ?: synchronized(this){ //elvis operator if instance equal null will use the rest of code
            instance ?: QuotesRepository(quotesDaoInstance).also { instance = it
            } // it means the refrance instance something like "this"
        }
    }

}