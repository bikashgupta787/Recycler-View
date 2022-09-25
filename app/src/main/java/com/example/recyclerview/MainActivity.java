package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.ItemClickListener {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<Modal>userList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecyclerView();

    }

    private void initData() {
        userList = new ArrayList<>();
        userList.add(new Modal(R.drawable.msd,"MS Dhoni","07:20","I am Captain Cool","-----------------------------------------------------------------------------------------------------"));

        userList.add(new Modal(R.drawable.vk,"Virat Kohli","18:20","I am King Kohli","-----------------------------------------------------------------------------------------------------"));

        userList.add(new Modal(R.drawable.rohit,"Rohit Sharma","15:45","I am Hitman","-----------------------------------------------------------------------------------------------------"));

        userList.add(new Modal(R.drawable.kl,"KL Rahul","01:20","I am Mr.Klass","-----------------------------------------------------------------------------------------------------"));

        userList.add(new Modal(R.drawable.bumrah,"Jasprit Bumrah","10:20","I am Boom Boom Bumrah","-----------------------------------------------------------------------------------------------------"));

        userList.add(new Modal(R.drawable.bhuvi,"Bhubaneswar Kumar","10:20","I am Swing King","-----------------------------------------------------------------------------------------------------"));

        userList.add(new Modal(R.drawable.pandya,"Hardik Pandya","10:20","I am KungFu Pandya","-----------------------------------------------------------------------------------------------------"));

        userList.add(new Modal(R.drawable.chahal,"Yuzi Chahal","10:20","I am Spin Wizard","-----------------------------------------------------------------------------------------------------"));

        userList.add(new Modal(R.drawable.jaddu,"Ravindra Jadeja","10:20","I am Sir Jadeja","-----------------------------------------------------------------------------------------------------"));

        userList.add(new Modal(R.drawable.sky,"SuryaKumar Yadav","10:20","I am SKY ","-----------------------------------------------------------------------------------------------------"));

        userList.add(new Modal(R.drawable.pant,"Rishab Pant","10:20","I am Superman Pant","-----------------------------------------------------------------------------------------------------"));

    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recylerview);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(userList, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(Modal m) {
        Fragment fragment = Player_detail.newInstance(m.getImageview1(),m.getTextview1(), m.getTextview3());
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.Main_fragment_Container, fragment, "Player_detail");
        transaction.addToBackStack(null);
        transaction.commit();
    }
}