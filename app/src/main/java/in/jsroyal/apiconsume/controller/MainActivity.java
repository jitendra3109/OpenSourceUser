package in.jsroyal.apiconsume.controller;

import android.app.ProgressDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import in.jsroyal.apiconsume.ItemAdapter;
import in.jsroyal.apiconsume.R;
import in.jsroyal.apiconsume.api.Client;
import in.jsroyal.apiconsume.api.Service;
import in.jsroyal.apiconsume.model.Item;
import in.jsroyal.apiconsume.model.ItemResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    TextView Disconnected;
    private Item item;
    ProgressDialog pd;
    private SwipeRefreshLayout swipeContainer;
    public String location,language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        location = extras.getString("location");
        language = extras.getString("language");
        Log.d("location",location );
        Log.d("lan",location );


        initViews();

        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);

        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(){
                loadJSON();
                Toast.makeText(MainActivity.this, "Wait refresh", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initViews(){
        pd = new ProgressDialog(this);
        pd.setMessage("Fetching Users Data Please wait...");
        pd.setCancelable(false);
        pd.show();
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);
        loadJSON();
        Log.d("Error", "Call load json");
    }

    private void loadJSON(){
        Disconnected = (TextView) findViewById(R.id.disconnected);
        try{
            Client Client = new Client();
            Service apiService =
                    Client.getClient().create(Service.class);
            Call<ItemResponse> call = apiService.getItems(location,language);
            call.enqueue(new Callback<ItemResponse>() {
                @Override
                public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                    Log.d("Response",""+""+response.body());
                    List<Item> items = response.body().getItems();
                    recyclerView.setAdapter(new ItemAdapter(getApplicationContext(), items));
                    recyclerView.smoothScrollToPosition(0);
                    swipeContainer.setRefreshing(false);
                    pd.hide();
                }
                @Override
                public void onFailure(Call<ItemResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(MainActivity.this, "Error Fetching Data!", Toast.LENGTH_LONG).show();
                    Disconnected.setVisibility(View.VISIBLE);
                    pd.hide();
                }
            });

        }catch (Exception e){
            Log.d("Error exception", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
