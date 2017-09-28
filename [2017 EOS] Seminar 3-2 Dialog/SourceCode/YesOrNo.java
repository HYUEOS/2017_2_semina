package com.example.tankm.test;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        Button button = (Button)findViewById(R.id.button);
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

    //show 함수 정의 부분
    void show()
    {
        //AlertDialog는 빌더 패턴으로 만들어져 있다. 빌더 패턴에 대해 더 공부하고 싶다면 http://jdm.kr/blog/217 링크 클릭
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //빌더 객체를 생성하고 있다.

        //아래는 정보 설정 부분.

        //제목
        builder.setTitle("AlertDialog Title");
        //내용
        builder.setMessage("AlertDialog Content");
        //Yes
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    //예 버튼 클릭시 실행할 내용을 정의중...
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"YES!",Toast.LENGTH_LONG).show();
                    }
                });
        //No
        builder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    // 아니오 버튼 클릭시 실행할 내용을 정의중...
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"NO!",Toast.LENGTH_LONG).show();
                        // 컨트롤을 누르고 들어가보면 makeText가 무엇으로 이루어져 있는지 알 수 있다.
                        // makeText(Context context, CharSequence text, int duration) 처럼 매개변수에 무엇이 사용되는지 알 수 있다.
                        // 그니까 함수 사용법 모른다고 좌절하지 마시구 컨트롤 클릭해서 이해하려고 노력해보세요!
                        // Toast란?
                        // 안드로이드에서 토스트는 사용자에게 메시지를 알려 주기 위한 조그마한 박스입니다.
                        // 그 화면 아래 가운데에 뜨는 조그마한 팝업생각하면 돼요!
                        // "지원하지 않는 파일 형식입니다" << 이런거 한번쯤 봤겠죠?
                        // getApplicationonContext는 이름그대로 context를 리턴하는건데, context도 뭔지 모를 수 있겠죠?
                        //Context는 크게 두 가지 역할을 수행하는 Abstract 클래스 입니다.
                        //첫째론 어플리케이션에 관하여 시스템이 관리하고 있는 정보에 접근하기
                        //둘째론 안드로이드 시스템 서비스에서 제공하는 API 를 호출 할 수 있는 기능을 수행할 수 있습니다
                        //저도 context에 대해 정확히는 잘 모르니 능력자분들께 질문합시다 질문 ㄱㄱㄱㄱ
                    }
                });

        //보통 핸드폰의 back 터치로 대화상자를 닫을 수 있게 만드는데
        // AlertDialog.Builder setCancelable (boolean cancelable) 매서드를 호출 하면 됩니다..
        // 사용법은 간단해요. ".setCancelable(false)" 호출문이나 "setCancelable(true)" 호출문을 추가하면 돼요.

        //보여주기
        builder.show();

    }
}