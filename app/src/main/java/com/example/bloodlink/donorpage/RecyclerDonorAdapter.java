package com.example.bloodlink.donorpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodlink.R;

import java.util.ArrayList;

public class RecyclerDonorAdapter extends RecyclerView.Adapter<RecyclerDonorAdapter.ViewHolder> {
    @NonNull
    Context context;
    ArrayList<DonorModel> arrDonor;

    RecyclerDonorAdapter(@NonNull Context context, ArrayList<DonorModel> arrDonor) {
        this.context = context;
        this.arrDonor = arrDonor;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.donor_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //here problem is showning don't treat position as fixed ;only use immedately and call 'holder.getAdapterPosition()' to look it up later in this fun public void onBindViewHolder(@NonNull ViewHolder holder, int position)
        int adapterPosition = holder.getAdapterPosition();


        holder.imgContact.setImageResource(arrDonor.get(position).img);
        holder.txtName.setText(arrDonor.get(position).name);
        holder.txtAge.setText(arrDonor.get(position).age);
        holder.txtBloodGroup.setText(arrDonor.get(position).bloodgroup);
        holder.txtPints.setText(arrDonor.get(position).pints);
        holder.txtLocation.setText(arrDonor.get(position).location);
        // Bind other data as before

        // Set the visibility of the button based on the model's property
        //---yo condition hamro button visible garauna lagi ho
//        if (arrDonor.get(position).isAcceptButtonVisible()) {
//            holder.acceptButton.setVisibility(View.VISIBLE);
//        } else {
//            holder.acceptButton.setVisibility(View.GONE);
//        }


        // Set the text of the button based on the model's property
        holder.acceptButton.setText(arrDonor.get(position).getAcceptButtonText());
        if ("Accepted".equals(arrDonor.get(adapterPosition).getAcceptButtonText())) {
            // Change the background color when "Accepted" is displayed
            //ContextCompat mean
            holder.acceptButton.setBackgroundColor(ContextCompat.getColor(context, R.color.orange));
        } else {
            // Set the default background color for other cases
            holder.acceptButton.setBackgroundColor(ContextCompat.getColor(context, com.google.android.material.R.color.design_default_color_primary));
        }

        // Handle the "Accept" button click
        holder.acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    // Update the model to hide the button when clicked
                    // arrDonor.get(adapterPosition).setAcceptButtonVisible(false);
                    // Notify the adapter that the data has changed to refresh the UI

                    // Set the text of the button based on the model's property
                    //  holder.acceptButton.setText(arrDonor.get(position).getAcceptButtonText());
                    arrDonor.get(adapterPosition).setAcceptButtonText("Accepted");


                    notifyDataSetChanged();
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrDonor.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtAge, txtBloodGroup, txtPints, txtLocation;
        ImageView imgContact;
        Button acceptButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgContact = itemView.findViewById(R.id.imageContact);
            txtName = itemView.findViewById(R.id.txtName);
            txtAge = itemView.findViewById(R.id.txtAge);
            txtBloodGroup = itemView.findViewById(R.id.txtBloodGroup);
            txtPints = itemView.findViewById(R.id.txtPints);
            txtLocation = itemView.findViewById(R.id.txtLocation);
            acceptButton = itemView.findViewById(R.id.acceptButton);


        }
    }
}
