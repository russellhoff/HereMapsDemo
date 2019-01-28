package com.ingartek.here.client;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HereMethods {
	
	@GET("datex/2.3/flow/content.json")
	Call<ResponseBody> getFlow();
	
	@GET("datex/2.3/incident/content.json")
	Call<ResponseBody> getIncident();
	
}
