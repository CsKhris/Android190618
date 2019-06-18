package com.cs.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.widget.TabHost;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        //Tab을 생성하기 위하여 TabHost를 가져오기
        TabHost host = (TabHost)findViewById(R.id.tHost);
        host.setup();

        //하나의 Tab 추가
        TabHost.TabSpec spec = host.newTabSpec("tag1");

        spec.setIndicator(null,
                ResourcesCompat.getDrawable(
                        getResources(), R.drawable.tab_icon1,
                        null));
        spec.setContent(R.id.tab_content1);
        host.addTab(spec);

        spec =
                host.newTabSpec("tag2");

        spec.setIndicator(null,
                ResourcesCompat.getDrawable(
                        getResources(), R.drawable.tab_icon2,
                        null));
        spec.setContent(R.id.tab_content2);
        host.addTab(spec);

        spec =
                host.newTabSpec("tag3");

        spec.setIndicator(null,
                ResourcesCompat.getDrawable(
                        getResources(), R.drawable.tab_icon3,
                        null));
        spec.setContent(R.id.tab_content3);
        host.addTab(spec);
    }
}
