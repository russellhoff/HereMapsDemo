package com.ingartek.here.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.here.account.oauth2.AccessTokenResponse;
import com.here.account.oauth2.HereAccessTokenProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HereAuth {

	@Autowired private HereAccessTokenProvider tokenProvider;
	
	public Optional<String> getAccessToken() {
		try {
			String accessToken = tokenProvider.getAccessToken();
			AccessTokenResponse resp = tokenProvider.getAccessTokenResponse();
			log.debug("AccessToken [" + resp.getAccessToken() + "] " +
					"IdToken [" + resp.getIdToken() + "] " +
					"RefreshToken [" + resp.getRefreshToken() + "] " +
					"TokenType [" + resp.getTokenType() + "] " +
					"ExpiresIn [" + resp.getExpiresIn() + "] " +
					"StartTimeMilliseconds [" + resp.getStartTimeMilliseconds() + "] "
			);
			return Optional.ofNullable(accessToken);
		}catch(Exception e) {
			log.error("Error " + e.getClass(), e);
			return Optional.empty();
		}
	}
	
}
