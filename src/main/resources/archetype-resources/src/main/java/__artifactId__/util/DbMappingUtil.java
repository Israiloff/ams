#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.${artifactId}.util;

import io.r2dbc.spi.Row;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DbMappingUtil {

    @SneakyThrows
    public <TParam> TParam getRowParam(String paramName, Row row, Class<TParam> paramClass,
                                       Class<? extends Throwable> errorClass) {
        log.debug("getParam started for parameter : {}", paramName);

        if (row.get(paramName) == null) {
            log.error("parameter not found : {}", paramName);
            if (errorClass == null) {
                log.warn("error type not defined. null value will be returned");
                return null;
            }
            throw errorClass.getConstructor().newInstance();
        }

        return row.get(paramName, paramClass);
    }
}
