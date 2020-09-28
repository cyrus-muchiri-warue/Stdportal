package ke.co.nevon.stdportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Lecturer extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<LecturerDetails>lecturerDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer);
        lecturerDetails=new ArrayList<>();
        lecturerDetails.add(new LecturerDetails("mwadulo","0792021601","0701538078","mwandulo@gmail.com","23","Academic block B"));
        lecturerDetails.add(new LecturerDetails("mwadulo","0792021601","0701538078","mwandulo@gmail.com","23","Academic block B"));
        lecturerDetails.add(new LecturerDetails("mwadulo","0792021601","0701538078","mwandulo@gmail.com","23","Academic block B"));
        lecturerDetails.add(new LecturerDetails("mwadulo","0792021601","0701538078","mwandulo@gmail.com","23","Academic block B"));
        lecturerDetails.add(new LecturerDetails("mwadulo","0792021601","0701538078","mwandulo@gmail.com","23","Academic block B"));
        lecturerDetails.add(new LecturerDetails("mwadulo","0792021601","0701538078","mwandulo@gmail.com","23","Academic block B"));
        LecturerAdapter lecturerAdapter=new LecturerAdapter(this,lecturerDetails);
        recyclerView=findViewById(R.id.lecturerRecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(lecturerAdapter);
    }
}
