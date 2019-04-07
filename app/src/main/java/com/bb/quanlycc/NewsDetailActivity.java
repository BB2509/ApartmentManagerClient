package com.bb.quanlycc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.bb.quanlycc.Model.news;

public class NewsDetailActivity extends AppCompatActivity {
    TextView Title,ngay,status;
    Toolbar toolbarthongbao;
    news a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        Title = findViewById(R.id.txtTitle);
        ngay = findViewById(R.id.txtngay);
        status = findViewById(R.id.txtstatus);
        toolbarthongbao = findViewById(R.id.toobarthongbao);
         a = new news();
        a = (news) getIntent().getSerializableExtra("Thongtin");
        Title.setText(a.getTitle());
        ngay.setText(a.getDate());
        status.setText(a.getStatus());
        ActionBar();

    }
    private void ActionBar() {
        setSupportActionBar(toolbarthongbao);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarthongbao.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
