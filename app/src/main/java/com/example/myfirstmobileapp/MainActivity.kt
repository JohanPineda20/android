package com.example.myfirstmobileapp


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth



class MainActivity : AppCompatActivity() {
    private val TAG: String ="MainActivity"
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        val usuario = findViewById<TextInputEditText>(R.id.usuario)
        val clave = findViewById<TextInputEditText>(R.id.contrasena)
        val botonLogin = findViewById<Button>(R.id.botonLogin)

        botonLogin.setOnClickListener(){
            signIn(usuario.text.toString(),clave.text.toString())
        }

    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
           // reload();
        }
    }

    fun signIn(email: String, password: String){
       // irInicio()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    irInicio()
                    // updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }

    }

    fun irInicio(){
        val intent = Intent(this, InicioActivity::class.java)
        startActivity(intent)//nuevo activity creado despues de loguearse
    }



}