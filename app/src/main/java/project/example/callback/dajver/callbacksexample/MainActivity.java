package project.example.callback.dajver.callbacksexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import project.example.callback.dajver.callbacksexample.adapter.ChannelsAdapter;
import project.example.callback.dajver.callbacksexample.rest.BackgroundTask;
import project.example.callback.dajver.callbacksexample.rest.di.ResponseCallback;
import project.example.callback.dajver.callbacksexample.rest.parser.model.ChannelsModel;

public class MainActivity extends AppCompatActivity implements ResponseCallback {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        new BackgroundTask(this).execute();
    }

    @Override
    public void response(ArrayList<ChannelsModel> response) {
        listView.setAdapter(new ChannelsAdapter(this, response));
    }
}
