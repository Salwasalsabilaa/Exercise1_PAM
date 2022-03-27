package com.example.exercise1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class TodoPage extends AppCompatActivity {

    TextView hslusername, txPassword;
    EditText edtsk, edjns, edlm;
    FloatingActionButton fab;
    String task,jenis,waktu,nama,nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_page);
        hslusername = findViewById(R.id.txNameuser);

        edtsk=findViewById(R.id.mTask);
        edjns=findViewById(R.id.mLama);
        edlm=findViewById(R.id.mLama);

        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("a");
        txPassword.setText(username);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = edtsk.getText().toString();
                jenis = edjns.getText().toString();
                waktu = edlm.getText().toString();
                if (jenis.length()==0){
                    edtsk.setError("Jenis task");

                    Toast.makeText(getApplicationContext(),"masukan semua data",Toast.LENGTH_LONG).show();
                }
                else if (waktu.length()==0){
                    edtsk.setError("lama task");

                    Toast.makeText(getApplicationContext(),"masukan semua data",Toast.LENGTH_LONG).show();
                }
                else if (task.isEmpty()){
                    Toast.makeText(getApplicationContext(),"masukan semua data",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Berhasil",Toast.LENGTH_LONG).show();

                    Bundle bd = new Bundle();

                    bd.putString("x",task.trim());
                    bd.putString("y",jenis.trim());
                    bd.putString("z",waktu.trim());

                    Intent dt = new Intent(getApplicationContext(), Task_Todo.class);

                    dt.putExtras(bd);
                    startActivity(dt);


            }
        }
    });


}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.Submit)
        {
            Intent i = new Intent(getApplicationContext(), TodoPage.class);
            startActivity(i);
        }else if (item.getItemId() == R.id.LogOut)
        {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}