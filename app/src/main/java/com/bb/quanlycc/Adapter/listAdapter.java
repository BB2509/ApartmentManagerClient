package com.bb.quanlycc.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.quanlycc.Model.danhsach;
import com.bb.quanlycc.R;

import java.util.ArrayList;

public class listAdapter extends BaseAdapter {

    ArrayList<danhsach> arrayListnews;
    Context context ;

    public listAdapter(ArrayList<danhsach> arrayListnews, Context context) {
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
        ImageView imgmenu;


    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder =null;
        if(view ==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_list,null);
            viewHolder.txttitle = (TextView) view.findViewById(R.id.textviewnews);
            viewHolder.imgmenu = view.findViewById(R.id.idlistmenu);
            view.setTag(viewHolder);
        }else {

            viewHolder = (ViewHolder) view.getTag();
        }
        danhsach New = (danhsach) getItem(i);
        viewHolder.txttitle.setText(New.getMenu());
        viewHolder.imgmenu.setImageResource(New.getHinhanh());

        return view;
    }
}