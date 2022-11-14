#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.${artifactId}.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ${package}.${artifactId}.model.UserCredentials;
import ${package}.${artifactId}.service.Api;
import ${package}.${artifactId}.service.UserService;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiImpl implements Api {

    private final UserService userService;

    @Override
    public Mono<UserCredentials> getUserCredentials(String data) {
        log.info("sampleMethod started for : {}", data);
        return userService.getCredentials();
    }
}
