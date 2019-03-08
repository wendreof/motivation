package com.example.motivation.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View

import com.example.motivation.R
import com.example.motivation.contants.MotivationConstants
import com.example.motivation.utils.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurity: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurity = SecurityPreferences(this)

        buttonSave.setOnClickListener(this)

        verifyUserName()
    }

    private fun verifyUserName() {
        editName.setText(mSecurity.getStoredString(MotivationConstants.KEY.PERSON_NAME))
    }

    override fun onClick(view: View) {
        val id = view.id;
        if (id == R.id.buttonSave) {
            handleSave()

        }
    }

    private fun handleSave() {
        val name: String = editName.text.toString()

        if (name == "") {
            Snackbar.make(splashActivity, getString(R.string.informe_nome), Snackbar.LENGTH_LONG).show()
        } else {
            mSecurity.storeString(MotivationConstants.KEY.PERSON_NAME, name)

            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            //Impede a volta para essa activity!
            //finish()
        }

    }
}
