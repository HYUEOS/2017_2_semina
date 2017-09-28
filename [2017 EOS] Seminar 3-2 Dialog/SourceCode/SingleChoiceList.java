package com.example.tankm.test;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

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
        final List<String> ListItems = new ArrayList<>();
        ListItems.add("apple");
        ListItems.add("pear");
        ListItems.add("tangerine");
        ListItems.add("banana");
        final CharSequence[] items = ListItems.toArray(new String[ListItems.size()]);

        //앞에서 다뤘던 부분이니 설명하지 않겠습니다.

        final List SelectedItems = new ArrayList();

        //새로운 리스트 객체 생성

        int defaultItem = 0;
        SelectedItems.add(defaultItem);
        //인덱스 0에 기본값 초기화 하는 부분

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //빌더 객체 생성
        builder.setTitle("AlertDialog Title");
        //타이틀 설정
        builder.setSingleChoiceItems(items, defaultItem,
                //항상 잘 모르겠으면 컨트롤 + 클릭!
                //귀찮으신 분들을 위해
                //"setSingleChoiceItems(CharSequence[] items, int checkedItem, OnClickListener listener)"
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SelectedItems.clear();
                        SelectedItems.add(which);

                    }
                });
        //Yes
        builder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String msg = "";
                        //비워져있지 않을때 실행
                        if (!SelectedItems.isEmpty()) {
                            int index = (int) SelectedItems.get(0);
                            //index설정
                            msg = ListItems.get(index);
                            //ListItems의 아까 찾은 index번째에 있는 스트링을 msg에 담기
                        }

                        Toast.makeText(getApplicationContext(),
                                "Items Selected.\n" + msg, Toast.LENGTH_LONG)
                                .show();
                        //팝업 띄우기!
                    }
                });
        //No
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //아무것도 안하기
                    }
                });
        //보여주기
        builder.show();
    }
}