package com.sprint1;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -2550185165626007488L;

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	@Value("${jwt.secret}")
	private String secret;
	private String username;

	// retrieve username from jwt token
	public String getUsernameFromToken(String token) {
		System.out.println(token + "1");
		// System.out.println("getUsername"+);
		return this.username;
	}

	// retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		System.out.println("from getClaimFromToken displaying claims keyset" + claims.keySet() + "2");

		return claimsResolver.apply(claims);
	}

	// for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	// check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	// generate token for user
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	// while creating the token -
	// 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
	// 2. Sign the JWT using the HS512 algorithm and secret key.
	// 3. According to JWS Compact
	// Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	// compaction of the JWT to a URL-safe string
	private String doGenerateToken(Map<String, Object> claims, String subject) {

		/*
		 * String token = Jwt .withSubject((subject) .withExpiresAt(new
		 * Date(System.currentTimeMillis() +
		 * AuthenticationConfigConstants.EXPIRATION_TIME))
		 * .sign(Algorithm.HMAC512(AuthenticationConfigConstants.SECRET.getBytes()));
		 * response.addHeader(AuthenticationConfigConstants.HEADER_STRING,
		 * AuthenticationConfigConstants.TOKEN_PREFIX + token);
		 * 
		 * 
		 */
		this.username = subject;
		System.out.println(("this username subject" + this.username + " " + subject));

		@SuppressWarnings("deprecation")
		String token = Jwts.builder().claim("subject", subject).setIssuedAt(new Date())
				.setExpiration(new Date(2021, 12, 12)).signWith(SignatureAlgorithm.HS512, secret).compact();
		System.out.println(token.substring(1, 5) + "3");
		return token;

	}

	// validate token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		System.out.println("4" + username);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}

//import java.io.Serializable;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import java.util.function.Function;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//@Component
//public class JwtTokenUtil implements Serializable {
//
//	private static final long serialVersionUID = -2550185165626007488L;
//
//	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
//
//	@Value("${jwt.secret}")
//	private String secret;
//	private String userName;
//
//	// retrieve username from jwt token
//	public String getUsernameFromToken(String token) {
//		System.out.println(token + "1");
//		// System.out.println("getUsername"+);
//		return this.userName;
//	}
//
//	// retrieve expiration date from jwt token
//	public Date getExpirationDateFromToken(String token) {
//		return getClaimFromToken(token, Claims::getExpiration);
//	}
//
//	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//		final Claims claims = getAllClaimsFromToken(token);
//		System.out.println("from getClaimFromToken displaying claims keyset" + claims.keySet() + "2");
//
//		return claimsResolver.apply(claims);
//	}
//
//	// for retrieveing any information from token we will need the secret key
//	private Claims getAllClaimsFromToken(String token) {
//		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//	}
//
//	// check if the token has expired
//	private Boolean isTokenExpired(String token) {
//		final Date expiration = getExpirationDateFromToken(token);
//		return expiration.before(new Date());
//	}
//
//	// generate token for user
//	public String generateToken(UserDetails userDetails) {
//		Map<String, Object> claims = new HashMap<>();
//		return doGenerateToken(claims, userDetails.getUsername());
//	}
//
//	// while creating the token -
//	// 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
//	// 2. Sign the JWT using the HS512 algorithm and secret key.
//	// 3. According to JWS Compact
//	// Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
//	// compaction of the JWT to a URL-safe string
//	private String doGenerateToken(Map<String, Object> claims, String subject) {
//
//		/*
//		 * String token = Jwt .withSubject((subject) .withExpiresAt(new
//		 * Date(System.currentTimeMillis() +
//		 * AuthenticationConfigConstants.EXPIRATION_TIME))
//		 * .sign(Algorithm.HMAC512(AuthenticationConfigConstants.SECRET.getBytes()));
//		 * response.addHeader(AuthenticationConfigConstants.HEADER_STRING,
//		 * AuthenticationConfigConstants.TOKEN_PREFIX + token);
//		 * 
//		 * 
//		 */
//		this.userName = subject;
//		System.out.println(("this username subject" + this.userName + " " + subject));
//
//		String token = Jwts.builder().claim("subject", subject).setIssuedAt(new Date())
//				.setExpiration(new Date(2021, 12, 12)).signWith(SignatureAlgorithm.HS512, secret).compact();
//		System.out.println(token.substring(1, 5) + "3");
//		return token;
//
//	}
//
//	// validate token
//	public Boolean validateToken(String token, UserDetails userDetails) {
//		final String username = getUsernameFromToken(token);
//		System.out.println("4" + username);
//		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//	}
//}