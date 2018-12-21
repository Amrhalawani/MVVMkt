package com.amrhal.mvvm.FakeRoomDatabase

class FakeDatabase private constructor(){

    var qoateDao = FakeQuotesDAO()
        private set


    companion object {
        @Volatile private var instance: FakeDatabase? = null // volatile means that writes to this field are immediately made visible to other threads.

        fun getInstance() = instance ?: synchronized(this){ //elvis operator if instance equal null will use the rest of code
            instance ?: FakeDatabase().also { instance = it
            } // "it" means the reference instance something like "this"
        }
    }


}