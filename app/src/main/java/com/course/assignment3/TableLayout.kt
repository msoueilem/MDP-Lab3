package com.course.assignment3

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.course.assignment3.databinding.ActivityTableLayoutBinding
import com.course.assignment3.databinding.ActivityTableLayoutBinding.inflate


class TableLayout : AppCompatActivity() {
    private lateinit var binding: ActivityTableLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_layout)
        binding = inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.newRow.setOnClickListener {
            if (validations()) {
                insertRow(
                    binding.androidVersion.text.toString(),
                    binding.androidCodeName.text.toString()
                )
            }
        }

    }

    private fun validations(): Boolean {

        if (binding.androidVersion.text.isEmpty()) {
            Toast.makeText(this, "Android code version is not provided", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.androidCodeName.text.isEmpty()) {
            Toast.makeText(this, "Android code name is not provided", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun insertRow(version: String, codeName: String) {

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
        binding.talbleLayoutData.addView(tableRow)

    }
}