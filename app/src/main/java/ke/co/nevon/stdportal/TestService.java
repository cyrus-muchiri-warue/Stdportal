package ke.co.nevon.stdportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import  ke.co.nevon.stdportal.Eventservice.MyBinder;

import ke.co.nevon.stdportal.Eventservice.MyBinder;

public class TestService extends AppCompatActivity {
    private static final String TAG = "TestService";
    Eventservice eventservice;
    ArrayList<EventList> events=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_service);
        Intent intent=new Intent(TestService.this,Eventservice.class);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);

        Button button =findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                events=eventservice.getlist();
                int count=0;
                while(count<=events.size())
                {
                    Log.d(TAG, "onClick: "+events.get(count).getTitle());
                }


            }
        });



    }
    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBinder myBinder=(MyBinder) service;
            eventservice=myBinder.getServive();


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
