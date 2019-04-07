package com.bb.quanlycc;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bb.quanlycc.Adapter.newsAdapter;
import com.bb.quanlycc.Adapter.listAdapter;
import com.bb.quanlycc.Model.Account;
import com.bb.quanlycc.Model.danhsach;
import com.bb.quanlycc.Model.news;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;





public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar ;
    ViewFlipper viewFlipper;
    ListView recyclerView ;
    NavigationView NavigationView ;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;
    private Account account;
    int id =0 ;
    String Title="";
    String Status="";
    String date ="";
    String url ="http://10.0.3.2/server/getspmoinhat.php";

    ArrayList<news>  mangnews;
    ArrayList<danhsach> manglist ;
    newsAdapter newsAdapter ;
    listAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        account = new Account();
        account = (Account) intent.getSerializableExtra("login");
        Anhxa();
        ActionBar();
        ActionFlipper();
        GetThongtin();
        CathOnNewsListView();
        LoadTT();
    }


    private void LoadTT() {
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(HomeActivity.this,NewsDetailActivity.class);
                intent.putExtra("Thongtin",mangnews.get(i));
                startActivity(intent);
            }
        });
    }

    private void CathOnNewsListView() {
        listViewmanhinhchinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                switch (i){
                    case 0:
                        Intent intent = new Intent(HomeActivity.this ,HomeActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        Intent intent1 = new Intent(HomeActivity.this ,TienDienActivity.class);
                        intent1.putExtra("login", account);
                        startActivity(intent1);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        Intent intent2 = new Intent(HomeActivity.this ,TienNuocActivity.class);
                        intent2.putExtra("login", account);
                        startActivity(intent2);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        Intent intent3 = new Intent(HomeActivity.this ,LienHeActivity.class);
                        intent3.putExtra("login", account);
                        startActivity(intent3);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        Intent intent4 = new Intent(HomeActivity.this ,ThongTinActivity.class);
                        intent4.putExtra("login", account);
                        startActivity(intent4);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }
            }
        });
    }

    private void GetThongtin() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null){
                    for(int i =0 ; i <response.length();i++){
                        try {
                            news news = new news();
                            JSONObject jsonObject = response.getJSONObject(i);
                            news.setID( jsonObject.getInt("id"));
                            news.setTitle( jsonObject.getString("Title"));
                            news.setStatus( jsonObject.getString("Status"));
                            news.setDate( jsonObject.getString("date"));
                            mangnews.add(news );
                            newsAdapter.notifyDataSetChanged(); //update ban ve


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);

    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });



    }
    private void ActionFlipper() {
        ArrayList<String> hinhanh = new ArrayList() ;
        hinhanh.add("https://img.thuthuatphanmem.vn/uploads/2018/10/09/anh-nha-3d-dep-mat_041507591.jpg");
        hinhanh.add("https://img.thuthuatphanmem.vn/uploads/2018/10/09/anh-nha-biet-thu-dep-nhat_041507669.jpg");
        hinhanh.add("https://img.thuthuatphanmem.vn/uploads/2018/10/09/anh-nha-biet-thu-dep_041507685.jpg");
        hinhanh.add("https://img.thuthuatphanmem.vn/uploads/2018/10/09/anh-nha-dep-va-doc-nhat_041508123.jpg");
        hinhanh.add("https://img.thuthuatphanmem.vn/uploads/2018/10/09/anh-nha-go-dep_041508185.jpg");


        for(int i = 0 ; i < hinhanh.size() ; i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(hinhanh.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);

        }
        viewFlipper.setFlipInterval(5000); //set thoi gian hinh anh
        viewFlipper.setAutoStart(true);
        Animation animationin = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animationout = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animationin);
        viewFlipper.setInAnimation(animationout);

    }

    private  void Anhxa(){
        toolbar = (Toolbar) findViewById(R.id.toolbartrangchu);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        recyclerView = (ListView) findViewById(R.id.recyclerview);
        NavigationView = (NavigationView) findViewById(R.id.NavigationView);
        listViewmanhinhchinh  = (ListView) findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mangnews = new ArrayList<>();
        manglist =new ArrayList<>();
        manglist.add(0,new danhsach(0,"Trang Chủ",R.drawable.home));
        manglist.add(1,new danhsach(0,"Tiền Điện",R.drawable.electric));
        manglist.add(2,new danhsach(0,"Tiền Nước",R.drawable.water2));
        manglist.add(3,new danhsach(0,"Liên Hệ",R.drawable.contact));
        manglist.add(4,new danhsach(0,"Thông Tin",R.drawable.users));


        newsAdapter = new newsAdapter(mangnews,getApplicationContext());
        recyclerView.setAdapter(newsAdapter);
        listAdapter= new listAdapter(manglist,getApplicationContext());
        listViewmanhinhchinh.setAdapter(listAdapter);


    }
}

