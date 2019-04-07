package com.bb.quanlycc.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.quanlycc.Model.news;
import com.bb.quanlycc.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class newsAdapter extends BaseAdapter {

    ArrayList<news> arrayListnews;
    Context context ;

    public newsAdapter(ArrayList<news> arrayListnews, Context context) {
        this.arrayListnews = arrayListnews;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListnews.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListnews.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public  class ViewHolder{
        TextView txttitle;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder =null;
        if(view ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_listview_news,null);
            viewHolder.txttitle = (TextView) view.findViewById(R.id.textviewnews);
            view.setTag(viewHolder);
        }else {

            viewHolder = (ViewHolder) view.getTag();
        }
        news New = (news) getItem(i);
        viewHolder.txttitle.setText(New.getTitle());

        return view;
    }
}