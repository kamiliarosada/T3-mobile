package com.example.t3_mobile

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val cbMembaca = findViewById<CheckBox>(R.id.cbMembaca)
        val cbCoding = findViewById<CheckBox>(R.id.cbCoding)
        val cbOlahraga = findViewById<CheckBox>(R.id.cbOlahraga)
        val btnTampil = findViewById<Button>(R.id.btnTampil)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnTampil.setOnClickListener {

            val nama = etNama.text.toString()

            if (nama.isEmpty()) {
                etNama.setBackgroundResource(R.drawable.edittext_3)
                etNama.error = "Nama tidak boleh kosong"
                etNama.requestFocus()
                Toast.makeText(this, "Nama tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedId = rgGender.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, "Pilih jenis kelamin!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            etNama.setBackgroundResource(R.drawable.edittext_bg)

            val gender = findViewById<RadioButton>(selectedId).text.toString()


            val hobiList = mutableListOf<String>()
            if (cbMembaca.isChecked) hobiList.add("Membaca")
            if (cbCoding.isChecked) hobiList.add("Coding")
            if (cbOlahraga.isChecked) hobiList.add("Olahraga")

            val hobi = if (hobiList.isNotEmpty()) {
                hobiList.joinToString(", ")
            } else {
                "Tidak ada"
            }

            val hasil = """
                Nama     : $nama
                Kelamin  : $gender
                Hobi     : $hobi
            """.trimIndent()

            tvHasil.text = hasil
        }
    }
}