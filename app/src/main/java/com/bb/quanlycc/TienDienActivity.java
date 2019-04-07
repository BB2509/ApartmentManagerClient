package com.bb.quanlycc;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.bb.quanlycc.Model.Account;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bb.quanlycc.Adapter.tiendienAdapter;
import com.bb.quanlycc.Model.tiendien;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TienDienActivity extends AppCompatActivity implements View.OnClickListener {
    ListView listtiendien;
    TextView ngay, sodienthangtruoc,sodienthangsau,thanhtien,tinhtrang;
    Toolbar toolbartiendien;
    Button btnthanhtoan;
    String url ="http://10.0.3.2/server/gettiendien.php";
    String URL_Thanhtoan ="http://10.0.3.2/server/thanhtoan.php";
    public static final String KEY_ID = "idusers";
    ArrayList<tiendien> mangtiendien;
    tiendienAdapter tiendienAdapter;
    private  Account account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tien_dien);
        Intent intent = getIntent();
        account = new Account();
        account = (Account) intent.getSerializableExtra("login");
        Anhxa();
        gettiendien(account.getId());
        Gettiendienmoinhat(account.getId());
        ActionBarTienDien();
        event();
    }



//    public void Gettiendienmoinhat(){
//        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                if(response != null){
//                    for(int i =0 ; i <1;i++){
//                        try {
//                            tiendien news = new tiendien();
//                            JSONObject jsonObject = response.getJSONObject(i);
//                            news.setID( jsonObject.getInt("id"));
//                            news.setTiendien(jsonObject.getInt("tiendien"));
//                            news.setTiendienthangtruoc( jsonObject.getInt("sodienthangtruoc"));
//                            news.setTiendienthangsau( jsonObject.getInt("sodienthangsau"));
//                            news.setStatus(jsonObject.getString("tinhtrang"));
//                            news.setNgay( jsonObject.getString("ngay"));
//                           ngay.setText(news.getNgay());
//                           sodienthangtruoc.setText(String.valueOf(news.getTiendienthangtruoc()));
//                           sodienthangsau.setText(String.valueOf(news.getTiendienthangsau()));
//                           thanhtien.setText(String.valueOf(news.getTiendien()));
//                           tinhtrang.setText(news.getStatus());
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        requestQueue.add(jsonArrayRequest);
//    }

    public void Gettiendienmoinhat(final int id) {


        StringRequest requestLogin = new StringRequest(Request.Method.POST, url ,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        if(response != null){
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                mangtiendien.clear();
                                for(int i =0; i< 1; i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    tiendien news = new tiendien();
                                    news.setID( jsonObject.getInt("id"));
                                    news.setTiendien(jsonObject.getInt("tiendien"));
                                    news.setTiendienthangtruoc( jsonObject.getInt("sodienthangtruoc"));
                                    news.setTiendienthangsau( jsonObject.getInt("sodienthangsau"));
                                    news.setStatus(jsonObject.getString("tinhtrang"));
                                    news.setNgay( jsonObject.getString("ngay"));
                                    ngay.setText(news.getNgay());
                                    sodienthangtruoc.setText(String.valueOf(news.getTiendienthangtruoc()));
                                    sodienthangsau.setText(String.valueOf(news.getTiendienthangsau()));
                                    thanhtien.setText(String.valueOf(news.getTiendien()));
                                    tinhtrang.setText(news.getStatus());
                                   // mangtiendien.add(news);
                                }
                               // tiendienAdapter.notifyDataSetChanged();

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

    private void ActionBarTienDien() {
        setSupportActionBar(toolbartiendien);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbartiendien.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                    }
        });



    }
    public void gettiendien(final int id) {


            StringRequest requestLogin = new StringRequest(Request.Method.POST, url ,
                    new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            if(response != null){
                                    try {
                                        JSONArray jsonArray = new JSONArray(response);
                                        mangtiendien.clear();
                                        for(int i =0; i< jsonArray.length(); i++) {
                                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                                            tiendien news = new tiendien();
                                            news.setID( jsonObject.getInt("id"));
                                            news.setTiendien(jsonObject.getInt("tiendien"));
                                            news.setTiendienthangtruoc( jsonObject.getInt("sodienthangtruoc"));
                                            news.setTiendienthangsau( jsonObject.getInt("sodienthangsau"));
                                            news.setStatus(jsonObject.getString("tinhtrang"));
                                            news.setNgay( jsonObject.getString("ngay"));
//                                            ngay.setText(news.getNgay());
//                                            sodienthangtruoc.setText(String.valueOf(news.getTiendienthangtruoc()));
//                                            sodienthangsau.setText(String.valueOf(news.getTiendienthangsau()));
//                                            thanhtien.setText(String.valueOf(news.getTiendien()));
//                                            tinhtrang.setText(news.getStatus());
                                            mangtiendien.add(news);
                                            tiendienAdapter.notifyDataSetChanged();
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

    private void event(){
        btnthanhtoan.setOnClickListener(this);
    }



    public  void  Anhxa(){
        mangtiendien = new ArrayList<>();
        ngay = findViewById(R.id.ngaygannhat);
        sodienthangtruoc = findViewById(R.id.sodienthangtruoc);
        sodienthangsau = findViewById(R.id.sodienthangsau);
        thanhtien = findViewById(R.id.thanhtien);
        tinhtrang = findViewById(R.id.tinhtrangthanhtoan);
        toolbartiendien = findViewById(R.id.toolbartiendien);
        btnthanhtoan = findViewById(R.id.btnthanhtoan);
        listtiendien = findViewById(R.id.listtiendien);
        tiendienAdapter = new tiendienAdapter(mangtiendien,getApplicationContext());
        listtiendien.setAdapter(tiendienAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnthanhtoan:
                AlertDialog.Builder dialog = new AlertDialog.Builder(TienDienActivity.this);
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
                        Gettiendienmoinhat(account.getId());
                        gettiendien(account.getId());
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
