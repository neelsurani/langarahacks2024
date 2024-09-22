package com.example.collegeapplication;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ComputerFragment extends Fragment {

    ListView listView;
    String strData[] = {"C", "Java", "PHP", "A+CompleteServerGuide","OracleDatabase","MicroSoftOfficeGuide","InternetServer"};
    int imgData[] = {R.drawable.c, R.drawable.java, R.drawable.php, R.drawable.apluscompletereviewguide, R.drawable.oracledatabase,
            R.drawable.microsoftoffice365, R.drawable.exchangeserver};
    ArrayList<LangModel> langModelArrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_computer, container, false);
        listView = myView.findViewById(R.id.Grid_view);
        langModelArrayList = new ArrayList<LangModel>();

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),custom2.class);
                String listData = langModelArrayList.get(position).getStrData();
                Toast.makeText(getActivity(),"List Item is:"+listData, Toast.LENGTH_SHORT).show();

                intent.putExtra("name",strData[position]);
                intent.putExtra("image",imgData[position]);
                startActivity(intent);
            }
        });
        for (int i = 0; i < strData.length; i++) {
            LangModel langModel = new LangModel(strData[i], imgData[i]);
            langModelArrayList.add(langModel);
        }
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(getActivity(), langModelArrayList);
        listView.setAdapter(myBaseAdapter);
        return myView;
    }
    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imgData.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.activity_raw_custm_list,null);
            TextView name = view1.findViewById(R.id.tv_lang);
            ImageView Image = view1.findViewById(R.id.img_lang);

            name.setText(strData[position]);
            Image.setImageResource(imgData[position]);
            return view1;
        }
    }
}