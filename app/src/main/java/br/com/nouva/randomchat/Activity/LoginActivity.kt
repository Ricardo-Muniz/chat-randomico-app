package br.com.nouva.randomchat.Activity

import android.content.Context
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.ViewPager
import br.com.nouva.randomchat.Controler.ControllerLoginACT
import br.com.nouva.randomchat.R
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class LoginActivity : AppCompatActivity() {

    private lateinit var pager: ViewPager
    private lateinit var dots: LinearLayout
    private lateinit var submit: LinearLayout
    private lateinit var indicator: WormDotsIndicator
    private lateinit var slide: CardView
    private val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        val controller = ControllerLoginACT(pager, dots,
                slide, submit, indicator, context)
        controller.slider(context)
    }

    private fun init() {
        pager = findViewById(R.id.view_pager_login)
        dots = findViewById(R.id.layout_login_dots)
        slide = findViewById(R.id.cv_button_login_slide)
        submit = findViewById(R.id.layout_button_entrar)
        indicator = findViewById(R.id.dots_indicator)
    }
}