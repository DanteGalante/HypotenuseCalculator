package com.uv.hypotenusecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Math.sqrt
import java.text.DecimalFormat

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
        etResultado.inputType = InputType.TYPE_NULL
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCalcular = findViewById(R.id.btnCalcular)

        btnLimpiar?.setOnClickListener {
            etCatetoB.setText("")
            etCatetoA.setText("")
            etResultado.setText("")
        }

        btnCalcular?.setOnClickListener{
            if (validateInputsLenght()) {
                var catetoA_valor:Double = etCatetoA?.text.toString().toDouble();
                var catetoB_valor:Double = etCatetoB?.text.toString().toDouble();

                var catetoB = Math.pow(catetoB_valor,2.0)
                var catetoA = Math.pow(catetoA_valor,2.0)
                var resultado = sqrt(catetoB + catetoA)

                var formatDecimal:DecimalFormat = DecimalFormat("#.00")

                etResultado.setText(formatDecimal.format(resultado).toString())
            } else {
                Toast.makeText(applicationContext,"Error: Introduce un valor para ambos catetos",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun validateInputsLenght(): Boolean {
        if (etCatetoA.length() == 0) {
            return false;
        }
        if (etCatetoB.length() == 0) {
            return false;
        }
        return true;
    }
}