package in.jsroyal.apiconsume.api;
import android.widget.Toast;

import in.jsroyal.apiconsume.model.ItemResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface Service {
    @GET("/search/users")
    Call<ItemResponse> getItems(
            @Query("q") String location,
            @Query("q") String language
    );
}
