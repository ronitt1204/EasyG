package com.example.easygrocery

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
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





        view.setOnClickListener(){
            setContentView(R.layout.activity_item)
        }

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
            // get the user inputs
            val name = item.text.toString().trim()

            // validate name input
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(this, "Item Name is Required", Toast.LENGTH_LONG).show()
            } else {
                // store selected Item
                val catagory = catagory_list.selectedItem.toString()

                // get new document with unique id
                val tbl = db.collection("items")
                val id = tbl.document().getId()

                // create and populate new Item object
                val item = Item(id, name, catagory, url = null)
                

                // save to the db
                tbl.document(id).set(item)

                // clean up
                //item.setText("")
                catagory_list.setSelection(0)
                Toast.makeText(this, "Item Added", Toast.LENGTH_LONG).show()
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
