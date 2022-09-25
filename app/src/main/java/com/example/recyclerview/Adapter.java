package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {

    private List<Modal> userList;
    ItemClickListener ClickListener;

    public Adapter(List<Modal>userList,ItemClickListener ClickListener){
        this.userList=userList;
        this.ClickListener = ClickListener;
    }

    @NonNull
    @Override
    public Adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemdesign,parent,false);
        return new viewHolder(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewHolder holder, int position) {
         int resource = userList.get(position).getImageview1();
         String name = userList.get(position).getTextview1();
        String msg = userList.get(position).getTextview3();
        String time = userList.get(position).getTextview2();
        String line = userList.get(position).getTextview4();


        holder.setData(resource,name,msg,time,line);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickListener.onItemClick(userList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public interface ItemClickListener {
        public void onItemClick(Modal m);
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;
        private TextView textView2;
        private TextView textView3;
        private TextView textView4;
        private Adapter adapt;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview1);
            textView = itemView.findViewById(R.id.textview1);
            textView2 = itemView.findViewById(R.id.textview2);
            textView3 = itemView.findViewById(R.id.textview3);
            textView4 = itemView.findViewById(R.id.textview4);
            itemView.findViewById(R.id.del).setOnClickListener(view -> {
                adapt.userList.remove(getAdapterPosition());
                adapt.notifyItemRemoved(getAdapterPosition());

            });
        }

        public viewHolder linkAdapter(Adapter adapt){
            this.adapt = adapt;
            return  this;
        }

        public void setData(int resource, String name, String msg, String time, String line) {
            imageView.setImageResource(resource);
            textView.setText(name);
            textView3.setText(msg);
            textView2.setText(time);
            textView4.setText(line);
        }
    }
}
