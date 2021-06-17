package com.example.gamedev

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_game_dev_studio.*

class GameDevStudioActivity : AppCompatActivity() {
    var modalList= ArrayList<Modal>()
    val names= arrayOf(
        "Techland",
        "PeopleCanFly",
        "CD Project RED",
        "BlueBeer"
    )
    var images = intArrayOf(
        R.drawable.studio1,
        R.drawable.studio2,
        R.drawable.studio3,
        R.drawable.studio4
    )
    var description= arrayOf(
        "polskie przedsiębiorstwo zajmujące się produkcją, wydawaniem gier komputerowych. Firma posiada biura we Wrocławiu, Warszawie i Ostrowie Wielkopolskim",
        "polski niezależny producent gier komputerowych. Przedsiębiorstwo zostało założone w lutym 2002 roku przez Adriana Chmielarza, Andrzeja Poznańskiego i Michała Kosieradzkiego.",
        "polski producent gier komputerowych, założony w 2002 roku jako spółka zależna CD Projektu. Studio należało do holdingu CDP Investment, połączonego później z przedsiębiorstwem Optimus. Siedziba znajdowała się w Warszawie. W ramach późniejszych licznych przekształceń spółki-matki, CD Projekt Red stało się oddziałem prawnie będącym częścią CD Projekt SA.",
        "Polski niezależny producent gier komputerowych. Przedsiębiorstwo zostało założone w lutym 2002 roku przez Adriana Chmielerza.\n Stworzyli słynne Bulletstorm. "

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_dev_studio)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        for (i in names.indices){
            modalList.add(Modal(names[i],images[i],description[i]))
        }
        var customAdapter = CustomAdapter(modalList, this)
        gridView.adapter = customAdapter

        gridView.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this,GameDevStudioDescActivity::class.java)
            intent.putExtra("data",modalList[i])
            startActivity(intent)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    class CustomAdapter(
        var itemModel:ArrayList<Modal>,
        var context: Context
    ): BaseAdapter(){
        var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            var view = view
            if(view == null){
                view = layoutInflater.inflate(R.layout.row_items_studio,viewGroup,false)
            }
            var tvImageName = view?.findViewById<TextView>(R.id.imagename)
            var imageView = view?.findViewById<ImageView>(R.id.imagestudio)

            tvImageName?.text= itemModel[position].name
            itemModel[position].image?.let { imageView?.setImageResource(it) }


            return view!!
        }

        override fun getItem(p0: Int): Any {
            return itemModel[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return itemModel.size
        }

    }

}