package com.example.easygrocery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_main.*
import androidx.annotation.NonNull
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.DocumentReference
import com.google.android.gms.tasks.OnSuccessListener
//import javax.swing.UIManager.put
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shop.*


class shop : AppCompatActivity() {

    var db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)


//        saves.setOnClickListener() {
//            // get the user inputs
//            val name = item.text.toString().trim()
//
//            // validate name input
//            if (TextUtils.isEmpty(name)) {
//                Toast.makeText(this, "Item Name is Required", Toast.LENGTH_LONG).show()
//            } else {
//                // store selected Item
//                val catagory = catagory_list.selectedItem.toString()
//
//                // get new document with unique id
//                val tbl = db.collection("items")
//                val id = tbl.document().getId()
//
//                // create and populate new Item object
//                val item = Item(id, name, catagory)
//
//                // save to the db
//                tbl.document(id).set(item)
//
//                // clean up
//                //item.setText("")
//                catagory_list.setSelection(0)
//                Toast.makeText(this, "Item Added", Toast.LENGTH_LONG).show()
//            }
//
//
//        }
    }
}
