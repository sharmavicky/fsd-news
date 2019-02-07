package com.cts.news.jwt.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cts.news.jwt.bean.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtValidator.class);

	private String secret = "news";

	public JwtUser validate(String token) {
		LOGGER.info("Start : JwtValidator");
		JwtUser jwtUser = null;
		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

			jwtUser = new JwtUser();

			jwtUser.setUserName(body.getSubject());
			jwtUser.setId(Long.parseLong((String) body.get("userId")));
			jwtUser.setRole((String) body.get("role"));
		} catch (Exception e) {
			System.out.println(e);
		}

		return jwtUser;
	}
}
