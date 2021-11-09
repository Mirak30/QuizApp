package com.example.prueba_quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Player> players;
    Context context;

    public MyAdapter(Context ct, ArrayList<Player> players)
    {
        context = ct;
        this.players=new ArrayList<Player>(players);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(players.get(position).getName());
        holder.myText2.setText("Resultado: Correctas: "+players.get(position).getCorrect()+ "/ Incorrectas: "+ players.get(position).getIncorrect());
        holder.myText3.setText(Integer.toString(players.get(position).getSeconds()));
    }

    @Override
    public int getItemCount() {
        return players.size()-1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myText1, myText2,myText3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.textNameRanking);
            myText2 = itemView.findViewById(R.id.textResultRanking);
            myText3 = itemView.findViewById(R.id.time);
        }
    }

}
