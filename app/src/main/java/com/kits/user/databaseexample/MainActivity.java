package com.kits.user.databaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etname = (EditText)findViewById(R.id.etName);
        final EditText etAddress = (EditText)findViewById(R.id.etAddress);

        final DbHelper dbHelper = new DbHelper(this);
        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Shop shop = new Shop(etname.getText().toString(),count,etAddress.getText().toString());
                dbHelper.addShop(shop);
                Toast.makeText(MainActivity.this,"inserted succesfully",Toast.LENGTH_LONG).show();

            }
        });

        Button btGetDb = (Button)findViewById(R.id.button2);
        btGetDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Shop shop= dbHelper.getValues(3);
                Toast.makeText(MainActivity.this,"Name::"+shop.getName() +":ADD::"+shop.getAddress(),Toast.LENGTH_LONG).show();
            }

            });


    }
}
