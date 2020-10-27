package br.com.nouva.randomchat.Activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import br.com.nouva.randomchat.R
import hani.momanii.supernova_emoji_library.Actions.EmojIconActions
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText

class ChatRoomActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var card: CardView
    private lateinit var chat: View
    private lateinit var emoji: ImageView
    private lateinit var more: LinearLayout
    private lateinit var area: EmojiconEditText
    private var actions: EmojIconActions? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_room)
        init()
        actions = EmojIconActions(this, chat, area, emoji)
        actions!!.ShowEmojIcon()
        more.setOnClickListener(this)
    }

    private fun init() {
        chat = findViewById(R.id.root_chat_room)
        card = findViewById(R.id.cv_emoji_icon)
        emoji = findViewById(R.id.iv_emoji)
        area = findViewById(R.id.edt_input_message_area)
        more = findViewById(R.id.button_more_information)
    }

    private fun openMenuBar() {
        val menu = PopupMenu(this@ChatRoomActivity, more)
        menu.menuInflater.inflate(R.menu.chat_more_info_menu, menu.menu)
        menu.show()
    }

    @SuppressLint("NonConstantResourceId")
    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_more_information -> openMenuBar()
        }
    }
}