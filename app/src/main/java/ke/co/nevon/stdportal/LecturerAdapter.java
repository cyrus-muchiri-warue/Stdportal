package ke.co.nevon.stdportal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LecturerAdapter extends RecyclerView.Adapter<LecturerAdapter.MylecturerHolder> {
    Context context;
    ArrayList<LecturerDetails>lecturerDetails;

    public LecturerAdapter(Context context, ArrayList<LecturerDetails> lecturerDetails) {
        this.context = context;
        this.lecturerDetails = lecturerDetails;
    }

    @NonNull
    @Override
    public MylecturerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.lecturercustomrow,parent,false);
        return new MylecturerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MylecturerHolder holder, int position) {
        holder.name.setText("Lecturer Name :"+lecturerDetails.get(position).getName());
        holder.contact1.setText("CONTACT 1 :"+lecturerDetails.get(position).getContact1());
        holder.contact2.setText("CONTACT 2 :"+lecturerDetails.get(position).getContact2());
        holder.email.setText("EMAIL :"+lecturerDetails.get(position).getEmail());
        holder.office.setText("OFFICE :"+lecturerDetails.get(position).getOffice());
        holder.building.setText("BUILDING:"+lecturerDetails.get(position).getBuilding());

    }

    @Override
    public int getItemCount() {
        return lecturerDetails.size();
    }

    class  MylecturerHolder extends RecyclerView.ViewHolder{
       TextView name,contact1,contact2,email,office,building;

       public MylecturerHolder(@NonNull View itemView) {
           super(itemView);
           name=itemView.findViewById(R.id.lecturerName);
           contact1=itemView.findViewById(R.id.lecturercontact1);
           contact2=itemView.findViewById(R.id.lecturercontact2);
           email=itemView.findViewById(R.id.lecturerEmail);
           office=itemView.findViewById(R.id.lecturerOffice);
           building=itemView.findViewById(R.id.buildingname);
       }
   }
}
