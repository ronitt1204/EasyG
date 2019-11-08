package com.example.easygrocery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shop.setOnClickListener() {
            setContentView(R.layout.activity_shop)
        }
            aboutUs.setOnClickListener() {
                setContentView(R.layout.activity_about)
            }
                contact.setOnClickListener {
                    setContentView(R.layout.activity_contact)
                }

    }
}
