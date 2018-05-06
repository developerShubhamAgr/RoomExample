package com.shubham.agr.roomexample.adapters;

import android.content.Context;
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

    private List<User> userList;
    private Context context;
    private LayoutInflater inflater;
    onClickListner onClickListner;

    public ContactAdapter(Context context, List<User> users,onClickListner onClickListner) {
        this.userList = users;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.onClickListner = onClickListner;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_contact,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        User user = userList.get(position);
        String name = String.format("%s %s",user.getFirstName(),user.getLastName());
        holder.tv_name.setText(name);
        holder.tv_phone.setText(user.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name,tv_phone;
        public ContactViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_phone = itemView.findViewById(R.id.tv_phone);

            itemView.setOnClickListener(v->{
                User user = userList.get(getAdapterPosition());
                onClickListner.onClickUser(user);
            });
        }
    }

    public interface onClickListner{
        void onClickUser(User user);
    }
}
