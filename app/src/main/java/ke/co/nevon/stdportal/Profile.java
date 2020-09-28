package ke.co.nevon.stdportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
    RecyclerView profileRecycleview;
    ProfileAdapter profileAdapter;
    ArrayList<ProfileItem>profileItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileItems=new ArrayList<>();
        profileItems.add(new ProfileItem("cyrus","bmc","3","ct201/0014/16","34910104","0792021601","cyrus@gmail.com"));
        profileAdapter=new ProfileAdapter(this,profileItems);
        profileRecycleview=findViewById(R.id.profilerecyclerview);
        profileRecycleview.setHasFixedSize(true);
        profileRecycleview.setLayoutManager(new LinearLayoutManager(this));
        profileRecycleview.setAdapter(profileAdapter);


    }
}
