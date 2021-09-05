package com.example.rickandmorty.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rickandmorty.R;
import com.example.rickandmorty.pojo.Personage;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PersonageAdapter extends RecyclerView.Adapter<PersonageAdapter.PersonageViewHolder> {


    @SuppressLint("NotifyDataSetChanged")
    public void setPersonages(List<Personage> personages) {
        this.personages = personages;
        notifyDataSetChanged();
    }

    private List<Personage> personages;


    @NonNull
    @Override
    public PersonageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.personage_item, viewGroup, false);
        return new PersonageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonageViewHolder holder, int position) {
        Personage personage = personages.get(position);
        holder.textViewName.setText(personage.getName());
        holder.textViewSpecies.setText(personage.getSpecies());
        holder.textViewGender.setText(personage.getGender());
        holder.textViewStatus.setText(personage.getStatus());
        Picasso.get().load(personage.getImage()).into(holder.imageViewAvatar);



    }

    @Override
    public int getItemCount() {
        return personages.size();
    }

    static class PersonageViewHolder extends RecyclerView.ViewHolder{


        private final TextView textViewName;
        private final TextView textViewStatus;
        private final TextView textViewSpecies;
        private final TextView textViewGender;
        private final ImageView imageViewAvatar;





        public PersonageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewGender = itemView.findViewById(R.id.textViewGender);
            textViewStatus = itemView.findViewById(R.id.textViewStatus);
            textViewSpecies = itemView.findViewById(R.id.textViewSpecies);
            textViewName = itemView.findViewById(R.id.textViewName);
            imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar);

        }
    }


}
