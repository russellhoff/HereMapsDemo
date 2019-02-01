package com.ingartek.here.client;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface HereMethods {
	
	@GET("datex/2.3/flow/content.xml")
	Call<ResponseBody> getFlow(@Header("Authorization") String pAuthorization);
	
	@GET("datex/2.3/incident/content.xml")
	Call<ResponseBody> getIncident(@Header("Authorization") String pAuthorization);
	
}
