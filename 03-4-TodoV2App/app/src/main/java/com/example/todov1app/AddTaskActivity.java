package com.example.todov1app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.todov1app.databinding.ActivityAddTaskBinding;

public class AddTaskActivity extends AppCompatActivity {

    ActivityAddTaskBinding binding;
    private Integer selectedPriority = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.priorityRadioGroup.setOnCheckedChangeListener(((radioGroup, checkedId) -> {
            if (checkedId == R.id.radioBt0)
                selectedPriority = 2;
            else if (checkedId == binding.radioBt1.getId())
                selectedPriority = 1;
            else if (checkedId == binding.radioBt2.getId())
                selectedPriority = 0;
        }));

        binding.addNewButton.setOnClickListener(view -> {
            String name = binding.taskNameEditText.getText().toString();
            String desc = binding.taskDescEditText.getText().toString();

            boolean highPriority = binding.radioBt0.isSelected();
            Task task = new Task(name, desc, selectedPriority);
            Intent i = new Intent();
            i.putExtra("taskAdded", task);
            setResult(RESULT_OK, i);
            AddTaskActivity.this.finish();
        });
    }
}