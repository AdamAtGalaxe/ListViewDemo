package com.galaxe.listviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    lateinit var listv: ListView
    lateinit var color: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arr : Array<String> = resources.getStringArray(R.array.colors)

        listv =findViewById(R.id.myList)
        color = findViewById(R.id.output)

        var arrayadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arr)

        listv.adapter = arrayadapter

        //listv.onItemClickListener = AdapterView.OnItemClickListener(this, android.R.layout.)
        listv.setOnItemClickListener(this)
    }
    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        var newString = "Your selected color is "
        var selectedColor = p0?.getItemAtPosition(p2) as String
        newString += selectedColor
        color.text = newString
        when (selectedColor){
            "black" -> color.setTextColor( ResourcesCompat.getColor(getResources(), R.color.black, null))
            "red" -> color.setTextColor( ResourcesCompat.getColor(getResources(), R.color.red, null))
            "orange" -> color.setTextColor( ResourcesCompat.getColor(getResources(), R.color.orange, null))
            "blue" -> color.setTextColor( ResourcesCompat.getColor(getResources(), R.color.blue, null))
            "green" -> color.setTextColor( ResourcesCompat.getColor(getResources(), R.color.green, null))
        }
        //color.setTextColor( ResourcesCompat.getColor(getResources(), R.color.(p0?.getItemAtPosition(p2) as String), null)) // (p0?.getItemAtPosition(p2) as String))
        //var selecteditem =
        Toast.makeText(this, "Selected Item is ${p0?.getItemAtPosition(p2) as String}.", Toast.LENGTH_SHORT).show()
        //var itemselected = p0?.getItemAtPosition(p2)

    }

}