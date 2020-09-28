package ke.co.nevon.stdportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginPage extends AppCompatActivity {
    String url="https://nevon.co.ke/stdportal/signin/login.php";
    String reg,psw;
    public static final String MyPREFERENCES = "myprofile" ;
    Button btn;
    EditText regno,password;
        JSONObject jsonParams;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        btn=findViewById(R.id.submit);
        regno=findViewById(R.id.reg);
        password=findViewById(R.id.password);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });






    }

    private void request() {

        reg=regno.getText().toString().trim();
        psw=password.getText().toString().trim();
        Map<String,String>map=new HashMap<String,String>();
        map.put("reg",reg);
        map.put("password",psw);

     Customrequest cr=new Customrequest(Request.Method.POST, url, new Response.ErrorListener() {
         @Override
         public void onErrorResponse(VolleyError error) {
             Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

         }
     }, new Response.Listener<JSONObject>() {
         @Override
         public void onResponse(JSONObject response) {
             try {
                 int resultCode=response.getInt("resultCode");
                 switch (resultCode)
                 {
                     case 1:
                         Toast.makeText(getApplicationContext(),response.getString("responseDesc"),Toast.LENGTH_LONG).show();
                         Intent i=new Intent(getApplicationContext(), MenuOptions.class);
                         SharedPreferences registration=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                         SharedPreferences.Editor editor=registration.edit();
                         editor.putString("reg",reg);
                         editor.apply();

                         startActivity(i);
                         break;

                     case 400:
                         Toast.makeText(getApplicationContext(),response.getString("responseDesc"),Toast.LENGTH_LONG).show();
                         break;
                     case 11:
                         Toast.makeText(getApplicationContext(),response.getString("responseDesc"),Toast.LENGTH_LONG).show();
                         break;
                     case 500:
                         Toast.makeText(getApplicationContext(),response.getString("responseDesc"),Toast.LENGTH_LONG).show();
                         break;
                         default:
                             Toast.makeText(getApplicationContext(),"Unkown error",Toast.LENGTH_LONG).show();
                 }
             } catch (JSONException e) {
                 e.printStackTrace();
                 Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();


             }

         }
     },map);



        Mysigleton.getInstance(getApplicationContext()).addRequest(cr);

    }

}
