package com.example.marvelcoding.mvvmviewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.marvelcoding.activity.EspressoIdelingResources;
import com.example.marvelcoding.api.MarvelApi;
import com.example.marvelcoding.pojo.Response;
import com.example.marvelcoding.ress.Resource;


import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MarvelViewModel extends ViewModel {

    private static final String TAG = "MarvelViewModel";
    private MarvelApi marvelApi;
    private MediatorLiveData<Resource<Response>> mediatorLiveData;


    @Inject
    public MarvelViewModel(MarvelApi marvelApi){
        this.marvelApi=marvelApi;
    }

    public LiveData<Resource<Response>> observeData(){
        if (mediatorLiveData==null){
            mediatorLiveData = new MediatorLiveData<>();
            mediatorLiveData.setValue(Resource.loading((Response)null));
            final LiveData<Resource<Response>> source= LiveDataReactiveStreams.fromPublisher(
                    marvelApi.getData()
                    .onErrorReturn(new Function<Throwable, Response>() {
                        @Override
                        public Response apply(Throwable throwable) throws Exception {
                            Response response= new Response();
                            response.setCheckId(-1);
                            return response;
                        }
                    })
                    .map(new Function<Response, Resource<Response>>() {
                        @Override
                        public Resource<Response> apply(Response response) throws Exception {
                            if (response.getCheckId()==-1){
                                return Resource.error("There is error",null);
                            }
                            else {
                                EspressoIdelingResources.countingIdelingResource.increment();
                                return Resource.success(response);
                            }
                        }
                    })
                    .subscribeOn(Schedulers.io())
            );
            mediatorLiveData.addSource(source, new Observer<Resource<Response>>() {
                @Override
                public void onChanged(Resource<Response> responseResource) {
                    mediatorLiveData.setValue(responseResource);
                    mediatorLiveData.removeSource(source);
                }
            });
        }
        return mediatorLiveData;
    }

}
