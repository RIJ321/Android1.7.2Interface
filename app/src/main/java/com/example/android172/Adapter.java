package com.example.android172;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android172.databinding.FragmentDialogChangeBinding;
import com.example.android172.databinding.ItemBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Model> list = new ArrayList<>();
    private OnClicks onClicks;


    public void addNum(ArrayList<Model> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    public void setOnClicks(OnClicks onClicks) {
        this.onClicks = onClicks;
    }

    public void setColor(int pos, int color) {
        list.get(pos).setColor(color);
        list.set(pos, list.get(pos));
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(ItemBinding.inflate(LayoutInflater.from
                (parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));

        holder.itemView.setOnClickListener(v -> onClicks.onClick(list.get(position), position));

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(v.getContext())

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setMessage("Are You Sure You Want to Delete This Note?!")
                        .setTitle("Attempt to Delete A Note")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                list.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("NO", (dialogInterface, i) -> dialogInterface.cancel())
                        .create()
                        .show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemBinding binding;


        public ViewHolder(ItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(Model model) {
            binding.tvNum.setText(String.valueOf(model.getId()+1));
            binding.tvNum.setBackgroundColor(itemView.getResources().getColor(model.getColor()));
        }

    }
}

