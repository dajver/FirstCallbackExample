package project.example.callback.dajver.callbacksexample.rest.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import project.example.callback.dajver.callbacksexample.rest.parser.model.ChannelsModel;

/**
 * Created by Admin on 05.10.2015.
 */
public class ChannelsParser {

    public ArrayList<ChannelsModel> parseData(String response) {
        ArrayList<ChannelsModel> model = new ArrayList<>();
        try {
            JSONObject json = new JSONObject(new String(response));
            JSONArray channels = json.getJSONArray("channels");
            for(int i = 0; i < channels.length(); i++) {
                ChannelsModel gru = new ChannelsModel();
                JSONObject data = channels.getJSONObject(i);
                String name = data.getString("name");
                gru.setName(name);
                model.add(gru);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return model;
    }
}
