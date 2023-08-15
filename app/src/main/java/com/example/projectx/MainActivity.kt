package com.example.projectx

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.projectx.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import java.math.BigDecimal
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var num1 : Int = 0
    var num2 : Int = 0
    var result_text : Int = 0
    var extra_clicked : Boolean = false
    var op_clicked : Boolean = false
    var num_clicked : Boolean = false
    var point_clicked : Boolean = false
    var clear_clicked : Boolean = false
    var equal_clicked : Boolean = false


    lateinit var input_txt_view : TextView
    lateinit var resultTextView : TextView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        input_txt_view = binding.inputTextView
        resultTextView = binding.resultTextView
       binding.zero.setOnClickListener{
           view ->
           equal_clicked = false
           clear_clicked =  false
           op_clicked =  false
           num_clicked = true
           input_txt_view.text = input_txt_view.text.toString() + "0"
           evaluate()
       }
        binding.one.setOnClickListener{
                view ->
            equal_clicked = false
            clear_clicked =  false
            op_clicked =  false
            num_clicked = true
            input_txt_view.text = input_txt_view.text.toString() + "1"
            evaluate()
        }
        binding.two.setOnClickListener {
                view ->
            equal_clicked = false
            clear_clicked =  false
            op_clicked =  false
            num_clicked = true
            input_txt_view.text = input_txt_view.text.toString() + "2"
            evaluate()
        }
        binding.three.setOnClickListener {
                view ->
            equal_clicked = false
            clear_clicked =  false
            op_clicked =  false
            num_clicked = true
            input_txt_view.text = input_txt_view.text.toString() + "3"
            evaluate()
        }
        binding.four.setOnClickListener {
                view ->
            equal_clicked = false
            clear_clicked =  false
            op_clicked =  false
            num_clicked = true
            input_txt_view.text = input_txt_view.text.toString() + "4"
            evaluate()
        }
        binding.five.setOnClickListener {
                view ->
            equal_clicked = false
            clear_clicked =  false
            op_clicked =  false
            num_clicked = true
            input_txt_view.text = input_txt_view.text.toString() + "5"
            evaluate()
        }
        binding.six.setOnClickListener {
                view ->
            equal_clicked = false
            clear_clicked =  false
            op_clicked =  false
            num_clicked = true
            input_txt_view.text = input_txt_view.text.toString() + "6"
            evaluate()
        }
        binding.seven.setOnClickListener {
                view ->
            equal_clicked = false
            op_clicked =  false
            clear_clicked =  false
            num_clicked = true
            input_txt_view.text = input_txt_view.text.toString() + "7"
            evaluate()
        }
        binding.eight.setOnClickListener {
                view ->
            equal_clicked = false
            clear_clicked =  false
            op_clicked =  false
            num_clicked = true
            input_txt_view.text = input_txt_view.text.toString() + "8"
            evaluate()
        }
        binding.nine.setOnClickListener {
                view ->
            equal_clicked = false
            clear_clicked =  false
            num_clicked = true
            op_clicked =  false
            input_txt_view.text = input_txt_view.text.toString() + "9"
            evaluate()
        }
        binding.point.setOnClickListener {
                view ->
            if(!point_clicked){
                input_txt_view.text = input_txt_view.text.toString() + "."
                point_clicked = true
                equal_clicked = false
                clear_clicked =  false
            }

        }
        binding.add.setOnClickListener {
                view ->
            continue_result_to_expression()
            if(num_clicked){
                if(!op_clicked){
                    input_txt_view.text = input_txt_view.text.toString() + "+"
                }else{
                    input_txt_view.text = input_txt_view.text.toString().dropLast(1) + "+"
                }
                op_clicked = true
                num_clicked = false
                point_clicked = false
                equal_clicked = false
                clear_clicked =  false
            }
        }
        binding.substract.setOnClickListener {
                view ->
            continue_result_to_expression()
            if(num_clicked){
                if(!op_clicked){
                    input_txt_view.text = input_txt_view.text.toString() + "-"
                }else{
                    input_txt_view.text = input_txt_view.text.toString().dropLast(1) + "-"
                }
                op_clicked = true
                num_clicked = false
                point_clicked = false
                equal_clicked = false
                clear_clicked =  false
            }
        }
        binding.divide.setOnClickListener {
                view ->
            continue_result_to_expression()
            if(num_clicked){
                if(!op_clicked){
                    input_txt_view.text = input_txt_view.text.toString() + "/"
                }else{
                    input_txt_view.text = input_txt_view.text.toString().dropLast(1) + "/"
                }
                op_clicked = true
                point_clicked = false
                num_clicked = false
                equal_clicked = false
                clear_clicked =  false
            }
        }
        binding.multiply.setOnClickListener {
                view ->
            continue_result_to_expression()
            if(num_clicked){
                if(!op_clicked){
                    input_txt_view.text = input_txt_view.text.toString() + "*"
                }else{
                    input_txt_view.text = input_txt_view.text.toString().dropLast(1) + "*"
                }
                op_clicked = true
                point_clicked = false
                num_clicked = false
                equal_clicked = false
                clear_clicked =  false
            }
        }
        binding.percent.setOnClickListener {
                view ->
            continue_result_to_expression()
            if(num_clicked){
                if(!op_clicked){
                    input_txt_view.text = input_txt_view.text.toString() + "/100*"
                }else{
                    input_txt_view.text = input_txt_view.text.toString().dropLast(1) + "/100*"
                }
                op_clicked = true
                num_clicked = false
                point_clicked = false
                equal_clicked = false
                clear_clicked =  false
            }
        }
        binding.cut.setOnClickListener {
                view ->
            input_txt_view.text = input_txt_view.text.toString().dropLast(1)
            equal_clicked = false
            clear_clicked =  false
        }
        binding.ac.setOnClickListener {
            view ->
            input_txt_view.text = ""
            resultTextView.text = ""
            resultTextView.visibility = View.GONE
            clear_clicked = true
            equal_clicked = false
            clear_clicked =  false
        }
        binding.equal.setOnClickListener {
            view ->
            if(num_clicked){
                evaluate()
            }
            equal_clicked = true
            op_clicked = false
        }
//        binding.extras.setOnClickListener{
//                view ->
//            if(!extra_clicked){
//                binding.extraButtons.visibility = View.VISIBLE
//                binding.title.visibility = View.GONE
//                extra_clicked = true
//            }else{
//                binding.extraButtons.visibility = View.GONE
//                binding.title.visibility = View.VISIBLE
//                extra_clicked = false
//            }
//        }

    }

    private fun continue_result_to_expression(){
        if(equal_clicked && !clear_clicked){
            input_txt_view.text = resultTextView.text.toString()
        }
    }

    private fun evaluate() {
        resultTextView.visibility = View.VISIBLE
        val expression = ExpressionBuilder(input_txt_view.text.toString()).build()
        val res = expression.evaluate()
        binding.resultTextView.text = res.toString()
        if(resultTextView.text.toString().length > 15){
            resultTextView.textSize = 30f
        }else if(resultTextView.text.toString().length > 8 && resultTextView.text.toString().length <15){
            resultTextView.textSize = 35f
        } else if(resultTextView.text.toString().length<8){
            resultTextView.textSize = 40f
        }
    }

}
