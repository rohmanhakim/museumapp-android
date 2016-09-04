package io.github.rohmanhakim.museumapp.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 9/4/16 14:24.
 */
public class GetMuseumByLatLongResponse {
    @SerializedName("data")
    public List<Data> data = new ArrayList<Data>();
}
