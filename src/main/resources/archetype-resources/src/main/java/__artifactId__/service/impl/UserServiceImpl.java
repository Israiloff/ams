#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.${artifactId}.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import ${package}.${artifactId}.model.UserCredentials;
import ${package}.${artifactId}.service.UserService;
import ${package}.${artifactId}.error.UserAuthenticationException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @SneakyThrows
    public UserCredentials getUserCredentials(Authentication authentication) {
        log.debug("getUserCredentials started");

        if (authentication != null && authentication.getPrincipal() instanceof Jwt) {
            log.trace("oauth principle type : {}", authentication.getPrincipal().getClass());

            var principal = (Jwt) authentication.getPrincipal();
            log.trace("claims : {}", principal.getClaims());

            return UserCredentials.of(principal.getClaimAsString("preferred_username"), principal.getClaims());
        } else {
            log.error("error occurred on user credentials get operation");
            throw new UserAuthenticationException();
        }
    }
}
