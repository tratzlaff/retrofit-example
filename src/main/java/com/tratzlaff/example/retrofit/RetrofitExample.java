package com.tratzlaff.example.retrofit;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

public class RetrofitExample {

    public static void main(String[] args) throws IOException {
        new RetrofitExample();
    }

    /**
     * http://square.github.io/retrofit/
     */
    private RetrofitExample() throws IOException {
        GitHubService service = generateGitHubServiceImplementation();

        // Each Call from the created service can make a synchronous or asynchronous HTTP request to the remote server.
        // Each instance can only be used once, but calling clone() will create a new instance that can be used.
        Call<List<Repo>> repos = service.listRepos("octocat");

        Response<List<Repo>> response = repos.execute();
        List<Repo> body = response.body();

        body.forEach(System.out::println);
        //Same as... body.forEach( repo -> { System.out.println(repo); } );
    }

    private GitHubService generateGitHubServiceImplementation() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                // By default, Retrofit can only deserialize HTTP bodies into OkHttp's ResponseBody type.
                // Converters can be added to support other types.
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        // The returned implementation of the GitHubService interface will use Jackson for its deserialization.
        return retrofit.create(GitHubService.class);
    }
}
