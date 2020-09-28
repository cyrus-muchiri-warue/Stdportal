package ke.co.nevon.stdportal;

import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONObject;

public class EventList  {
    private String date,venue,desc,title;

    public EventList(String date, String venue, String desc,String title) {
        this.date = date;
        this.venue = venue;
        this.desc = desc;
        this.title=title;
    }


    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    public String getDesc() {
        return desc;
    }

    public String getTitle() {
        return title;
    }
}
