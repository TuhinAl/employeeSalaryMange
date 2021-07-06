package com.ibcs.primax.jwt.filter;

import com.google.common.base.Strings;
import com.ibcs.primax.jwt.jwtService.CustomEmployeeDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author tuhin
 * @created_on 7/5/21 at 11:50 PM
 * @project primax
 **/

@Component
public class JwtTokenVerifierFilter extends OncePerRequestFilter {



    @Autowired
    CustomEmployeeDetailsService customEmployeeDetailsService;


    /**
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     * @Description Here extract the actual token into Algorithm, payload, and signature
     *   if token is valid
     */



    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authorizationHeader =  request.getHeader("Authorization");

        if (Strings.isNullOrEmpty(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        try {


            String token = authorizationHeader.replace("Bearer ", "");
            String secretKey = "ibcspromaxsoftwarecompanyinbangladesh";

            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                    .build().parseClaimsJws(token);


            Claims body = claimsJws.getBody();
            String username = body.getSubject();

            //  Collection<? extends GrantedAuthority> authorities = (Collection<? extends GrantedAuthority>) body.get("authorities");

            List<Map<String, String>> authorities = (List<Map<String, String>>) body.get("authorities");

            List<SimpleGrantedAuthority> simpleGrantedAuthorities = authorities.stream().map(
                    m -> new SimpleGrantedAuthority(m.get("authority"))).collect(Collectors.toList());

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    simpleGrantedAuthorities
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (JwtException e) {
            throw new IllegalStateException("This token cannot be trust");
        }

        filterChain.doFilter(request, response);


    }
}
