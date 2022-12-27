package ru.myitschool.peoplelistk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var surnames : Array<String>
    lateinit var names : Array<String>
    val people = mutableListOf<String>()
    lateinit var lvPeople : ListView
    lateinit var adapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lvPeople = findViewById<ListView>(R.id.people)
        // TODO: сгенерировать список персон из случайных сочетаний имён и фамилий
        // TODO: создайте два string-array в ресурсах и получите список их случайных комбинаций
        surnames = resources.getStringArray(R.array.surname)
        names = resources.getStringArray(R.array.name)
        adapter = ArrayAdapter<String>(this, R.layout.item)
        adapter.notifyDataSetChanged()
        lvPeople.adapter = adapter // задаём адаптер (посредник) для отображения данных на списка
        findViewById<Button>(R.id.main_btn).setOnClickListener { onAddPersonClick() }
    }

    fun onAddPersonClick() {
        var name = findViewById<EditText>(R.id.new_name).text
        var surname = surnames[Random.nextInt(surnames.size)]
        var new_name = names[Random.nextInt(names.size)]
        if (name.toString() != ""){
            adapter.add(name.toString() + " " + surname)
        }
        else{
            adapter.add(new_name + " " + surname)
        }

        adapter.notifyDataSetChanged()

    }
}