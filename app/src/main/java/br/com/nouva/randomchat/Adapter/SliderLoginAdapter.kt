package br.com.nouva.randomchat.Adapter

import android.content.Context
import androidx.viewpager.widget.PagerAdapter
import android.view.LayoutInflater
import android.widget.TextView
import android.view.ViewGroup
import br.com.nouva.randomchat.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestListener
import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.load.engine.GlideException
import android.widget.RelativeLayout
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.request.target.Target
import java.util.*

class SliderLoginAdapter(private val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var slide: ImageView
    lateinit var title: TextView
    lateinit var description: TextView

    var slideImages = arrayOf(
            "https://static.dribbble.com/users/8106/screenshots/6698008/untitled_artwork_2x.png",
            "https://static.dribbble.com/users/8106/screenshots/6689795/untitled_artwork_4_2x.png",
            "https://static.dribbble.com/users/8106/screenshots/6684408/untitled_artwork_2_2x.png"
    )
    var slideText = arrayOf(
            "Converse em modo anônimo, simplão total.",
            "Procure por novas pessoas, fácil e rápido, agora.",
            "Você pode tudo, menos deixar de se divertir aqui."
    )
    var slideDescription = arrayOf(
            "Offer people a seamless experience across the entire portfolio of Microsoft\\'s mobile apps. Whether it\\'s for a client.",
            "They should be easy to scan for relevant and actionable information. Elements, like text and images, should be placed.",
            "Each card is made up of content blocks. All of the blocks, as a whole, are related to a single subject or destination."
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = Objects.requireNonNull(layoutInflater).inflate(R.layout.layout_slide_login, container, false)
        slide = view.findViewById(R.id.iv_image_slide_login)
        title = view.findViewById(R.id.tv_slide_title)
        description = view.findViewById(R.id.tv_slide_description)
        Glide.with(context)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(RequestOptions()
                        .format(DecodeFormat.PREFER_ARGB_8888)
                        .override(Target.SIZE_ORIGINAL))
                .listener(object : RequestListener<Bitmap?> {
                    override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Bitmap?>, isFirstResource: Boolean): Boolean {
                        return false
                    }

                    override fun onResourceReady(resource: Bitmap?, model: Any, target: Target<Bitmap?>, dataSource: DataSource, isFirstResource: Boolean): Boolean {
                        slide.setImageBitmap(resource)
                        return false
                    }
                })
                .load(slideImages[position])
                .into(slide)
        title.text = slideText[position]
        description.text = (slideDescription[position])
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }

    override fun getCount(): Int {
        return slideText.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }
}