package ke.co.nevon.stdportal;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Mysigleton {
    private static Context context;
    private RequestQueue rq;
    private static Mysigleton mysigleton;

    public Mysigleton(Context context) {
       this.context=context;
       rq=getRequestQueue();

    }
    public  RequestQueue getRequestQueue(){
        if(rq==null)
        {
            rq= Volley.newRequestQueue(context.getApplicationContext());
        }
        return rq;
    }
    public static synchronized Mysigleton getInstance(Context context){
        if (mysigleton==null)
        {
            mysigleton=new Mysigleton(context);
        }
        return mysigleton;
    }
    public<T> void addRequest(Request<T> request){
        rq.add(request);
    }


}
