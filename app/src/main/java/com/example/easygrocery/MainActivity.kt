package com.example.easygrocery

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.activity_shop.*
import kotlinx.android.synthetic.main.activity_contact.*

import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    var db = FirebaseFirestore.getInstance()

    override fun onStart() {
        super.onStart()

        // check for authenticated user
        val user = FirebaseAuth.getInstance().currentUser
        if (user == null) {
            val intent = Intent(applicationContext, SignInActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            home.setOnClickListener() {
                setContentView(R.layout.activity_main)
//                val i = Intent(applicationContext, MainActivity::class.java)
//                startActivity(i)
            }

            shop.setOnClickListener() {
                setContentView(R.layout.activity_shop)
            }
            aboutUs.setOnClickListener() {
                setContentView(R.layout.activity_about)
            }
            contact.setOnClickListener {
                setContentView(R.layout.activity_contact)
            }
        save.setOnClickListener() {
            // Create a new user with a first and last name
            val data = HashMap<String, Any>()
            data.put("first", "Another")
            data.put("last", "Person")
            data.put("born", "1989")

            // Add a new document with a generated ID
            db.collection("members")
                .add(data)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(this,
                        "DocumentSnapshot added with ID: " + documentReference.id,
                        Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
                }
        }

        logout.setOnClickListener {
            // log user out
            AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener {
                    // redirect to SignInActivity
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                } }





    }


}
