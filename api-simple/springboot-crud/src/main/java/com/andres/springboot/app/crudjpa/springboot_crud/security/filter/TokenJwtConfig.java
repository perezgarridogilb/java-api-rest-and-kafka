package com.andres.springboot.app.crudjpa.springboot_crud.security.filter;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;

public class TokenJwtConfig {
    public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
        public static final String PREFIX_TOKEN = "Bearer " ;
                public static final String HEADER_AUTHORIZATION = "Authorization" ;

}
