package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import org.mariuszgromada.math.mxparser.*


import com.example.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.setShowSoftInputOnFocus(false)
        binding.textView.setOnClickListener{
            onClick(binding.textView)
        }
    }
    fun updateText(strToAdd: String){
        var oldStr: String = binding.textView.getText().toString()
        var cursorPos:Int = binding.textView.getSelectionStart()
        var leftStr:String = oldStr.substring(0,cursorPos)
        var rightStr:String = oldStr.substring(cursorPos)
        if(getString(R.string.display).equals(binding.textView.getText().toString())){
            binding.textView.setText(strToAdd)
            binding.textView.setSelection(cursorPos + 1)
        }
        else {
            binding.textView.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr))
            binding.textView.setSelection(cursorPos + 1)
        }
    }
    fun zeroBTN(view:View){
        updateText("0")
    }
    fun oneBTN(view: View){
        updateText("1")
    }
    fun twoBTN(view: View){
        updateText("2")
    }
    fun threeBTN(view: View){
        updateText("3")
    }
    fun fourBTN(view: View){
        updateText("4")
    }
    fun fiveBTN(view: View){
        updateText("5")
    }
    fun sixBTN(view: View){
        updateText("6")
    }
    fun sevenBTN(view: View){
        updateText("7")
    }
    fun eightBTN(view: View){
        updateText("8")
    }
    fun nineBTN(view: View){
        updateText("9")
    }
    fun divideBTN(view: View){
        updateText("/")
    }
    fun multiplyBTN(view: View){
        updateText("*")
    }
    fun addBTN(view: View){
        updateText("+")
    }
    fun subBTN(view: View){
        updateText("-")
    }
    fun plusMinusBTN(view: View){
        updateText("-")
    }
    fun pointBTN(view: View){
        updateText(".")
    }
    fun clearentryBTN(view: View){
        var cursorPos: Int = binding.textView.getSelectionStart()
        var textLen: Int = binding.textView.getText().length

        if (cursorPos != 0 && textLen != 0){
            var selection: SpannableStringBuilder = SpannableStringBuilder(binding.textView.getText())
            selection.replace(cursorPos-1,cursorPos,"0")
            binding.textView.setText(selection)
            binding.textView.setSelection(cursorPos - 1)
        }
    }
    fun clearBTN(view: View){
        binding.textView.setText("")
    }
    fun backspaceBTN(view: View){
        var cursorPos: Int = binding.textView.getSelectionStart()
        var textLen: Int = binding.textView.getText().length

        if (cursorPos != 0 && textLen == 1){
            binding.textView.setText("0")
        }else if (cursorPos != 0 && textLen != 0){
            var selection: SpannableStringBuilder = SpannableStringBuilder(binding.textView.getText())
            selection.replace(cursorPos-1,cursorPos,"")
            binding.textView.setText(selection)
            binding.textView.setSelection(cursorPos - 1)
        }
    }
    fun resultsBTN(view: View){
        var userExp: String = binding.textView.getText().toString()
        var exp: Expression = Expression(userExp)
        var result = exp.calculate()
        binding.textView.setText(result.toString())
        binding.textView.setSelection(result.toString().length)
    }
    fun onClick(v: View){
        if(getString(R.string.display).equals(binding.textView.getText().toString())){
            binding.textView.setText("")
        }
    }
}