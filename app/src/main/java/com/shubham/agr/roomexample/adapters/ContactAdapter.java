package com.shubham.agr.roomexample.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shubham.agr.roomexample.R;
import com.shubham.agr.roomexample.models.User;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<User> users;

    public ContactAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_contact,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        User user = users.get(position);
        String name = String.format("%s %s",user.getFirstName(),user.getLastName());
        holder.tv_name.setText(name);
        holder.tv_phone.setText(user.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name,tv_phone;
        public ContactViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_phone = itemView.findViewById(R.id.tv_phone);
        }
    }
}
