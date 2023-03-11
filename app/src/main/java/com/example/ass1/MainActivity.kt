package com.example.ass1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var name = findViewById<EditText>(R.id.name).text.toString()
        var number = findViewById<EditText>(R.id.number).text.toString()
        var address = findViewById<EditText>(R.id.address).text.toString()
        var add = findViewById<Button>(R.id.btnAdd)
        var list = findViewById<Button>(R.id.btnShow)
        add.setOnClickListener {
            val user = hashMapOf(
                "name" to name,
                "number" to number,
                "address" to address
            )

            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(this,"Succeded",Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this,"Faild",Toast.LENGTH_LONG).show()
                }

        }
        list.setOnClickListener {
            var intent = Intent(this , MainActivity2 :: class.java)
            startActivity(intent)
        }

    }
}