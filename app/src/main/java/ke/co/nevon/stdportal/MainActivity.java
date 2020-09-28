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



public class MainActivity extends AppCompatActivity {
Button signUpbtn,loginbtn;
Boolean isBound;
    private static final String TAG = "MainActivity";
    Eventservice eventservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUpbtn=findViewById(R.id.btnsignup);
        loginbtn=findViewById(R.id.login);

      signUp();
      login();
    }

    private void login() {
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),LoginPage.class);
                startActivity(i);

            }
        });
    }

    private void signUp() {
        signUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Signup.class);
                startActivity(intent);

            }
        });
    }

}
