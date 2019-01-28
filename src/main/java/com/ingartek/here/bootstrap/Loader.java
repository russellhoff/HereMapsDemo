package com.ingartek.here.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ingartek.here.auth.HereAuth;
import com.ingartek.here.client.HereClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Loader implements CommandLineRunner {

	@Autowired private HereAuth hereAuth;
	@Autowired private HereClient hereClient;
	
	@Override
	public void run(String... args) throws Exception {
//		Optional<String> accessTokenOpt = hereAuth.getAccessToken();
//		if(accessTokenOpt.isPresent())
//			log.debug("El Access Token es " + accessTokenOpt.get());
//		else
//			log.error("No se pudo obtener el Access Token.");
		hereClient.makeRequestGetFlowContent();
	}

}
