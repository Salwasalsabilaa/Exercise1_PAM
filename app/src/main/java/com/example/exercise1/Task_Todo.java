package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Task_Todo extends AppCompatActivity {


    TextView txTask, txjenis, txLama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_todo);
        txTask = findViewById(R.id.mTask);
        txjenis = findViewById(R.id.mJenis);
        txLama = findViewById(R.id.mLama);
        Bundle bundle = getIntent().getExtras();
        String task = bundle.getString("x");
        String jenis = bundle.getString("y");
        String lama = bundle.getString("z");
        txTask.setText(task);
        txjenis.setText(jenis);
        txLama.setText(lama);
    }
}