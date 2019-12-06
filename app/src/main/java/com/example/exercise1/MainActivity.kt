package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnReset: Button = findViewById(R.id.buttonReset)
        btnReset.setOnClickListener { onReset() }

        val btnCalculate: Button = findViewById(R.id.buttonCalculate)
        btnCalculate.setOnClickListener { onCalculate() }
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
        val downPayment: EditText = findViewById(R.id.editTextDownPayment)
        val loanPeriod: EditText = findViewById(R.id.editTextLoanPeriod)
        val interestRate: EditText = findViewById(R.id.editTextInterestRate)

        val loan = carPrice.text.toString().toInt() - downPayment.text.toString().toInt()
        val interest = loan * (interestRate.text.toString().toDouble() / 100) * loanPeriod.text.toString().toInt()
        val monthlyPayment = (loan + interest) / loanPeriod.text.toString().toInt() / 12

        textLoan.text = loan.toString()
        textInterest.text = interest.toString()
        textMonthlyRepayment.text = monthlyPayment.toString()

    }


}
