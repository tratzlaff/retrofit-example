package com.tratzlaff.example.retrofit;

import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.GET;

import java.util.List;

public interface GitHubService {

    /**
     * https://developer.github.com/v3/repos/#list-user-repositories
     */
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

}
