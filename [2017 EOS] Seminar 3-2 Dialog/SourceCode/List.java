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
        //List 객체 생성
        //여기서 혼동이 올 수 있는데 보통 final은 변수의 값을 변경하지 못하니까 어떻게 add를 하냐? 라고 생각할 수 있어요.
        //여기서 상수 ListItems 는 ArrayList의 값을 가지고 있는게 아니라 ArrayList 객체의 주소를 참조하고 있어요.
        //따라서 주소의 변경이 불가능하게 되는 것이죠.
        //"ListItems = new ArrayList<String>();" 이라고 하면 컴파일 오류가 발생해요
        //주소가 변경 불가능하기 때문이죠
        ListItems.add("apple");
        ListItems.add("pear");
        ListItems.add("tangerine");
        ListItems.add("banana");
        final CharSequence[] items = ListItems.toArray(new String[ListItems.size()]);
        //List의 배열화
        //아래서 쓸 setItems의 인자가 배열을 요구해요!

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //빌더 생성
        builder.setTitle("AlertDialog Title");
        //타이틀 설정
        builder.setItems(items, new DialogInterface.OnClickListener() {
            //"setItems(CharSequence[] items, OnClickListener listener)"
            //아까 배열화 시켰던걸 사용하는걸 볼 수 있어요
            //다시한번 말하지만 잘 모르겠으면 컨트롤 클릭하는 습관을 들여둡시다.
            public void onClick(DialogInterface dialog, int pos) {
                String selectedText = items[pos].toString();
                Toast.makeText(MainActivity.this, selectedText, Toast.LENGTH_SHORT).show();
                //팝업 띄우기
            }
        });
        //보여주기
        builder.show();
    }
}