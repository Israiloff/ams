#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.${artifactId}.service;

import reactor.core.publisher.Mono;
import org.springframework.security.core.Authentication;
import ${package}.${artifactId}.model.UserCredentials;

public interface UserService {

    Mono<UserCredentials> getCredentials();
}
