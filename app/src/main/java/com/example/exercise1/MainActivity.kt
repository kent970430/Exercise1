package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonReset.setOnClickListener { onReset() }
        buttonCalculate.setOnClickListener { onCalculate() }
    }

    private fun onReset(){
        val carPrice: EditText = findViewById(R.id.editTextCarPrice)
        carPrice.text = null
        val downPayment: EditText = findViewById(R.id.editTextDownPayment)
        downPayment.text = null
        val loanPeriod: EditText = findViewById(R.id.editTextLoanPeriod)
        loanPeriod.text = null
        val interestRate: EditText = findViewById(R.id.editTextInterestRate)
        interestRate.text = null

        val loan: TextView = findViewById(R.id.textLoan)
        loan.text = null
        val interest: TextView = findViewById(R.id.textInterest)
        interest.text = null
        val monthlyRepayment: TextView = findViewById(R.id.textMonthlyRepayment)
        monthlyRepayment.text = null
    }

    private fun onCalculate(){
        val carPrice: EditText = findViewById(R.id.editTextCarPrice)
        val price = carPrice.text.toString().toInt()
        val downPayment: EditText = findViewById(R.id.editTextDownPayment)
        val dPayment = downPayment.text.toString().toInt()
        val loanPeriod: EditText = findViewById(R.id.editTextLoanPeriod)
        val lPeriod = loanPeriod.text.toString().toInt()
        val interestRate: EditText = findViewById(R.id.editTextInterestRate)
        val iRate = interestRate.text.toString().toDouble() / 100

        val loan = price- dPayment
        val interest = loan * iRate * lPeriod
        val monthlyPayment = (loan + interest) / lPeriod / 12

        textLoan.text = loan.toString()
        textInterest.text = interest.toString()
        textMonthlyRepayment.text = monthlyPayment.toString()

    }


}
