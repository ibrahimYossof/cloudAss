package com.example.ass1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity2 : AppCompatActivity() {
    var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var list = findViewById<RecyclerView>(R.id.recyL)
        var arr = ArrayList<dataC>()
        list.layoutManager = LinearLayoutManager(this)
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    arr.add(dataC(document.data.get(key = "name") as String,
                      document.data.get(key = "number") as String, document.data.get(key = "address") as String))
                    list.adapter = adapter(this, arr)
                    Log.d("sss" , arr.toString())
                }
            }
    }
}