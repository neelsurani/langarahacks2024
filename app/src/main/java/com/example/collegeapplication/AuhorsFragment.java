package com.example.collegeapplication;

import android.content.Intent;
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

public class AuhorsFragment extends Fragment {

    ListView listView;
    String[] url={"https://www.google.com/url?sa=i&url=https%3A%2F%2Fsrimadbhagavadgita.in%2F&psig=AOvVaw1aJm9HLYFJn5M4EzIJCu76&ust=1683445472713000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCMDevJ2Z4P4CFQAAAAAdAAAAABAE","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.amazon.in%2FRamcharitmans-Ramayan-Sampurna-Large-Language%2Fdp%2FB08K38T7XG&psig=AOvVaw3SS-c7o18O1PtohGn_s5Be&ust=1683445865681000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCKDg8dia4P4CFQAAAAAdAAAAABAE"};
    String[] strData = { "Suheldev","japaneseLongAndHappyLife","LifeAmazingSecretes","ThePowerofyourmind","AtomicHabits","The5AmClub"
    ,"TheAlchemist","PsychologyofMoney","ImmortalofMehula","ImmortalofNagas"};
    int[] imgData = {R.drawable.suheldev,R.drawable.japaneselongandhappylife, R.drawable.lifeamazingsecrete, R.drawable.thepowerofyourmind, R.drawable.atomichabits,
            R.drawable.the5amclub,R.drawable.thealchemist,R.drawable.psychologyofmoney,R.drawable.immortalofmeluha,R.drawable.immortalofnagas};
    ArrayList<LangModel> langModelArrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_auhors, container, false);
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
                intent.putExtra("name",url[position]);
                intent.putExtra("image",imgData[position]);
                startActivity(intent);
            }
        });
        for (int i = 0; i < strData.length; i++) {
            LangModel langModel = new LangModel(url[i], imgData[i]);
            langModelArrayList.add(langModel);
        }
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(getActivity(), langModelArrayList);
        listView.setAdapter(myBaseAdapter);

        return myView;
    }

    private class CustomAdapter extends BaseAdapter  {
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

            name.setText(url[position]);
            Image.setImageResource(imgData[position]);
            return view1;
        }
    }
}