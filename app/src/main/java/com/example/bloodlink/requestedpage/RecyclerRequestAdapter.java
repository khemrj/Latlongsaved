package com.example.bloodlink.requestedpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodlink.R;

import java.util.ArrayList;

public class RecyclerRequestAdapter extends RecyclerView.Adapter<RecyclerRequestAdapter.ViewHolder> {

    Context context;
    ArrayList<requestlistModel>arrRequest;
    RecyclerRequestAdapter(Context context, ArrayList<requestlistModel>arrRequest){
        this.context=context;
        this.arrRequest=arrRequest;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.requested_row,parent,false);
ViewHolder viewHolder=new ViewHolder(view) ;
return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.imgContact.setImageResource(arrRequest.get(position).img);
      holder.txtName.setText(arrRequest.get(position).name);
        holder.txtAge.setText(arrRequest.get(position).age);
        holder.txtBloodGroup.setText(arrRequest.get(position).bloodgroup);
        holder.txtPints.setText(arrRequest.get(position).pints);
        holder.txtLocation.setText(arrRequest.get(position).location);
    }

    @Override
    public int getItemCount() {

        return arrRequest.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtAge, txtBloodGroup, txtPints, txtLocation;
        ImageView imgContact;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgContact = itemView.findViewById(R.id.imageContact);
            txtName = itemView.findViewById(R.id.txtName);
            txtAge = itemView.findViewById(R.id.txtAge);
            txtBloodGroup = itemView.findViewById(R.id.txtBloodGroup);
            txtPints=itemView.findViewById(R.id.txtPints);
            txtLocation = itemView.findViewById(R.id.txtLocation);
        }
    }
}
