package ke.co.nevon.stdportal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AcademicAdapter extends RecyclerView.Adapter<AcademicAdapter.MyHolder>{
    Context context;
    ArrayList<AcademicMenuList> menuList;
    int position;

    public AcademicAdapter(Context context, ArrayList<AcademicMenuList> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.academic_row_item,parent,false);
        MyHolder myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        this.position=position;
        holder.menuItem.setText(menuList.get(position).getMenuItem());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (position)
                {
                    case 0:
                        Intent profile=new Intent(context,Profile.class);
                        context.startActivity(profile);
                        Toast.makeText(context,menuList.get(position).getMenuItem(),Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Intent timetable=new Intent(context,Timetable.class);
                        context.startActivity(timetable);
                        Toast.makeText(context,menuList.get(position).getMenuItem(),Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Intent exam=new Intent(context,Exam.class);
                        context.startActivity(exam);
                        Toast.makeText(context,menuList.get(position).getMenuItem(),Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Intent lecturer=new Intent(context,Lecturer.class);
                        context.startActivity(lecturer);
                        Toast.makeText(context,menuList.get(position).getMenuItem(),Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Intent unit=new Intent(context,Units.class);
                        context.startActivity(unit);
                        Toast.makeText(context,menuList.get(position).getMenuItem(),Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        Intent memo=new Intent(context,InternalMemo.class);
                        context.startActivity(memo);
                        Toast.makeText(context,menuList.get(position).getMenuItem(),Toast.LENGTH_LONG).show();
                        break;
                    case 6:
                        Intent notes=new Intent(context,Notes.class);
                        context.startActivity(notes);
                        Toast.makeText(context,menuList.get(position).getMenuItem(),Toast.LENGTH_LONG).show();
                        break;

                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder{
        TextView menuItem;
        CardView cardView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            menuItem=itemView.findViewById(R.id.menu_item);
            cardView=itemView.findViewById(R.id.cardview);
        }
    }
}



