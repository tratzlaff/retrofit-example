package com.tratzlaff.example.retrofit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repo {
    public int id;
    public String name;
    public String full_name;
    public String url;
    public String html_url;

    @Override
    public String toString() {
        return full_name;
    }
}
