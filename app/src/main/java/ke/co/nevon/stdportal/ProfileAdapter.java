package ke.co.nevon.stdportal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyprofileHolder> {
    Context context;
    ArrayList<ProfileItem> profileItems;

    public ProfileAdapter(Context context, ArrayList<ProfileItem> profileItems) {
        this.context = context;
        this.profileItems = profileItems;
    }

    @NonNull
    @Override
    public MyprofileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.profilerow,parent,false);
        MyprofileHolder myprofileHolder=new MyprofileHolder(view);

        return myprofileHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyprofileHolder holder, int position) {
        holder.username.setText("USERNAME :"+profileItems.get(position).getUsername());
        holder.program.setText("PROGRAM :"+profileItems.get(position).getProgram());
        holder.year.setText("YEAR OF STUDY :"+profileItems.get(position).getYear());
        holder.regNo.setText("REGISTRATION NUMBER :"+profileItems.get(position).getRegNo());
        holder.nationalId.setText("NATIONAL ID :"+profileItems.get(position).getNationalId());
        holder.contact.setText("CONTACT :"+profileItems.get(position).getContact());
        holder.email.setText("EMAIL :"+profileItems.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return profileItems.size();
    }


    class MyprofileHolder extends RecyclerView.ViewHolder{
        TextView username,program,year,regNo,nationalId,contact,email;

        public MyprofileHolder(@NonNull View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.username);
            program=itemView.findViewById(R.id.program);
            year=itemView.findViewById(R.id.year);
            regNo=itemView.findViewById(R.id.registrationnNo);
            nationalId=itemView.findViewById(R.id.national);
            contact=itemView.findViewById(R.id.contact);
            email=itemView.findViewById(R.id.email);
        }
    }
}
