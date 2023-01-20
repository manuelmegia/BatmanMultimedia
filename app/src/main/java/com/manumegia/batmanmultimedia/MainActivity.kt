package com.manumegia.batmanmultimedia

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TableLayout
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fotoBatman = findViewById<ImageView>(R.id.imageView4)
        var boton = findViewById<Button>(R.id.button)
        var eT = findViewById<EditText>(R.id.editText)
        var tb = findViewById<TableLayout>(R.id.tb)
        fotoBatman.isVisible = false
        eT.isVisible = false
        boton.setOnClickListener {
            if (boton.text.toString() == "Comenzar"){
                eT.isVisible = true
                boton.text = "Finalizar"
            } else if (boton.text.toString() == "Finalizar"){
                eT.isVisible = false
                boton.text = "Comenzar"
            }
        }
        eT.setOnFocusChangeListener { _, b ->
            if (!b){
                eT.text.clear()
            }
        }
        eT.addTextChangedListener (object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                fotoBatman.isVisible = eT.text.toString().contains("Wayne")
                if(eT.text.toString().contains("joker")) {
                    tb.setBackgroundColor(Color.parseColor("#B313AE"))
                    eT.setTextColor((Color.parseColor("#3AF52D")))
                } else {
                    tb.setBackgroundColor(Color.parseColor("#ffffff"))
                    eT.setTextColor((Color.parseColor("#000000")))
                }
            }

        })
    }
}