package ke.co.nevon.stdportal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyviewHolder> {

    private Context context;
    private ArrayList<EventList> eventLists;

    public EventAdapter(Context context, ArrayList<EventList> eventLists) {
        this.context = context;
        this.eventLists = eventLists;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.eventrow,parent,false);
        MyviewHolder holder=new MyviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        final EventList event=eventLists.get(position);
        holder.title.setText("EVENT TITLE :"+event.getTitle());
        holder.venue.setText("VENUE :"+event.getVenue());
        holder.date.setText("DATE :"+event.getDate());
        holder.desc.setText("DESCRIPTION :"+event.getDesc());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,TestService.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return eventLists.size();
    }

    public  static   class MyviewHolder  extends RecyclerView.ViewHolder{

        TextView title,desc,venue,date;
        LinearLayout linearLayout;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.eventtitle);
            desc=itemView.findViewById(R.id.description);
            venue=itemView.findViewById(R.id.venue);
            date=itemView.findViewById(R.id.date);
            linearLayout=itemView.findViewById(R.id.linearlayout);
        }
    }

}
