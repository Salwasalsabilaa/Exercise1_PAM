package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class ActivityRegister extends AppCompatActivity {

    EditText edtNama, edtEmail, edtPassword, edtrepass;

    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtNama =findViewById(R.id.editNama);
        edtEmail =findViewById(R.id.editEmail);
        edtPassword =findViewById(R.id.editPassword);
        edtrepass =findViewById(R.id.editrepassword);
        reg =findViewById(R.id.btnreg);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //membuat kondisi untuk mengecek EditText wajib diisi
                if (edtNama.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtrepass.getText().toString().isEmpty())
                {
                    //Menampilkan pesan notifikasi jika seluruh EditText wajib diisi
                    Snackbar.make(view, "ISI SEMUA DATA", Snackbar.LENGTH_LONG).show();
                }
                else
                {

                    if (edtPassword.getText().toString().equals(edtrepass.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil",
                                Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Snackbar.make(view, "Password dan Repassword harus sama",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}