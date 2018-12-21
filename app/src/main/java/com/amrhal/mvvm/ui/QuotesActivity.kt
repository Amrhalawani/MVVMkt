package com.amrhal.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.amrhal.mvvm.FakeRoomDatabase.Quote

import com.amrhal.mvvm.R
import com.amrhal.mvvm.utilities.injectorUtil
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {

    //https://www.youtube.com/playlist?list=PLB6lc7nQ1n4hbwVP0lBAQWMgUY9r-PhYe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        initUI()
    }

    private fun initUI() {
        val factory = injectorUtil.provideQouteViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n")
                textView_quotes.text = stringBuilder.toString()
            }
        })

        button_add_quote.setOnClickListener {

            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")


        }
    }

}
