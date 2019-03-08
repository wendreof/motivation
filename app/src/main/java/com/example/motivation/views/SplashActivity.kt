package com.example.motivation.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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

        buttonSave.setOnClickListener( this)
    }

    override fun onClick(view: View) {
        val id = view.id;
        if ( id == R.id.buttonSave){
            handleSave()

        }
    }

    private fun handleSave() {
        val name: String = editName.text.toString()
        mSecurity.storeString(MotivationConstants.KEY.PERSON_NAME, name)
    }
}
