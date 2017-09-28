package com.example.youhwangguk.example;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button next = (Button)findViewById(R.id.bt_next);
        Button savetext = (Button)findViewById(R.id.bt_name);
        EditText et1 = (EditText)findViewById(R.id.et_name);
        String sfn = "SharedF";

        SharedPreferences sf = getSharedPreferences(sfn, MODE_PRIVATE);
        String str = sf.getString("name", "");
        et1.setText(str);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(intent);
                finish();
            }
        });

        savetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 = (EditText)findViewById(R.id.et_name);
                String sfn = "SharedF";

                SharedPreferences sf = getSharedPreferences(sfn, MODE_PRIVATE);
                SharedPreferences.Editor edt = sf.edit();
                String str = et1.getText().toString();
                edt.putString("name", str);
                edt.commit();
            }
        });


    }
    protected void onStop() {

        super.onStop();
    }
}
