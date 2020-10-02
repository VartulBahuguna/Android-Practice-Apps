package com.codingblocks.todolist;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder>{

    List<TodoModel> list;

    public TodoAdapter(List<TodoModel> list){
        this.list = list;

    }

    public void setTodos(List<TodoModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public static class TodoViewHolder extends RecyclerView.ViewHolder{

        View viewColorTag;
        TextView txtShowTitle, txtShowTask, txtShowCategory, txtShowTime, txtShowDate;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);

            viewColorTag = itemView.findViewById(R.id.viewColorTag);
            txtShowCategory = itemView.findViewById(R.id.txtShowCategory);
            txtShowTask = itemView.findViewById(R.id.txtShowTask);
            txtShowTitle = itemView.findViewById(R.id.txtShowTitle);
            txtShowTime = itemView.findViewById(R.id.txtShowTime);
            txtShowDate = itemView.findViewById(R.id.txtShowDate);

        }

        public void bind(TodoModel todoModel) {
            @SuppressLint("ResourceType")
            int[] colors = itemView.getResources().getIntArray(R.array.random_color);
            int randomColor = colors[new Random().nextInt(colors.length)];

            viewColorTag.setBackgroundColor(randomColor);
            txtShowCategory.setText(todoModel.category);
            txtShowTask.setText(todoModel.description);
            txtShowTitle.setText(todoModel.title);
            updateTime(todoModel.time);
            updateDate(todoModel.date);

        }

        private void updateTime(Long time) {
            String myformat = "h:mm a";

            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat sdf = new SimpleDateFormat(myformat);

            txtShowTime.setText(sdf.format(new Date(time)));

        }

        private void updateDate(Long time) {
            String myformat = "EEE, d MMM yyyy";
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat sdf = new SimpleDateFormat(myformat);

            txtShowDate.setText(sdf.format(new Date(time)));

        }
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TodoViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_todo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).id;
    }
}
