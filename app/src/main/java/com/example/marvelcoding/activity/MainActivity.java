package com.example.marvelcoding.activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;

import com.example.marvelcoding.R;
import com.example.marvelcoding.database.PlayerDatabse;
import com.example.marvelcoding.database.PlayerEntity;
import com.example.marvelcoding.database.PlayerViewModel;
import com.example.marvelcoding.factory.ViewModelProviderFactory;
import com.example.marvelcoding.mvvmviewmodel.MarvelViewModel;
import com.example.marvelcoding.pojo.Response;
import com.example.marvelcoding.pojo.Results;
import com.example.marvelcoding.pojo.Thumbnail;
import com.example.marvelcoding.recyclerview.PlayerRecyclerAdapter;
import com.example.marvelcoding.ress.Resource;
import java.util.List;
import javax.inject.Inject;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    //statics
    private static final String TAG = "MainActivity";
   //Injected classes
    @Inject
    ViewModelProviderFactory providerFactory;
    @Inject
    PlayerRecyclerAdapter adapter;


    //Non Injected Classes
    private MarvelViewModel viewModel;
    private RecyclerView recyclerView;
    private PlayerViewModel playerViewModel;
    private PlayerDatabse playerDatabse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerDatabse = PlayerDatabse.getInstance(getApplicationContext());
        //Recycler view Init
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //ApiView Model
        viewModel = ViewModelProviders.of(this,providerFactory).get(MarvelViewModel.class);
        subscribeObserver();

        //Database View Model
        playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);


    }
    public void subscribeObserver(){
        viewModel.observeData().observe(this, new Observer<Resource<Response>>() {
            @Override
            public void onChanged(Resource<Response> responseResource) {
                if (responseResource!=null){
                    switch (responseResource.status){
                        case LOADING:
                            Toast.makeText(MainActivity.this, "Data is loading", Toast.LENGTH_SHORT).show();
                            break;
                        case SUCCESS:
                            List<Results> resultsList = responseResource.data.getData().getResults();
                            updateRecyclerView(resultsList);
                            insertDataInDB(resultsList);
                            break;
                        case ERROR:
                            Toast.makeText(MainActivity.this, "You are offline Data Loaded From DataBase", Toast.LENGTH_SHORT).show();
                            observingDataFromDataBase();
                            break;
                    }
                }
            }
        });
    }

    public void insertDataInDB(List<Results> resultsList){
        if (resultsList.size()>0) {
            for (Results results : resultsList) {
                Thumbnail thumbnail = results.getThumbnail();
                String url =thumbnail.getPath()+"."+thumbnail.getExtension();
                PlayerEntity playerEntity= new PlayerEntity(results.getId(),results.getName(),url,results.getDescription());
                //insert into database
                playerViewModel.insert(playerEntity);
            }
        }

    }

    public void observingDataFromDataBase(){
            playerViewModel.observerPlayers().observe(this, new Observer<List<PlayerEntity>>() {
                @Override
                public void onChanged(List<PlayerEntity> playerEntities) {
                    updateOfflineRecyclerView(playerEntities);
                }
            });
    }

    public void updateOfflineRecyclerView(List<PlayerEntity> playerEntities){
        adapter.setPlayersEntity(playerEntities);
        recyclerView.setAdapter(adapter);
    }


    public void updateRecyclerView(List<Results> resultsList){
        adapter.setList(resultsList);
        EspressoIdelingResources.countingIdelingResource.decrement();
        recyclerView.setAdapter(adapter);
    }
}
