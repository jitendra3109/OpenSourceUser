package in.jsroyal.apiconsume.api;
import android.widget.Toast;

import in.jsroyal.apiconsume.model.ItemResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface Service {
    @GET("/search/users?q=location:india+language:java")
    Call<ItemResponse> getItems(
//            @Query("location") String location,
//            @Query("language") String language
    );
}
