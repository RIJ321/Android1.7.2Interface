package com.example.android172;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.android172.databinding.FragmentDialogChangeBinding;

public class ChangeDialogFragment extends DialogFragment {

    private FragmentDialogChangeBinding binding;
    private int color = 0;
    private int pos;
    private MainActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= FragmentDialogChangeBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDialogChangeBinding.inflate(inflater,container,false);
        activity = (MainActivity) requireActivity();
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.rg.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId){
                case R.id.rb1:
                    color = R.color.yellow;
                    break;
                case R.id.rb2:
                    color = R.color.red;
                    break;
                case R.id.rb3:
                    color = R.color.blue;
                    break;
            }
        });
        binding.btnChangeColor.setOnClickListener(this::click);

    }
    private void click(View view){
        if (color != 0){
            activity.adapter.setColor(pos, color);
            getDialog().dismiss();
        }
    }

    public void setPos(int pos){
        this.pos = pos;
    }
}