package com.example.youhwangguk.example;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by YOUHWANGGUK on 2017-09-21.
 */

public class OtherActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        String sfn = "SharedF";
        EditText show = (EditText) findViewById(R.id.et_show);
        SharedPreferences sf = getSharedPreferences(sfn, MODE_PRIVATE);
        String str = sf.getString("name", "");
        show.setText(str);

        Button back = (Button)findViewById(R.id.bt_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherActivity.this, MainActivity.class);

                EditText show = (EditText)findViewById(R.id.et_show);
                String sfn = "SharedF";

                SharedPreferences sf = getSharedPreferences(sfn, MODE_PRIVATE);
                SharedPreferences.Editor edt = sf.edit();
                String str = show.getText().toString();
                edt.putString("name", str);
                edt.commit();

                startActivity(intent);
                finish();
            }
        });

        Intent intent = new Intent(this.getIntent());
    }
}
