package com.example.adondeirnuevoleon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.auth.FirebaseAuth

val login:FirebaseAuth = FirebaseAuth.getInstance()
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_ADondeIrNuevoLeon)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val registerBtn = findViewById<Button>(R.id.registerBtn)
        val emailText: EditText = findViewById<EditText>(R.id.emailTextEdit)
        val passwordText: EditText = findViewById<EditText>(R.id.passwordEditText)
        loginBtn.setOnClickListener(){
            login.signInWithEmailAndPassword(emailText.text.toString(),
            passwordText.text.toString()).addOnCompleteListener(this){task ->
                if (task.isSuccessful){
                    val loginIntent = Intent(this,HomeActivity::class.java)
                    startActivity(loginIntent)
                }
                else{
                    showAlert()
                }
            }
        }

        registerBtn.setOnClickListener(){
            val register = Intent(this, RegisterActivity::class.java)
            startActivity(register)
          /*  val db:FirebaseFirestore = FirebaseFirestore.getInstance()
            val city = hashMapOf(
                "name" to "Los Angeles",
                "state" to "CA",
                "country" to "USA"
            )
            db.collection("cities").document("LA")
                .set(city)*/

        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Oops")
        builder.setMessage("Algo salió mal, verifica tus datos")
        builder.setPositiveButton("Ok", null)
        val dialog:AlertDialog = builder.create()
        dialog.show()
    }
}