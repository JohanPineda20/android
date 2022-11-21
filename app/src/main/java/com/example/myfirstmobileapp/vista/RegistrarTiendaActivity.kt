package com.example.myfirstmobileapp.vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myfirstmobileapp.R
import com.example.myfirstmobileapp.modelo.Tienda
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegistrarTiendaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_tienda)
        val nombre: TextInputEditText = findViewById(R.id.nombre_tienda)
        val descripcion: TextInputEditText = findViewById(R.id.descripcion_tienda)
        val telefono: TextInputEditText = findViewById(R.id.telefono_tienda)
        val guardar: Button = findViewById(R.id.guardar_tienda)

        guardar.setOnClickListener(){
            guardarTienda(nombre.text.toString(),descripcion.text.toString(), telefono.text.toString())
        }
    }

    private fun guardarTienda(nombre: String, descripcion: String, telefono: String) {
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val myRef: DatabaseReference = database.reference
        val tienda = Tienda(myRef.push().key.toString(), nombre, descripcion, "", "", telefono, "")
        myRef.child("tiendas").child(tienda.id).setValue(tienda)
        finish()
    }
}