package com.bb.quanlycc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.bb.quanlycc.Model.Account;


public class ThongTinActivity extends AppCompatActivity {
    Toolbar toolbarthongtin;
    TextView ten ,gioitinh,email,phong;
    Button editpassword,logout;
    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);
        Intent intent = getIntent();
        account = new Account();
        account = (Account) intent.getSerializableExtra("login");
        addControl();
        ActionBar();

    }


   private void ActionBar() {
        setSupportActionBar(toolbarthongtin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarthongtin.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void addControl() {
        email = (TextView) findViewById(R.id.txtemailKH);
        ten = (TextView) findViewById(R.id.txtNameKH);
        gioitinh= (TextView) findViewById(R.id.txtGioiTinh);
        phong = (TextView) findViewById(R.id.txtroom);
        toolbarthongtin = findViewById(R.id.toobarthongtin);
        /**Set value*/
        ten.setText(account.getEmail());
        email.setText(account.getUserName());
        gioitinh.setText(account.getGioitinh());
        phong.setText(account.getRoom());

    }
}
