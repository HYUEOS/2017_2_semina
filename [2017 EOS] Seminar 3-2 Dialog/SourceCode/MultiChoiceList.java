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
        //앞에서 다뤘던 부분이니 스킵할게요

        final List SelectedItems = new ArrayList();
        //객체 생성

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //빌더 객체 생성
        builder.setTitle("AlertDialog Title");
        //제목 생성
        builder.setMultiChoiceItems(items, null,
                //모르시면 컨트롤 클릭 해보세요
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {
                        if (isChecked) {
                            //사용자가 체크한 경우 리스트에 추가
                            SelectedItems.add(which);
                        } else if (SelectedItems.contains(which)) {
                            //이미 리스트에 들어있던 아이템이면 제거
                            SelectedItems.remove(Integer.valueOf(which));
                        }
                    }
                });
        //Yes
        builder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String msg = "";
                        for (int i = 0; i < SelectedItems.size(); i++) {
                            int index = (int) SelectedItems.get(i);

                            msg = msg + "\n" + (i + 1) + " : " + ListItems.get(index);
                        }
                        // 번호와 선택한 아이템들의 이름을 출력시키기 위해 msg에 저장하는 부분
                        Toast.makeText(getApplicationContext(),
                                "Total " + SelectedItems.size() + " Items Selected.\n" + msg, Toast.LENGTH_LONG)
                                //팝업으로 츌력!
                                .show();
                    }
                });
        //No
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //암것도 안하기
                    }
                });
        //보여주기!
        builder.show();
    }
}
