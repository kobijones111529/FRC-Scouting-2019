package com.kobijones.scouting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.lifecycle.ViewModelProviders
import com.kobijones.scouting.viewmodel.MainActivityModel

class MainActivity : AppCompatActivity() {
    private val viewModel : MainActivityModel by lazy {
        ViewModelProviders.of(this).get(MainActivityModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.action_bar_toolbar))

        val spinner: Spinner = findViewById(R.id.match_type_spinner)
        ArrayAdapter.createFromResource(this, R.array.match_type_options, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        findViewById<EditText>(R.id.event_code).addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                viewModel.eventCode = s.toString()
            }

            override fun afterTextChanged(p0: Editable?) { }
        })
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) { }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                viewModel.matchType = parent?.selectedItem.toString()
            }
        }
        findViewById<EditText>(R.id.match_number).addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.matchNumber = s.toString().toIntOrNull()
            }

            override fun afterTextChanged(s: Editable?) { }
        })
        findViewById<EditText>(R.id.team_number).addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.teamNumber = s.toString().toIntOrNull()
            }

            override fun afterTextChanged(s: Editable?) { }
        })
    }
}
