package com.example.android172;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.example.android172.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClicks{

    private ActivityMainBinding binding;
    Adapter adapter;
    private ChangeDialogFragment dialogFragment;

    private ArrayList<Model> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new Adapter();
        adapter.setOnClicks(this);
        adapter.addNum(createList());
        binding.rvTest.setAdapter(adapter);
    }

    private ArrayList<Model> createList() {

        for (int i = 0; i < 20; i++) {
            list.add(new Model(i, R.color.orange));
        }
        return list;
    }

    @Override
    public void onClick(Model model, int pos) {
        dialogFragment = new ChangeDialogFragment();
        dialogFragment.setPos(pos);
        dialogFragment.show(getSupportFragmentManager(),"ololo");
    }
}