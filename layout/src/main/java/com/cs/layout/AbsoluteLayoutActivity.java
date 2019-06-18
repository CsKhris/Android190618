package com.cs.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class AbsoluteLayoutActivity extends AppCompatActivity {
    //View 변수를 Instance 변수로 만드는 이유 중의 하나는
    //Event 처리를 할 때 Anonymous Class를 많이 사용하는데
    //Anonymous Class에서는 일반 지역변수를 사용할 수 없고,
    //Final 이나 Instance 변수만 사용할 수 있습니다.
    private TextView textView;
    private Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absolute_layout);

        //View를 생성하여 부착하거나, 만들어진 View를 찾아옵니다.
        textView = (TextView)findViewById(R.id.textView);
        btn = (Button)findViewById(R.id.btn);

        //Button의 Event 처리
        //Android에서는 View의 위치 변화를 Main Thread에서 동작시켜야 하기 때문에 Error 입니다.
        btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                //Margin에 변화를 주어 View를 이동하는 것 처럼 보이도록 하는 Code
                ViewGroup.MarginLayoutParams layoutParams =
                        new ViewGroup.MarginLayoutParams(textView.getLayoutParams());
                textView.setText(layoutParams.toString());

                layoutParams.setMargins(
                        50, 0, 0, 0);
                textView.setLayoutParams(
                        new ViewGroup.LayoutParams(layoutParams));

            }

        });

    }

}
