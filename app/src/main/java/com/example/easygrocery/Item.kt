package com.example.easygrocery

class Item {
    var itemId: String? = null
    var itemName: String? = null
    var catagories: String? = null
    var url: String? = null



    // 1st overload w/all properties passed in
    constructor(itemId: String, itemName: String, catagories: String, url: String?) {
        this.itemId = itemId
        this.itemName = itemName
        this.catagories = catagories
        this.url = url
    }
}