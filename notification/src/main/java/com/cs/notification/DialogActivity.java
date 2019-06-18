package com.cs.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        TextView txt = (TextView)findViewById(R.id.txt);
        for(int i=1 ; i<=10 ; i=i+1){
            try{
                Thread.sleep(1000);
                txt.setText(i + "");
            }catch(Exception e){}
        }


        Button basicdiaolog = (Button)findViewById(R.id.basicdialog);
        basicdiaolog.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                // 대화상자 생성
                Dialog dlg = new Dialog(DialogActivity.this);
                // 대화상자에 출력할 View 생성
                TextView txt = new TextView(DialogActivity.this);
                txt.setText("대화상자에 출력할 View를 직접 생성");
                // 대화상자에 출력할 View를 설정
                dlg.setContentView(txt);
                // 대화상자의 Title 설정
                dlg.setTitle("Hand Made");
                // 대화상자 출력
                dlg.show();
            }
        });

        Button alert = (Button)findViewById(R.id.alert);
        alert.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                //Method의 수행 결과를 가지고 다음 Method를 바로 호출
                new AlertDialog.Builder(
                        DialogActivity.this)
                .setTitle("Alert Box")
                .setMessage("대화상자에 출력하는 Message")
                .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("OK", null)
                        .setNegativeButton("Cancel", null)
                .show();

                //Activity를 닫는 Method 호출
                //finish();

                Toast.makeText(DialogActivity.this, "Toast", Toast.LENGTH_LONG).show();

            }
        });
    }
}
