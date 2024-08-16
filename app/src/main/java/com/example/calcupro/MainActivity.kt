package com.example.calcupro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat
import com.example.calcupro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonClear.setOnClickListener {
            binding.input.text = ""
            binding.output.text = ""
        }

        binding.buttonBracketLeft.setOnClickListener {
            binding.input.append("(")
        }
        binding.buttonBracketRight.setOnClickListener {
            binding.input.append(")")
        }
        binding.button0.setOnClickListener {
            binding.input.append("0")
        }
        binding.button1.setOnClickListener {
            binding.input.append("1")
        }
        binding.button2.setOnClickListener {
            binding.input.append("2")
        }
        binding.button3.setOnClickListener {
            binding.input.append("3")
        }
        binding.button4.setOnClickListener {
            binding.input.append("4")
        }
        binding.button5.setOnClickListener {
            binding.input.append("5")
        }
        binding.button6.setOnClickListener {
            binding.input.append("6")
        }
        binding.button7.setOnClickListener {
            binding.input.append("7")
        }
        binding.button8.setOnClickListener {
            binding.input.append("8")
        }
        binding.button9.setOnClickListener {
            binding.input.append("9")
        }
        binding.buttonDot.setOnClickListener {
            binding.input.append(".")
        }
        binding.buttonDivision.setOnClickListener {
            binding.input.append("÷")
        }
        binding.buttonMultiply.setOnClickListener {
            binding.input.append("×")
        }
        binding.buttonSubtraction.setOnClickListener {
            binding.input.append("-")
        }
        binding.buttonAddition.setOnClickListener {
            binding.input.append("+")
        }

        binding.buttonEquals.setOnClickListener {
            showResult()
        }
    }

    private fun getInputExpression(): String {
        var expression = binding.input.text.toString()
        expression = expression.replace("÷", "/")
        expression = expression.replace("×", "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                binding.output.text = "Error"
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                binding.output.text = DecimalFormat("0.######").format(result).toString()
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            binding.output.text = "Error"
            binding.output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}