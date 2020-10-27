package br.com.nouva.randomchat.Controler

import android.content.Context
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import br.com.nouva.randomchat.Adapter.SliderLoginAdapter
import br.com.nouva.randomchat.R
import br.com.nouva.randomchat.ViewModel.ModelViewLogin
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class ControllerLoginACT(private val view_pager: ViewPager, private val layout_main: LinearLayout,
                         private val cv_button_login_slide: CardView, private val layout_button_entrar: LinearLayout,
                         private val dots_indicator: WormDotsIndicator, private val context: Context) {

    private lateinit var dotscount: Array<ImageView?>
    fun slider(context: Context?) {
        val slider = SliderLoginAdapter(context!!)
        view_pager.adapter = slider
        dots_indicator.setViewPager(view_pager)
        addDotsIndicator(0)
        val model = ModelViewLogin(context)
        layout_button_entrar.setOnClickListener(model)
        view_pager.addOnPageChangeListener(viewListener)
    }

    fun addDotsIndicator(position: Int) {
        dotscount = arrayOfNulls(3)
        for (i in dotscount.indices) {
            dotscount[i] = ImageView(context)
            val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
            params.setMargins(0, 0, 6, 0)
            dotscount[i]!!.layoutParams = params
            dotscount[i]!!.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.shape_counter_slide_unselected))
            layout_main.addView(dotscount[i])
        }
        if (dotscount.isNotEmpty() && position != 2) {
            dotscount[position]!!.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.shape_counter_slide_selected))
            TransitionManager.beginDelayedTransition(cv_button_login_slide, AutoTransition().setDuration(800))
            cv_button_login_slide.visibility = View.INVISIBLE
        } else {
            dotscount[position]!!.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.shape_counter_slide_selected))
            TransitionManager.beginDelayedTransition(cv_button_login_slide, AutoTransition().setDuration(800))
            layout_button_entrar.visibility = View.VISIBLE
            cv_button_login_slide.visibility = View.VISIBLE
        }
    }

    var viewListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
        override fun onPageSelected(position: Int) {
            addDotsIndicator(position)
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }
}