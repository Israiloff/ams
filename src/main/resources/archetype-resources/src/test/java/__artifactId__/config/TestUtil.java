#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestUtil {

    public <TEntity> void clearDB(ReactiveCrudRepository<TEntity, Long> repository) {
        log.debug("clearDB started for : {}", repository.getClass());
        repository.deleteAll().block();
    }
}
