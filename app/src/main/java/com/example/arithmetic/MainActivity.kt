// import all modules and packages
package com.example.arithmetic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText

// Class MainActivity inherits from AppCompatActivity which is used for
// compatibility support for new features on older devices
class MainActivity : AppCompatActivity() {
    // Declare variable to store the selected operand from the Spinner (+ by default)
    var selectedOperation: String ="+"

    // entry point for the activity's lifecycle onCreate called everytime
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Connects this code with the XML
        setContentView(R.layout.activity_main)

        // Spinner values
        // Searches for the EditText by the ID and assigns them to local variables
        val num1 = findViewById<EditText>(R.id.firstNum)
        val num2 = findViewById<EditText>(R.id.secondNum)
        val spinner = findViewById<android.widget.Spinner>(R.id.spinner)

        // Populate the spinner with the string array from strings.xml
        val adapter = android.widget.ArrayAdapter.createFromResource(
            this,
            R.array.operations,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Set the selected item selected in the spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                selectedOperation = parent.getItemAtPosition(position).toString()
            }

            // when the spinner is closed
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        // onClick Listener to the Calculate button
        findViewById<android.widget.Button>(R.id.calculateButton).setOnClickListener {
            // Arithmetic logic
        }
    }
}