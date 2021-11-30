package com.example.adondeirnuevoleon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

//INSTANCIAMOS FIREBASE AUTH PARA PODER UTILIZAR SUS SERVICIOS
var auth: FirebaseAuth = FirebaseAuth.getInstance()

class RegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val emailRegisterBtn : Button = findViewById<Button>(R.id.emailRegisterBtn)
        val facebookRegisterBtn: LinearLayout = findViewById<LinearLayout>(R.id.facebookRegisterBtn)
        val googleRegisterBtn : LinearLayout = findViewById<LinearLayout>(R.id.googleRegisterBtn)
        val emailText: EditText = findViewById<EditText>(R.id.emailEditText)
        val passText: EditText = findViewById<EditText>(R.id.passwordEditText)
        val confPassText: EditText = findViewById<EditText>(R.id.emailConfirmationEditText)
        //EMAIL REGISTER
        emailRegisterBtn.setOnClickListener(){

            var email = emailText.text.toString()
            var password = passText.text.toString()
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){ task ->
                if (task.isSuccessful){
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }

            }

        //FACEBOOK REGISTER
        facebookRegisterBtn.setOnClickListener(){
            Toast.makeText(this,"Registro con Facebook", Toast.LENGTH_LONG )
        }
        //GOOGLE REGISTER
        googleRegisterBtn.setOnClickListener(){
            Toast.makeText(this,"Registro con Google", Toast.LENGTH_LONG )
        }

    }
}


    }


