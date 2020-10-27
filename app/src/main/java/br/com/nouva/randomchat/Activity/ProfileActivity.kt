package br.com.nouva.randomchat.Activity

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import br.com.nouva.randomchat.R

class ProfileActivity : AppCompatActivity() {

    private lateinit var genre: Spinner
    private lateinit var preference: Spinner
    private val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()
        generateSpinner()
    }

    private fun init() {
        genre = findViewById(R.id.spinner_genre)
        preference = findViewById(R.id.spinner_genre_preference)
    }

    private fun generateSpinner() {
        val adapter = ArrayAdapter.createFromResource(this@ProfileActivity, R.array.genero,
                android.R.layout.simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genre.adapter = adapter
        genre.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                val genre = adapterView.getItemAtPosition(i).toString()
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
        val adapterPreference = ArrayAdapter.createFromResource(this, R.array.genero_preference,
                android.R.layout.simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        preference.adapter = adapterPreference
        preference.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                val genre = adapterView.getItemAtPosition(i).toString()
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
    }
}