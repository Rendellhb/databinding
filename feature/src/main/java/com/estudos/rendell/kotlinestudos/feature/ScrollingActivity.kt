package com.estudos.rendell.kotlinestudos.feature

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.estudos.rendell.kotlinestudos.feature.databinding.ActivityScrollingBinding

class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityScrollingBinding>(this, R.layout.activity_scrolling)
        val description = Description(getString(R.string.large_text))
        setSupportActionBar(binding.toolbar)
        binding.setVariable(BR.description, description)
        binding.executePendingBindings()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onClickFab(view: View) {
        Snackbar.make(view, "Testing method binding", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
    }
}
