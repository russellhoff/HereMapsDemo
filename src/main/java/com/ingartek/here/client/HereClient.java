package com.ingartek.here.client;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@Slf4j
public class HereClient implements Callback<ResponseBody> {

	private TokenAuthenticator tokenAuthenticator;
	private Retrofit retrofitMethods;
	private HereMethods service;
	
	public HereClient(TokenAuthenticator pTokenAuthenticator) {
		tokenAuthenticator = pTokenAuthenticator;
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
				.authenticator(tokenAuthenticator)
				.build();
		
		retrofitMethods = new Retrofit.Builder()
			    .baseUrl("http://data.traffic.api.here.com/")
			    .client(okHttpClient)
			    .build();

		service = retrofitMethods.create(HereMethods.class);
	}
	
	public void makeRequestGetFlowContent() {
		Call<ResponseBody> ret = service.getIncident();// OR getFlow();
		ret.enqueue(this);
	}

	@Override
	public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
		if(response.isSuccessful()) {
			try {
				log.debug("Response OK: " + response.body()
				.string());
			} catch (IOException e) {
				log.error("Error IOException", e);
			}
		}else {
			try {
				log.error("Response unsuccessful: " + response.errorBody().string());
			} catch (IOException e) {
				log.error("Error IOException", e);
			}
		}		
	}

	@Override
	public void onFailure(Call<ResponseBody> call, Throwable t) {
		log.error("Failure.", t);
	}
	
}
