package ke.co.nevon.stdportal;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ke.co.nevon.stdportal.EventList;

public class Eventservice extends Service{
    JSONArray response;
    JsonArrayRequest jsonArrayRequest;

    private static final String TAG = "Eventservice";
    private  final IBinder iBinder=new MyBinder();

    public Eventservice() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }
    
    //
    class MyBinder extends Binder{
        Eventservice getServive(){
            return Eventservice.this;
        }


    }

    public ArrayList<EventList> getlist(){
        final ArrayList<EventList> arrayList=new ArrayList<>();
        String url="https://nevon.co.ke/stdportal/events/getAllevents.php";

        jsonArrayRequest=new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int count=0;
                while (count<response.length())
                {
                    try {
                        JSONObject jsonObject =response.getJSONObject(count);
                        EventList eventDetails=new EventList(
                                jsonObject.getString("date"),
                                jsonObject.getString("venue"),
                                jsonObject.getString("eventdescription"),
                                jsonObject.getString("eventtittle")
                        );

                       arrayList.add(eventDetails);
                        Log.d(TAG, "onResponse: "+arrayList.get(count).getTitle());

                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                    count++;




                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });


        RequestQueue rq= Volley.newRequestQueue(Eventservice.this);
        rq.add(jsonArrayRequest);


        return arrayList;


    }

}
