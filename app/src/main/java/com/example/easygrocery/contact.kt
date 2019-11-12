package com.example.easygrocery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contact.*

class contact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)


        homeContact.setOnClickListener() {
       // setContentView(R.layout.activity_main)
            finish()
        }
    }
        }

