package com.example.retrofitrxjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.model.UserModel;

import java.util.ArrayList;

/**
 * Created by Bagwan Akib on 12/22/2019.
 */
public class GitUserAdapter extends RecyclerView.Adapter<GitUserAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<UserModel> userList;

    public GitUserAdapter(Context mContext, ArrayList<UserModel> userList) {
        this.mContext = mContext;
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvId.setText(String.valueOf(userList.get(position).getId()));
        holder.tvLoginId.setText(userList.get(position).getLogin());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvLoginId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_item_response_id);
            tvLoginId = itemView.findViewById(R.id.tv_login);
        }
    }
}
