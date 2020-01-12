package com.example.exercise3

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculateInsurance()
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            reset()
        }
    }

    private fun calculateInsurance() {
        val genderId: Int = radioGroupGender.checkedRadioButtonId
        val genderString = resources.getResourceEntryName(genderId)

        val age : String = spinnerAge.selectedItem.toString()
        val textPremium: TextView = findViewById(R.id.textViewPremium)
        var premium: Int

        findViewById<CheckBox>(R.id.checkBoxSmoker)

        if(age == "Less than 17"){
            premium = 60
        }
        else if(age == "17 to 25"){
            premium = 70
            if(genderString == "radioButtonMale"){
                premium+=50
                }
            if(checkBoxSmoker.isChecked){
                premium+=100
            }
        }
        else if(age == "26 to 30"){
            premium = 90
            if(genderString == "radioButtonMale"){
                premium+=100
            }
            if(checkBoxSmoker.isChecked){
                premium+=150
            }
        }
        else if(age == "31 to 40"){
            premium = 120
            if(genderString == "radioButtonMale"){
                premium+=150
            }
            if(checkBoxSmoker.isChecked){
                premium+=200
            }
        }
        else if(age == "41 to 55"){
            premium = 150
            if(genderString == "radioButtonMale"){
                premium+=200
            }
            if(checkBoxSmoker.isChecked){
                premium+=250
            }
        }
        else{
            premium = 150
            if(genderString == "radioButtonMale"){
                premium+=200
            }
            if(checkBoxSmoker.isChecked){
                premium+=300
            }
        }
        textPremium.text = "Insurance Premium: RM" + premium
    }

    private fun reset(){
        val textPremium: TextView = findViewById(R.id.textViewPremium)

        spinnerAge.setSelection(0)
        radioGroupGender.clearCheck()
        checkBoxSmoker.isChecked = false
        textPremium.text = "Insurance Premium:"
    }
}
