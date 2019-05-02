package com.example.mapapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AmbilJarak {

    public String GetRoutDistance(double startLat, double startLong, double endLat, double endLong)
    {
        String Distance = "error";
        String Status = "error";
        try {
            Log.e("Distance Link : ", "http://maps.googleapis.com/maps/api/directions/json?origin="+ startLat +","+ startLong +"&destination="+ endLat +","+ endLong +"&sensor=false");
            JSONObject jsonObj = Parser_Json.getJSONfromURL("https://maps.googleapis.com/maps/api/directions/json?origin="+ startLat +","+ startLong +"&destination="+ endLat +","+ endLong +"&sensor=false&key=AIzaSyAR2PpsDHW0Zg4l_oBG_zSxfDOi_ILw070");
            Status = jsonObj.getString("status");
            //Log.e("Status", Status);
            if(Status.equalsIgnoreCase("OK"))
            {
                JSONArray routes = jsonObj.getJSONArray("routes");
                JSONObject zero = routes.getJSONObject(0);
                JSONArray legs = zero.getJSONArray("legs");
                JSONObject zero2 = legs.getJSONObject(0);
                JSONObject dist = zero2.getJSONObject("distance");
                Distance = dist.getString("text");
            }
            else
            {
                Distance = "Too Far";
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Distance;
    }

}
