package br.com.nouva.randomchat.Activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import br.com.nouva.randomchat.R
import br.com.nouva.randomchat.ViewModel.ModelViewCreateAccount

class CreateNewAccountActivity : AppCompatActivity() {
    private lateinit var create: CardView
    private val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_account)
        init()
        val model = ModelViewCreateAccount(context)
        create.setOnClickListener(model)
    }

    private fun init() {
        create = findViewById(R.id.cv_button_create_account)
    }
}