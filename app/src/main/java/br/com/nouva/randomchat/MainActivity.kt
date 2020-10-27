package br.com.nouva.randomchat

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import br.com.nouva.randomchat.Activity.ChatRoomActivity
import br.com.nouva.randomchat.Activity.ProfileActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.bumptech.glide.request.transition.Transition
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var cvprofile: CircleImageView
    private lateinit var cvthumb: CircleImageView
    private lateinit var cvOpenProfile: CardView
    private lateinit var include: View

    private val context: Context = this
    private val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        loadImages()

        include.setOnClickListener(this)
        cvOpenProfile.setOnClickListener(this)
    }

    private fun init() {
        cvprofile = findViewById(R.id.cv_profile_user)
        cvthumb = findViewById(R.id.cv_profile_user_thumb)
        cvOpenProfile = findViewById(R.id.cv_open_profile_user)
        include = findViewById(R.id.include)
    }

    private fun loadImages() {
        Glide.with(context)
                .asBitmap()
                .load(getString(R.string.url_image_man_blue_black_power))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(BitmapTransitionOptions.withCrossFade(factory))
                .apply(RequestOptions()
                        .format(DecodeFormat.PREFER_ARGB_8888))
                .into(object : CustomTarget<Bitmap?>(100, 100) {
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap?>?) {
                        cvprofile.setImageBitmap(resource)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {}
                })
        Glide.with(context)
                .asBitmap()
                .load(getString(R.string.url_image_girl_red))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(BitmapTransitionOptions.withCrossFade(factory))
                .apply(RequestOptions()
                        .format(DecodeFormat.PREFER_ARGB_8888))
                .into(object : CustomTarget<Bitmap?>(50, 50) {
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap?>?) {
                        cvthumb.setImageBitmap(resource)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {}
                })
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.include -> {
                val intentChat = Intent(this@MainActivity, ChatRoomActivity::class.java)
                startActivity(intentChat)
            }
            R.id.cv_open_profile_user -> {
                val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(intent)
            }
        }
    }
}