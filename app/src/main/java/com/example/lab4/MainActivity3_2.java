package com.example.lab4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3_2 extends AppCompatActivity {
    ActivityResultLauncher<Intent> getData = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent intent = result.getData();
                    int number = intent.getIntExtra("number", 0);

                    Toast.makeText(getApplicationContext(), number + "", Toast.LENGTH_SHORT).show();
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main31);
        EditText edtUsername = findViewById(R.id.edt_username);
        EditText edtNhappassword = findViewById(R.id.edt_nhappassword);
        EditText edtRetypepassword = findViewById(R.id.edt_retype_password);
        Button btnRegister = findViewById(R.id. btn_dangki);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sUserName = edtUsername.getText().toString().trim();
                String sPassword = edtNhappassword.getText().toString().trim();
                String sRetypePass = edtRetypepassword.getText().toString().trim();
                if (sUserName.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập Username!", Toast.LENGTH_SHORT).show();
                } else if (sPassword.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập Password !", Toast.LENGTH_SHORT).show();
                } else if (sRetypePass.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Password nhap lai khong duoc de trong!", Toast.LENGTH_SHORT).show();
                } else if (!sRetypePass.equals(sPassword)) {
                    Toast.makeText(RegisterActivity.this, "Password nhap lai chua dung!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity3_2.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("username", sUserName);
                    bundle.putString("password", sPassword);

                    intent.putExtras(bundle);

                    getData.launch(intent);

                    //startActivity(intent);
                }
            }
        });

    }
    }
}