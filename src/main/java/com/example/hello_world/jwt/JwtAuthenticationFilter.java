package com.example.hello_world.jwt;
import com.example.hello_world.entity.AccessToken;
import com.example.hello_world.exception.BaseException;
import com.example.hello_world.exception.ErrorMessage;
import com.example.hello_world.exception.MessageType;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private IJwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      /*String header;
        request.getHeader("Authorization");
        header = request.getHeader("Authorization");

       if(header==null) {
            filterChain.doFilter(request, response);
            return;
        }
        token = header.substring(7);
        try{
            String usernameByToken = jwtService.getUsernameByToken(token);
            if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if(userDetails!=null&& jwtService.isTokenExpired(token)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (ExpiredJwtException e) {
            System.out.println("Token is expired: " + e.getMessage());
        } catch (Exception e) {
            system.out.println("Genel hata");
        }
        filterChain.doFilter(request, response);}
*/
        String token;
        String username;
        token = getTokenFromRequest(request);

        try{
            if (token != null) {

                AccessToken accessToken = jwtService.findByAccessToken(token);

                if(accessToken != null) {
                    if(accessToken.isActive()){

                        username = jwtService.getUsernameByToken(token);

                        if(StringUtils.isNotEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null) {

                            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                            if(userDetails != null && jwtService.isTokenValid(token, userDetails.getUsername())) {

                                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                                SecurityContextHolder.getContext().setAuthentication(authentication);
                            }
                        }
                    }
                }
            }
        }catch (ExpiredJwtException e){
            throw new BaseException(new ErrorMessage(MessageType.TOKEN_IS_EXPIRED, e.getMessage()));
        }catch (Exception e){
            throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION, e.getMessage()));
        }
        filterChain.doFilter(request, response); //continue process
    }

    private String getTokenFromRequest(HttpServletRequest request) {

        String bearerToken = request.getHeader("Authorization");

        if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
