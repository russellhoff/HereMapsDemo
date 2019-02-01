package com.ingartek.here.config;

import java.io.File;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;

import com.here.account.auth.OAuth1ClientCredentialsProvider;
import com.here.account.oauth2.HereAccessTokenProvider;
import com.ingartek.here.auth.HereAuth;
import com.ingartek.here.client.HereClient;
import com.ingartek.here.helper.ResourceFileLoader;

@Configuration
public class HereConfig {

	@Autowired private ResourceFileLoader resFileLoader;
	@Value("${base.url}") private String baseUrl;
	
	@Bean
	public OAuth1ClientCredentialsProvider getOAuth1ClientCredentialsProvider() throws Exception {
		Optional<File> fileOpt = resFileLoader.getFileFromResources("IngartekConsulting.properties");
		if(fileOpt.isPresent()) {
			File f = fileOpt.get();
			return new OAuth1ClientCredentialsProvider.FromFile(f);
		}else
			throw new Exception("No se pudo crear un proveedor de credenciales para Here Maps.");
		
	}
	
	@Bean
	public HereAccessTokenProvider getHereAccessTokenProvider(OAuth1ClientCredentialsProvider pOAuth1ClientCredentialsProvider) {
		return HereAccessTokenProvider
				.builder()
				.setClientAuthorizationRequestProvider(pOAuth1ClientCredentialsProvider)
				.build();
	}
	
	@Bean
	public HereClient getHereClient(HereAuth pHereAuth) {
		return new HereClient(pHereAuth, baseUrl);
	}
	
}
