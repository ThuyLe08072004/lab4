package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity2_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        TextView txtvatpham = findViewById(R.id.txtvatpham);
        EditText edtgia = findViewById(R.id.edtgia);
        Button btnbaogia = findViewById(R.id.btnbaogia);
        Intent intent = getIntent();
        String price = intent.getStringExtra("name");
        txtvatpham.setText(price);
        btnbaogia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String priceQuote = edtgia.getText().toString();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("priceQuote", priceQuote);
                intent.putExtras(bundle);
                setResult(1,intent);
                finish();
            }
        });
    }
}
