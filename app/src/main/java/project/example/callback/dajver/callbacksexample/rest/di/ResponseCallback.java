package project.example.callback.dajver.callbacksexample.rest.di;

import java.util.ArrayList;

import project.example.callback.dajver.callbacksexample.rest.parser.model.ChannelsModel;

/**
 * Created by Admin on 05.10.2015.
 */
public interface ResponseCallback {
    void response(ArrayList<ChannelsModel> response);
}
