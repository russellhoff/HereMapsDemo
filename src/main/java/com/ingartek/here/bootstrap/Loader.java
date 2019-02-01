package com.ingartek.here.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;

import com.ingartek.here.client.HereClient;

@Component
public class Loader implements CommandLineRunner {

	@Autowired private HereClient hereClient;
	
	@Override
	public void run(String... args) throws Exception {
		hereClient.getFlow();
		hereClient.getIncident();
	}

}
