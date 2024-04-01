package com.igor.luiz.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.igor.luiz.calculadora.databinding.ActivityMainBinding


class  MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private var n1: String? = null
    private var n2: String? = null
    private var conta: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        binding.textView0.setOnClickListener { numerosEscolhidos("0") }
        binding.textView1.setOnClickListener { numerosEscolhidos("1") }
        binding.textView2.setOnClickListener { numerosEscolhidos("2") }
        binding.textView3.setOnClickListener { numerosEscolhidos("3") }
        binding.textView4.setOnClickListener { numerosEscolhidos("4") }
        binding.textView5.setOnClickListener { numerosEscolhidos("5") }
        binding.textView6.setOnClickListener { numerosEscolhidos("6") }
        binding.textView7.setOnClickListener { numerosEscolhidos("7") }
        binding.textView8.setOnClickListener { numerosEscolhidos("8") }
        binding.textView9.setOnClickListener { numerosEscolhidos("9") }

        binding.buttonSoma.setOnClickListener { operacao("+") }
        binding.buttonSub.setOnClickListener { operacao("-") }
        binding.buttonMulti.setOnClickListener { operacao("*") }
        binding.buttonDiv.setOnClickListener { operacao("/") }
        binding.buttonPorcentagem.setOnClickListener { operacao("%") }
        binding.buttonPorcentagem.setOnClickListener { operacao("-/+") }
        binding.buttonIgual.setOnClickListener { binding.textViewAppChoice.text = calculo() }
        binding.buttonApagar.setOnClickListener {
            limpar()
        }
    }

    private fun numerosEscolhidos(value: String) {
        if (n1 == null) {
            n1 = value
        } else if (conta == null) {
            n1 += value
        } else if (n2 == null) {
            n2 = value
        } else {
            n2 += value
        }

        binding.textViewAppChoice.text = "${n1 ?: ""}${conta ?: ""}${n2 ?: ""}"
    }

    private fun operacao(c: String) {
        conta = c
        binding.textViewAppChoice.text = "${n1 ?: ""}$c"
    }

    private fun calculo(): String? {
        if (n1 != null && n2 != null && conta != null) {
            val num1 = n1!!.toDouble()
            val num2 = n2!!.toDouble()

            return when (conta) {
                "+" -> (num1 + num2).toString()
                "-" -> (num1 - num2).toString()
                "*" -> (num1 * num2).toString()
                "/" -> (num1 / num2).toString()
                "%" -> (num1 * (num2 / 100)).toString()
                "-/+" -> ("")

                else -> null
            }
        }
        return null
    }

    private fun limpar() {
        n1 = null
        n2 = null
        conta = null
        binding.textViewAppChoice.text = ""
    }

}


