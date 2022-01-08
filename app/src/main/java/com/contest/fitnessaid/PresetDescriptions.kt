package com.contest.fitnessaid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PresetDescriptions : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapterUnresponsive.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preset_descriptions)

        val intent = getIntent()
        val name = intent.getStringExtra("PresetName")

        val heading : TextView= findViewById(R.id.preset_name)
        heading.setText(name)

        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        editor.putString("PresetName", name)
        editor.commit()

        val  recyclerView=findViewById<RecyclerView>(R.id.unresponsive_recycler_view)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter=RecyclerAdapterUnresponsive(applicationContext)
        recyclerView.adapter=adapter
    }
}