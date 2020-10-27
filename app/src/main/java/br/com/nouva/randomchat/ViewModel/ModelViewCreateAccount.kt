package br.com.nouva.randomchat.ViewModel

import android.content.Context
import android.content.Intent
import android.view.View
import br.com.nouva.randomchat.MainActivity
import br.com.nouva.randomchat.R

class ModelViewCreateAccount(private var context: Context) : View.OnClickListener {
    override fun onClick(view: View) {
        if (view.id == R.id.cv_button_create_account) {
            val intent = Intent(view.context, MainActivity::class.java)
            view.context.startActivity(intent)
        }
    }
}