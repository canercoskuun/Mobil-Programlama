package com.example.week9;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class KisiAdapter extends BaseAdapter {
    List<User> myUserList;
    LayoutInflater userInflater;

    public KisiAdapter (Activity activity, List<User> myUserList)
    {
        this.myUserList = myUserList;
        userInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myUserList.size();
    }

    @Override
    public Object getItem(int i) {
        return myUserList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View lineView;
        lineView = userInflater.inflate(R.layout.satir,null);
        TextView lbAd = lineView.findViewById(R.id.ad);
        TextView lbSoyad= lineView.findViewById(R.id.soyad);
        TextView lbYas = lineView.findViewById(R.id.yas);
        TextView lbCinsiyet=lineView.findViewById(R.id.cinsiyet);
        ImageView img = lineView.findViewById(R.id.imageView2);

        User tmpkisi = myUserList.get(i);
        lbAd.setText(tmpkisi.getAd());
        lbYas.setText(tmpkisi.getYas());
        lbSoyad.setText(tmpkisi.getSoyad());

        if(tmpkisi.isKadinMi())
        {
            lbCinsiyet.setText("Erkek");
            if(Integer.parseInt(tmpkisi.getYas()) > 18 && Integer.parseInt(tmpkisi.getYas()) < 50){
                img.setImageResource(R.drawable.male);
            }
            else if (Integer.parseInt(tmpkisi.getYas()) < 18){
                img.setImageResource(R.drawable.childboy);
            }
        else {
            img.setImageResource(R.drawable.old2);

        }}
        else {
            lbCinsiyet.setText("Kadın");
            if(Integer.parseInt(tmpkisi.getYas()) <50 && Integer.parseInt(tmpkisi.getYas()) > 18) {
                img.setImageResource(R.drawable.female);
            }
            else if(Integer.parseInt(tmpkisi.getYas()) < 18){
                img.setImageResource(R.drawable.childgirl);
            }
        else {
            img.setImageResource(R.drawable.old1);
            }
        }



        return lineView;
    }
}
