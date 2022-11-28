package com.example.practice17

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shared = this.getSharedPreferences("MAGA", MODE_PRIVATE)
        val theme = shared.getInt("my_theme", R.style.NightTheme)
        setTheme(theme)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{

        when(item.itemId){
            R.id.theme_menu_item -> {
                val shared = getSharedPreferences("MAGA", MODE_PRIVATE)
                val theme = shared.getInt("my_theme", R.style.NightTheme)
                if (theme==R.style.NightTheme){

                    shared.edit().clear().apply()
                    shared.edit().putInt("my_theme", R.style.LightTheme).apply()
                    item.setIcon(R.drawable.ic_baseline_light_mode_24)
                    item.setTitle("Сменить на темную")

                    recreate()

                }
                else{
                    shared.edit().clear().apply()
                    shared.edit().putInt("my_theme", R.style.NightTheme).apply()
                    item.setIcon(R.drawable.ic_baseline_mode_night_24)
                    item.setTitle("Сменить на светлую")

                    recreate()

                }
            }
            R.id.about_menu_item -> {
                val intent:Intent=Intent(this@MainActivity,AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}


