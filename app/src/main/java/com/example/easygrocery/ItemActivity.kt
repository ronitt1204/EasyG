package com.example.easygrocery

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {


    // connect to firestore
    var db = FirebaseFirestore.getInstance()

    // classes to store and pass query data
    private var adapter: ItemAdapter? = null

    // Kotlin equivalent of Java ArrayList class
    private var itemList = mutableListOf<Item>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        // recycler will have linear layout
        recyclerViewItems.setLayoutManager(LinearLayoutManager(this))

        // query
        val query = db.collection("items").orderBy("itemName", Query.Direction.ASCENDING)

        // pass the query results to the recycler adapter for display
        val options =
            FirestoreRecyclerOptions.Builder<Item>().setQuery(query, Item::class.java).build()
        adapter = ItemAdapter(options)

        // bind the adapter to the recyclerview (adapter means the datasource)
        recyclerViewItems.adapter = adapter

    }
        // start listening for changes if the the activity starts / restarts
        override fun onStart() {
            super.onStart()
            adapter!!.startListening()
        }

        // stop listening for data changes if the activity gets stopped
        override fun onStop() {
            super.onStop()
            adapter!!.stopListening()
        }

        // inner classes needed to read and bind the data
        private inner class ItemViewHolder internal constructor(private val view: View) :
            RecyclerView.ViewHolder(view) {

//            internal fun displayItem(itemName: String, catagories: String) {
//                // populate the corresponding textViews in the layout template inflated when adapter created below
//                val textViewItem = view.findViewById<TextView>(R.id.item)
//                val textViewCatagory = view.findViewById<TextView>(R.id.textViewCatagory)
//
//                textViewItem.text = itemName
//                textViewCatagory.text = catagories
//            }
        }


        private inner class ItemAdapter internal constructor(options: FirestoreRecyclerOptions<Item>) :
            FirestoreRecyclerAdapter<Item,
                    ItemViewHolder>(options) {

            override fun onBindViewHolder(p0: ItemViewHolder, p1: Int, p2: Item) {
                // pass current Item values to the display function above
                p0.itemView.findViewById<TextView>(R.id.textViewItem).text = p2.itemName
                p0.itemView.findViewById<TextView>(R.id.textViewCatagory).text = p2.catagories

                p0.itemView.setOnClickListener {
                    val url = p2.url.toString()
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
                // when creating, instantiate the item_artist.xml template (only happens once)
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_catagories, parent, false)
                return ItemViewHolder(view)
            }



    }
}
