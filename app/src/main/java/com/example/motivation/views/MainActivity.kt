package com.example.motivation.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.R
import com.example.motivation.contants.MotivationConstants
import com.example.motivation.mock.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var mFilter: Int = MotivationConstants.PRHASE_FILTER.ALL
    private val mMock = Mock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners() //events

        handleFilter(R.id.imageAll) //initializing
    }

    override fun onClick(view: View) {
        val id = view.id
        val listId = listOf(R.id.imageAll, R.id.imageSun, R.id.imageHappy)
        if (id in listId) {
            handleFilter(id)
        } else if (id == R.id.buttonNewPhrase){
            refreshPrase()
        }
    }

    private fun handleFilter(id: Int) {

        imageAll.setImageResource(R.drawable.ic_all_unselected)
        imageSun.setImageResource(R.drawable.ic_sun_unselected)
        imageHappy.setImageResource(R.drawable.ic_happy_unselected)

        when (id) {
            R.id.imageAll -> {
                mFilter = MotivationConstants.PRHASE_FILTER.ALL
                imageAll.setImageResource(R.drawable.ic_all_selected)
            }
            R.id.imageSun -> {
                mFilter = MotivationConstants.PRHASE_FILTER.SUN
                imageSun.setImageResource(R.drawable.ic_sun_selected)
            }
            R.id.imageHappy -> {
                mFilter = MotivationConstants.PRHASE_FILTER.HAPPY
                imageHappy.setImageResource(R.drawable.ic_happy_selected)
            }
        }
    }

    private fun refreshPrase() {
        textPhrase.text = mMock.getPrhase(mFilter)
    }

    private fun setListeners() {
        imageAll.setOnClickListener(this)
        imageSun.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        buttonNewPhrase.setOnClickListener(this)
    }
}
