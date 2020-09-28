package ke.co.nevon.stdportal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import  ke.co.nevon.stdportal.Eventservice.MyBinder;

public class Extra extends Fragment {
    private static final String TAG = "Extra";
    ArrayList<EventList> eventLists=new ArrayList<>();
    String url="https://nevon.co.ke/stdportal/events/getAllevents.php";
    Eventservice eventservice;
    Boolean isBound=false;
    private  ServiceConnection serviceConnection;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serviceConnection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                MyBinder myBinder=(MyBinder)service;
                eventservice=myBinder.getServive();
                isBound=true;
                eventLists=eventservice.getlist();

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                isBound=false;

            }
        };

        Intent intent=new Intent(getContext(),Eventservice.class);
        getContext().bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE);
            }

    @Override
    public void onStart() {
        super.onStart();


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {






        View view=inflater.inflate(R.layout.eventrecyclerview, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclerview);
        EventAdapter eventAdapter=new EventAdapter(getContext(),eventLists);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(eventAdapter);

        // Inflate the layout for this fragment
        return  view;
    }



}
