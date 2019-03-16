package com.example.motivation.views

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.contants.MotivationConstants
import com.example.motivation.utils.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurityPreferences = SecurityPreferences( this )

        buttonSave.setOnClickListener(this)
        verifyUserName()
    }

    override fun onClick(view: View?) {
        val id: Int? = view?.id
        if (id == R.id.buttonSave) {
            handleSave()
        }
    }

    private fun verifyUserName() {
        val name = mSecurityPreferences.getStoredString(MotivationConstants.KEY.PERSON_NAME)
        if (name != "") {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun handleSave() {

        // Obtém o nome
        val name: String = editName.text.toString()

        if (name == "") {
            Toast.makeText(this, "Informe seu nome.", Toast.LENGTH_LONG).show()
        } else {

            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))

            finish()

        }
    }
}