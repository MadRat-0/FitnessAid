package com.contest.fitnessaid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class Screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_screen2)

        val btn = findViewById<Button>(R.id.buttonwelcome)
        val username = findViewById<EditText>(R.id.username)




        btn.setOnClickListener {
            val intent = Intent(this@Screen2, PresetsScreen::class.java)
            val userNameString = username.text.toString()
            if (userNameString.trim() != "") {
                intent.putExtra("UserName", userNameString)
                val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                val editor = sharedPreference.edit()

                val routineNames = mutableListOf<String>("Chest", "Back", "Biceps", "Triceps", "Leg", "Cardio")
                val arrSize = routineNames.size
                for( i in 0 until arrSize){
                    editor.putString("routineName${i}", routineNames[i])
                }

                //chestRoutines
                val chestRoutines = mutableListOf<Int>(13,  15,  23,  9,  20, 8,  6,  21)
                editor.putInt("Chest_routine_size", 8)
                for (i in 0..7){
                    editor.putInt("Chest_routine${i}", chestRoutines[i])
                    editor.putInt("Chest_routine_time${i}", 300)
                }
                //chestRoutines

                //legRoutines
                val legRoutines = mutableListOf<Int>(1, 19,  17,  18,  24,  5)
                editor.putInt("Leg_routine_size", 6)
                for (i in 0..5){
                    editor.putInt("Leg_routine${i}", legRoutines[i])
                    editor.putInt("Leg_routine_time${i}", 300)
                }
                //legRoutines

                //bicepsRoutines
                val bicepsRoutines = mutableListOf<Int>(2, 14, 25,  30,  11)
                editor.putInt("Biceps_routine_size", 5)
                for (i in 0..4){
                    editor.putInt("Biceps_routine${i}", bicepsRoutines[i])
                    editor.putInt("Biceps_routine_time${i}", 300)
                }
                //bicepsRoutines


                //backRoutines
                val backRoutines = mutableListOf<Int>(22, 4, 28, 16, 26)
                editor.putInt("Back_routine_size", 5)
                for (i in 0..4){
                    editor.putInt("Back_routine${i}", backRoutines[i])
                    editor.putInt("Back_routine_time${i}", 300)
                }
                //backRoutines

                //tricepsRoutines
                val tricepsRoutines = mutableListOf<Int>(29,  3, 10, 27)
                editor.putInt("Triceps_routine_size", 4)
                for (i in 0..3){
                    editor.putInt("Triceps_routine${i}", tricepsRoutines[i])
                    editor.putInt("Triceps_routine_time${i}", 300)
                }
                //tricepsRoutines

                //cardioRoutines
                val cardioRoutines = mutableListOf<Int>(31, 7, 12)
                editor.putInt("Cardio_routine_size", 3)
                for (i in 0..2){
                    editor.putInt("Cardio_routine${i}", cardioRoutines[i])
                    editor.putInt("Cardio_routine_time${i}", 300)
                }
                //cardioRoutines


                editor.putString("username", userNameString)
                editor.putString("hasLoggedIn", "YES")
                editor.commit()
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this@Screen2, "Enter your name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}