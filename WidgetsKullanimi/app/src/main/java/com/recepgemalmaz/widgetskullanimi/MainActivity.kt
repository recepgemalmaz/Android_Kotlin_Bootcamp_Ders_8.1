package com.recepgemalmaz.widgetskullanimi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.recepgemalmaz.widgetskullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var kontrol = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonMutlu.setOnClickListener {
           binding.imageView.setImageResource(R.drawable.mutlu_resim)
        }

        binding.buttonUzgun.setOnClickListener {
            binding.imageView.setImageResource(resources.getIdentifier("uzgun_resim", "drawable",packageName))
        }

        binding.buttonToggleGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->

            kontrol = isChecked
            if (kontrol){
                val secilenButton =findViewById<Button>(checkedId)
                val buttonYazi = secilenButton.text.toString()
                Log.e("Sonuc", buttonYazi)
            }
        }

        val ulkeler = ArrayList<String>()
        ulkeler.add("Türkiye")
        ulkeler.add("Almanya")
        ulkeler.add("İngiltere")
        ulkeler.add("Fransa")
        ulkeler.add("İtalya")
        ulkeler.add("İspanya")

        val arrayAdapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, ulkeler)

        binding.autoCompleteTextView.setAdapter(arrayAdapter)


        binding.buttonToast.setOnClickListener {

            Toast.makeText(this@MainActivity, "Merhaba", Toast.LENGTH_LONG).show()
        }
        binding.buttonSnackbar.setOnClickListener {

            Snackbar.make(it, "Silmek Istiyor musunuz?", Snackbar.LENGTH_SHORT)
                .setAction("Evet") {
                    Snackbar.make(it, "Silindi", Snackbar.LENGTH_SHORT).show()
                }
                .setBackgroundTint(Color.WHITE)
                .setTextColor(Color.BLUE)
                .setActionTextColor(Color.RED)
                    .show()

        }
        binding.buttonDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this@MainActivity)
                .setTitle("Baslik")
                .setMessage("Mesaj")
                .setPositiveButton("Tamam") { dialog, which ->
                    Toast.makeText(this@MainActivity, "Tamam Secildi", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Iptal") { dialog, which ->
                    Toast.makeText(this@MainActivity, "Iptal Secildi", Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        binding.buttonGoster.setOnClickListener {
            if (kontrol){
                val secilenButton =findViewById<Button>(binding.buttonToggleGroup.checkedButtonId)
                val buttonYazi = secilenButton.text.toString()
                Log.e("Sonuc son durum", buttonYazi)
            }

            Log.e("Sonuc Ulke", binding.autoCompleteTextView.text.toString())
        }

    }
}