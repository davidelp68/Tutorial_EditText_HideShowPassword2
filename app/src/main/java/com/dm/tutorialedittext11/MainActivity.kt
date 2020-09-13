package com.dm.tutorialedittext11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod  //Importazione della Classe: HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod     //Importazione della Classe: PasswordTransformationMethod
import android.widget.ImageView                             //Importazione della Classe: ImageView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var showPass: ImageView? = null
    //impostazione iniziale di password non visibile
    private var isShowPass = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showPass = findViewById(R.id.ivShowHide)

        //con questo si imposta l'immagine cliccabile
        showPass!!.setOnClickListener {
            isShowPass = !isShowPass
            showPassword(isShowPass)
        }

        // con questa riga di codice si imposta l'EditText e l'immagine all'avvio dell'app
        showPassword(isShowPass)

    }

    private fun showPassword(isShow: Boolean) {
        if (isShow) {
            // mostra password
            editText.transformationMethod = HideReturnsTransformationMethod.getInstance()
            // questa riga serve per modificare l'immagine
            showPass!!.setImageResource(R.drawable.ic_visibility_off)
        } else {
            // nascondi password
            editText.transformationMethod = PasswordTransformationMethod.getInstance()
            // questa riga serve per modificare l'immagine
            showPass!!.setImageResource(R.drawable.ic_visibility_on)
        }
        //questa riga di codice serve per impostare il cursore alla fine della password
        editText.setSelection(editText.length())
    }

}
