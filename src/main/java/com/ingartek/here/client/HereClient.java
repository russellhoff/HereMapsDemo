package com.ingartek.here.client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.apache.http.entity.ContentType;

import com.ingartek.here.auth.HereAuth;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
//import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@Slf4j
public class HereClient implements Callback<ResponseBody> {

	private Retrofit retrofitMethods;
	private HereMethods service;
	private HereAuth hereAuth;
	
	private String auth;
		
	public HereClient(HereAuth pHereAuth, String pBaseUrl) {
		hereAuth = pHereAuth;
		
		Optional<String> accessTokenOpt = hereAuth.getAccessToken();
		if(accessTokenOpt.isPresent()) {
			String accessToken = accessTokenOpt.get();
			auth = "Bearer " + accessToken;
			log.debug("Access Token is: " + accessToken);
		}
		
		retrofitMethods = new Retrofit.Builder()
			    .baseUrl("https://data.traffic.api.here.com/")
			    .build();

		service = retrofitMethods.create(HereMethods.class);
	}
	
	public void getFlow() {
		Call<ResponseBody> ret = service.getFlow(auth);
		ret.enqueue(this);
	}
	
	public void getIncident() {
		Call<ResponseBody> ret = service.getIncident(auth);
		ret.enqueue(this);
	}

	@Override
	public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
		if(response.isSuccessful()) {
			ResponseBody rb = response.body();
			InputStream is = rb.byteStream();
			writeXmlFile(is);
			MediaType mt = rb.contentType();
			log.debug("Response OK (HTTP " + response.code() + "). MediaType: " + mt.toString());
		}else {
			try {
				log.error("Response unsuccessful (HTTP " + response.code() + "): " + response.errorBody().string());
			} catch (IOException e) {
				log.error("Error IOException", e);
			}
		}		
	}

	private void writeXmlFile(InputStream pIs) {
		String tmpFilePath = System.getProperty("java.io.tmpdir");
		File targetFile = new File(tmpFilePath + "target.xml");
	    try {
			FileUtils.copyInputStreamToFile(pIs, targetFile);
		} catch (IOException e) {
			log.error("Error IOException", e);
		}
	}

	@Override
	public void onFailure(Call<ResponseBody> call, Throwable t) {
		log.error("Failure.", t);
	}
	
}
