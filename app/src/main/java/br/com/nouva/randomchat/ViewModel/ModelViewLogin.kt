package br.com.nouva.randomchat.ViewModel

import android.content.Context
import android.content.Intent
import android.view.View
import br.com.nouva.randomchat.Activity.CreateNewAccountActivity
import br.com.nouva.randomchat.R

class ModelViewLogin(private val context: Context) : View.OnClickListener {
    override fun onClick(view: View) {
        if (view.id == R.id.layout_button_entrar) {
            val intent = Intent(view.context, CreateNewAccountActivity::class.java)
            view.context.startActivity(intent)
        }
    }
}