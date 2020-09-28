package ke.co.nevon.stdportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    Button submit;
    EditText user,program,year,regno,nationid,contact,email,password1,password2;
    String url="https://nevon.co.ke/stdportal/signup/signup.php";

    String id,name,pro,yr,reg,nId,cont,mail,psw1,psw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        user=findViewById(R.id.user);
        program=findViewById(R.id.program);
        year=findViewById(R.id.year);
        regno=findViewById(R.id.regno);
        nationid=findViewById(R.id.nationalid);
        contact=findViewById(R.id.contact);
        email=findViewById(R.id.email);
        password1=findViewById(R.id.password1);
        password2=findViewById(R.id.password2);
        submit=findViewById(R.id.btnSubmit);




         submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });


    }

    private void signup() {
        StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String, String>();
                id="";
                name=user.getText().toString().trim();
                pro=program.getText().toString().trim();
                yr=year.getText().toString().trim();
                reg=regno.getText().toString().trim();
                nId=nationid.getText().toString().trim();
                cont=contact.getText().toString().trim();
                mail=email.getText().toString().trim();
                psw1=password1.getText().toString().trim();
                psw2=password2.getText().toString().trim();

                    params.put("id",id);
                    params.put("user", name);
                    params.put("pro", pro);
                    params.put("yr", yr);
                    params.put("reg",reg);
                    params.put("nId",nId);
                    params.put("cont",cont);
                    params.put("email", mail);
                    params.put("password1",psw1);
                    params.put("password2",psw2);
                return params;
            }
        };


        Mysigleton.getInstance(getApplicationContext()).addRequest(sr);

    }
}
