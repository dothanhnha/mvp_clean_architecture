package com.example.mvp_dagger_rxjava.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp_dagger_rxjava.R;
import com.example.mvp_dagger_rxjava.model.Repository;

import java.util.ArrayList;

import javax.inject.Inject;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ReposViewHolder> {

    ArrayList<Repository> dataset = new ArrayList<>();

    @Inject
    public ReposAdapter() {
        this.dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ReposViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ReposViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_repository,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReposViewHolder holder, int position) {
        holder.bindView(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ReposViewHolder extends RecyclerView.ViewHolder {
        TextView title, stars;
        public ReposViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            stars = itemView.findViewById(R.id.stars);
        }

        public void bindView(Repository repository) {
            title.setText(repository.getFull_name());
            stars.setText(String.valueOf(repository.getStargazers_count()));
        }
    }
}
