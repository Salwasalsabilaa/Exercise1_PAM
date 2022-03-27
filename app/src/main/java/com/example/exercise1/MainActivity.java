package com.example.exercise1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    TextView btnRegiss;
    EditText ednama, edpassword;
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnLogin=findViewById(R.id.btSignin);
        ednama=findViewById(R.id.edNama);
        edpassword=findViewById(R.id.edPassword);
        btnRegiss=findViewById(R.id.bRegiss);

        btnRegiss.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View view){
            Intent it = new Intent(getApplicationContext(), ActivityRegister.class);
            startActivity(it);
        }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nama = ednama.getText().toString();
                password = edpassword.getText().toString();

                String name = "salwa";
                String pass = "123";

                if (nama.isEmpty() && password.isEmpty()){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan  password wajib diisi!",
                            Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    if (nama.equals(name) && password.equals(pass)){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Berhasil",
                                Toast.LENGTH_LONG);

                        t.show();
                        Bundle b = new Bundle();
                        b.putString("a", nama.trim());
                        Intent i = new Intent(getApplicationContext(), TodoPage.class);
                        i.putExtras(b);
                        startActivity(i);
                    }
                    else{
                        Toast t = Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_LONG);
                        t.show();
                    }
                }

            }
        });
    }

}
