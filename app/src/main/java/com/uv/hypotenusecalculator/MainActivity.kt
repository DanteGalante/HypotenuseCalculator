package com.uv.hypotenusecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.lang.Math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var etCatetoA: EditText
    private lateinit var etCatetoB: EditText
    private lateinit var etResultado: EditText
    private lateinit var btnLimpiar: Button
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCatetoA = findViewById(R.id.etCatetoA)
        etCatetoB = findViewById(R.id.etCatetoB)
        etResultado = findViewById(R.id.etResultado)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCalcular = findViewById(R.id.btnCalcular)

        btnLimpiar?.setOnClickListener {
            etCatetoB.setText("")
            etCatetoA.setText("")
            etResultado.setText("")
        }

        btnCalcular?.setOnClickListener{
            var catetoA_valor:Double = etCatetoA?.text.toString().toDouble();
            var catetoB_valor:Double = etCatetoB?.text.toString().toDouble();

            var catetoB = Math.pow(catetoB_valor,2.0)
            var catetoA = Math.pow(catetoA_valor,2.0)
            var resultadoxd = sqrt(catetoB + catetoA)

            etResultado.setText(resultadoxd.toString())
        }
    }
}