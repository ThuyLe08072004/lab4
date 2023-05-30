package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity2_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main21);
        EditText edtvatpham = findViewById(R.id.edtvatpham);
        Button btngui = findViewById(R.id.btngui);
        TextView txtgia = findViewById(R.id.txtgia);
        ActivityResultLauncher<Intent> getQuote = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if  (result.getResultCode()==1){
                            Intent intent = result.getData();
                            if (intent != null){
                                Bundle bundle = intent.getExtras();
                                String priceQuote = bundle.getString("priceQuote");
                                txtgia.setText(priceQuote);
                            }
                        }
                    }
                });
        btngui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2_1.this, MainActivity2_2.class);
                intent.putExtra("name", edtvatpham.getText().toString());
                getQuote.launch(intent);
            }
        });
    }

}