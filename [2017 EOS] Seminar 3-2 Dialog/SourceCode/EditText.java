package com.example.tankm.test;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // savedInstanceState가 뭐냐? 저장된 데이터라고 보면 된다
        // 에를들어, 메모리 부족등의 문제로 앱이 종료되었다가 다시 복원될 때 savedInstanceState를 불러와서
        // 자동으로 복원해 준다.
        super.onCreate(savedInstanceState);
        // Super 는 부모를 지칭, 부모의 onCreate를 savedInstanceState를 이용해 사용한다고 생각.
        setContentView(R.layout.activity_main);
        // XML로 만든 레이아웃 (화면에 보이는거)를 보여줌
        Button button = (Button) findViewById(R.id.button);
        //레이아웃 내 선언된 각 뷰에 대한 인스턴스를 받기위한 findViewById사용. 쉽게말해 화면하고 기능하고 연결한다고 생각.
        button.setOnClickListener(new View.OnClickListener() {
            //함수이름에서 알 수 있다시피 버튼 이벤트를 감지하는 부분
            @Override
            public void onClick(View view) {
                // 버튼 이벤트 시 일어날 일을 적는 부분
                // 지금은 show 함수를 실행시키고 있다.
                show();
            }
        });
    }

    void show() {
        final EditText edittext = new EditText(this);
        //List에서 설명했었죠?
        //final이라 해서 edittext가 가지는 변수 설정이 불가능한게 아니라
        //edittext의 주소가 변경이 불가능해지기 때문에 재정의가 불가능 하다구요
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //빌더 객체 생성
        builder.setTitle("AlertDialog Title");
        //타이틀 설정
        builder.setMessage("AlertDialog Content");
        //메세지 설정
        builder.setView(edittext);
        //View설정
        builder.setPositiveButton("input",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), edittext.getText().toString(), Toast.LENGTH_LONG).show();
                        //edittext에 적었던걸 팝업으로 출력해요
                    }
                });
        builder.setNegativeButton("cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //취소하면 아무것도 안해요
                    }
                });
        //보여주기
        builder.show();
    }
}