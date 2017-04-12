package in.jsroyal.apiconsume.api;
import in.jsroyal.apiconsume.model.ItemResponse;
import retrofit2.Call;
import retrofit2.http.GET;


public interface Service {
    @GET("/search/users?q=language:java+location:india")
    Call<ItemResponse> getItems();
}
