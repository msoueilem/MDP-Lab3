package com.course.assignment3

import android.app.ActionBar
import android.os.Bundle
import android.view.View.inflate
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.course.assignment3.databinding.ActivityMainBinding
import com.course.assignment3.databinding.ActivityMainBinding.inflate


class TableLayoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnAddRow.setOnClickListener {
            if (validateFields()) {
                addNewRow(
                    binding.edAndroidVersion.text.toString(),
                    binding.edAndroidCodeName.text.toString()
                )
            }
        }

    }

    private fun validateFields(): Boolean {

        if (binding.edAndroidVersion.text.isEmpty()) {
            Toast.makeText(this, "Enter android code version please", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.edAndroidCodeName.text.isEmpty()) {
            Toast.makeText(this, "Enter android code name please", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun addNewRow(version: String, codeName: String) {

        // Create a new table row.
        val tableRow = TableRow(applicationContext)

        // Set new table row layout parameters.
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        tableRow.layoutParams = layoutParams

        // add values into row by calling addView()
        val tvVersion = TextView(this, null, 0, R.style.tableCell)
        val tvCode = TextView(this, null, 0, R.style.tableCell)

        tableRow.addView(tvVersion, 0)
        tableRow.addView(tvCode, 1)

        //set margin
        val lp = TableRow.LayoutParams(
            TableRow.LayoutParams.WRAP_CONTENT,
            TableRow.LayoutParams.WRAP_CONTENT
        )
        lp.setMargins(5, 5, 5, 5)
        tvVersion.layoutParams = lp
        tvCode.layoutParams = lp

       //set values
        tvVersion.text = version
        tvCode.text = codeName


        // Finally add the created row row into layout
        binding.tblAndroidData.addView(tableRow)

    }
}