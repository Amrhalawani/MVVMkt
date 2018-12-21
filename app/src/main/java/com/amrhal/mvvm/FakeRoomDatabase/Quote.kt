package com.amrhal.mvvm.FakeRoomDatabase

data class Quote(val quotesText:String, val author:String ) {


    override fun toString(): String {
        return "quotes: $quotesText - author: $author "
    }
}