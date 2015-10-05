package project.example.callback.dajver.callbacksexample.rest;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import project.example.callback.dajver.callbacksexample.rest.parser.model.ChannelsModel;
import project.example.callback.dajver.callbacksexample.rest.parser.ChannelsParser;
import project.example.callback.dajver.callbacksexample.rest.di.ResponseCallback;

/**
 * Created by Admin on 05.10.2015.
 */
public class BackgroundTask extends AsyncTask<ArrayList<ChannelsModel>, Void, ArrayList<ChannelsModel>> {

    private ResponseCallback callback;

    public BackgroundTask(ResponseCallback callback) {
        this.callback = callback;
    }

    @Override
    protected ArrayList<ChannelsModel> doInBackground(ArrayList<ChannelsModel>... params) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL("http://novaforen.com/reward/channels.json");
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ChannelsParser().parseData(content.toString());
    }

    @Override
    protected void onPostExecute(ArrayList<ChannelsModel> result) {
        callback.response(result);
    }
}