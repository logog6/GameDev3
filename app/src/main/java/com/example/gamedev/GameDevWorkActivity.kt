package com.example.gamedev

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_game_dev_work.*

public var users = arrayOf("TECHLAND\nJunior Unity Developer\nStawka: 3.5k - 5.0k B2B\nMiejsce: Wrocław\nKontakt: techland@gmail.com" ,"Senior Art Designer","Mid Level Designer", "Project Manager")
public var image = intArrayOf(R.drawable.studio1, R.drawable.studio2, R.drawable.studio3, R.drawable.studio4)

class GameDevWorkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_dev_work)
        //val arrayAdapter: ArrayAdapter<*>
        //arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,)
        var customadapter=CustomAdapter(this)
        mListView.adapter = customadapter
    }
}
class CustomAdapter(private val context: Activity): BaseAdapter() {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = context.layoutInflater
        var view1= inflater.inflate(R.layout.row_items_list,null)
        var textview = view1.findViewById<TextView>(R.id.textview)
        val imageview = view1.findViewById<ImageView>(R.id.img)

        textview.setText(users[p0])
        imageview.setImageResource(image[p0])
        return view1
    }

    override fun getItem(p0: Int): Any {
        return image[p0]
    }

    override fun getItemId(p0: Int): Long {
        return image[p0].toLong()
    }

    override fun getCount(): Int {
        return image.size
    }


}