package com.example.xmlexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.xmlexample.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCalc.setOnClickListener { calculateVat() }
    }

    private fun calculateVat() {
        //TODO: make the button calculate the VAT

        val stringInTextField = binding.price.text.toString()
        val cost = stringInTextField.toDouble()

        val vatPercentage = when (binding.rgRadio.checkedRadioButtonId) {
                R.id.rdTen -> 0.10
                R.id.rdFifteen -> 0.15
                else -> 0.20
            }
        var vat = vatPercentage * cost

        val roundUp = binding.swRound.isChecked

        if(roundUp){
            vat = kotlin.math.ceil(vat)
        }
        val formattedVat = NumberFormat.getCurrencyInstance().format(vat)
        binding.total.text = getString(R.string.total_price, formattedVat)

    }
}