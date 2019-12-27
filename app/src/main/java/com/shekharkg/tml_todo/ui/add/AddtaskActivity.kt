package com.shekharkg.tml_todo.ui.add

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.shekharkg.tml_todo.R
import com.shekharkg.tml_todo.extension.toDateTime
import com.shekharkg.tml_todo.room.entity.ToDoEntity
import com.shekharkg.tml_todo.ui.list.ToDoViewModel
import com.shekharkg.tml_todo.utils.InjectorUtils
import kotlinx.android.synthetic.main.activity_addtask.*
import java.util.*


class AddtaskActivity : AppCompatActivity() {

    private val mViewModel: ToDoViewModel by lazy {
        ViewModelProviders.of(
            this,
            InjectorUtils.provideToDoViewModelFactory(application)
        ).get(ToDoViewModel::class.java)
    }

    private var selectedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtask)


        setupActions()
    }

    private fun setupActions() {
        actionSave.setOnClickListener {
            var isAllFieldsAreFilled = true

            val title = inputTitle.text.toString()
            val description = inputDescription.text.toString()

            if (title.isEmpty()) isAllFieldsAreFilled = false
            if (description.isEmpty()) isAllFieldsAreFilled = false
            if (selectedTime > 0) isAllFieldsAreFilled = false


            if (isAllFieldsAreFilled) {
                val toDo =
                    ToDoEntity(title = title, description = description, timeStamp = selectedTime)
                mViewModel.addNewTodo(toDo)
                Toast.makeText(this@AddtaskActivity, "Task added successfully", Toast.LENGTH_SHORT)
                    .show()
                finish()
            }
        }


        actionPickDueDate.setOnClickListener {

            val newCalendar = Calendar.getInstance()
            val datePicker = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val newDate = Calendar.getInstance()
                    newDate.set(year, monthOfYear, dayOfMonth)
                    selectedTime = newDate.timeInMillis
                    actionPickDueDate.text = selectedTime.toDateTime()
                },
                newCalendar.get(Calendar.YEAR),
                newCalendar.get(Calendar.MONTH),
                newCalendar.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }
    }
}
