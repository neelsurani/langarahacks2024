package com.example.collegeapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.ClipData;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListviewActivity extends AppCompatActivity {


    ListView listView;
    Button logout;
    String strData[] = {"Hack-X-Crypt","C", "Java", "PHP", "Suheldev"};
    int imgData[] = {R.drawable.hack,R.drawable.c, R.drawable.java, R.drawable.php, R.drawable.suheldev};
//    ArrayList<LangModel> langModelArrayList;
    ArrayList<String> mylist;
    ArrayAdapter<String>arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView = findViewById(R.id.grid_view);

        mylist = new ArrayList<>();
        mylist.add("Hack-X-Crypt");
        mylist.add("c");
        mylist.add("Java");
        mylist.add("PHP");
        mylist.add("Suheldev");
        mylist.add("Advanced java");
        mylist.add("Interview prep with c++");
        mylist.add("Interview prep with java");
        mylist.add("data structures with c");
        mylist.add("data structures with java");
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
        listView.setAdapter(arrayAdapter);
//        langModelArrayList = new ArrayList<LangModel>();
//
//        for (int i = 0; i < strData.length; i++) {
//            LangModel langModel = new LangModel(strData[i], imgData[i]);
//            langModelArrayList.add(langModel);
//        }
//
//        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this, langModelArrayList);
//        listView.setAdapter(myBaseAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String listData = langModelArrayList.get(i).getStrData();
//                Toast.makeText(ListviewActivity.this,"List Item is:"+listData, Toast.LENGTH_SHORT).show();
//
//                Intent intent =new Intent(ListviewActivity.this,custom2.class);
//                intent.putExtra("listview",listData);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem searchViewItem = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setQueryHint("Search here");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(mylist.contains(query)){
                    arrayAdapter.getFilter().filter(query);
                }else {

                    Toast.makeText(ListviewActivity.this, "Not found", Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}