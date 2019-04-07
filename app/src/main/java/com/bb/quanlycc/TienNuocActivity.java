package com.bb.quanlycc;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bb.quanlycc.Model.Account;
import com.bb.quanlycc.Model.tiennuoc;
import com.bb.quanlycc.Adapter.tiennuocAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TienNuocActivity extends AppCompatActivity implements View.OnClickListener {
    ListView listtiennuoc;
    TextView ngay, sonuocthangtruoc,sonuocthangsau,thanhtien,tinhtrang;
    Toolbar toolbartiennuoc;
    Button btnthanhtoan;
    String url ="http://10.0.3.2/server/gettiennuoc.php";
    String URL_Thanhtoan ="http://10.0.3.2/server/thanhtoannuoc.php";
    public static final String KEY_ID = "idusers";
    ArrayList<tiennuoc> mangtiennuoc;
    tiennuocAdapter tiennuocAdapter;
    private Account account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tien_nuoc);
        Intent intent = getIntent();
        account = new Account();
        account = (Account) intent.getSerializableExtra("login");
        Anhxa();
        gettiennuoc(account.getId());
        Gettiennuocmoinhat(account.getId());
        ActionBarTienNuoc();
        event();
    }
    public void gettiennuoc(final int id) {


        StringRequest requestLogin = new StringRequest(Request.Method.POST, url ,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        if(response != null){
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                mangtiennuoc.clear();
                                for(int i =0; i< jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    tiennuoc news = new tiennuoc();
                                    news.setID( jsonObject.getInt("id"));
                                    news.setTongtien(jsonObject.getInt("thanhtien"));
                                    news.setTiennuocthangtruoc( jsonObject.getInt("sothangtruoc"));
                                    news.setTiennuocthangsau( jsonObject.getInt("sothangsau"));
                                    news.setStatus(jsonObject.getString("tinhtrang"));
                                    news.setNgay( jsonObject.getString("ngay"));
                                    mangtiennuoc.add(news);
                                    tiennuocAdapter.notifyDataSetChanged();
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            /**
             * set paramater
             * */
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put(KEY_ID, String.valueOf(id));
                return params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(requestLogin);

    }

    public void Gettiennuocmoinhat(final int id) {


        StringRequest requestLogin = new StringRequest(Request.Method.POST, url ,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        if(response != null){
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                mangtiennuoc.clear();
                                for(int i =0; i< 1; i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    tiennuoc news = new tiennuoc();
                                    news.setID( jsonObject.getInt("id"));
                                    news.setTongtien(jsonObject.getInt("thanhtien"));
                                    news.setTiennuocthangtruoc( jsonObject.getInt("sothangtruoc"));
                                    news.setTiennuocthangsau( jsonObject.getInt("sothangsau"));
                                    news.setStatus(jsonObject.getString("tinhtrang"));
                                    news.setNgay( jsonObject.getString("ngay"));
                                    ngay.setText(news.getNgay());
                                    sonuocthangtruoc.setText(String.valueOf(news.getTiennuocthangtruoc()));
                                    sonuocthangsau.setText(String.valueOf(news.getTiennuocthangsau()));
                                    thanhtien.setText(String.valueOf(news.getTongtien()));
                                    tinhtrang.setText(news.getStatus());

                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            /**
             * set paramater
             * */
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put(KEY_ID, String.valueOf(id));
                return params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(requestLogin);

    }

    private void ActionBarTienNuoc() {
        setSupportActionBar(toolbartiennuoc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbartiennuoc.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }



    public  void  Anhxa(){
        mangtiennuoc = new ArrayList<>();
        ngay = findViewById(R.id.ngaygannhat);
        sonuocthangtruoc = findViewById(R.id.sonuocthangtruoc);
        sonuocthangsau = findViewById(R.id.sonuocthangsau);
        thanhtien = findViewById(R.id.tongtien);
        tinhtrang = findViewById(R.id.tinhtrangthanhtoannuoc);
        toolbartiennuoc = findViewById(R.id.toolbartiennuoc);
        btnthanhtoan = findViewById(R.id.btnthanhtoan);
        listtiennuoc = findViewById(R.id.listtiennuoc);
        tiennuocAdapter = new tiennuocAdapter(mangtiennuoc,getApplicationContext());
        listtiennuoc.setAdapter(tiennuocAdapter);
    }
    private void event(){
        btnthanhtoan.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnthanhtoan:
                AlertDialog.Builder dialog = new AlertDialog.Builder(TienNuocActivity.this);
                dialog.setMessage("Bạn có muốn thanh toán ngay?").setCancelable(false)
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                xuLyThanhToan();
                            }
                        }).setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog.show();
                break;
        }
    }

    private void xuLyThanhToan() {
        StringRequest requestThanhtoan = new StringRequest(Request.Method.POST, URL_Thanhtoan,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gettiennuocmoinhat(account.getId());
                        gettiennuoc(account.getId());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }

                }) {
            /**
             * set paramater
             * */
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put(KEY_ID, String.valueOf(account.getId()));
                return params;
            }

        };
        RequestQueue queue = (RequestQueue) Volley.newRequestQueue(getApplicationContext());
        queue.add(requestThanhtoan);
    }

}
