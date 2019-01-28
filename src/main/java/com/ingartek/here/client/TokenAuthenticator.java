package com.ingartek.here.client;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ingartek.here.auth.HereAuth;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

@Component
public class TokenAuthenticator implements Authenticator {

	@Autowired private HereAuth hereAuth;
	
	@Override
	public Request authenticate(Route route, Response response) throws IOException {
		Optional<String> accessTokenOpt = hereAuth.getAccessToken();
		if(accessTokenOpt.isPresent()) {
			String accessToken = accessTokenOpt.get();
			return response.request().newBuilder()
						.header("Authorization", "Bearer " + accessToken)
						.build();
		}
		
		return null;
	}

}
