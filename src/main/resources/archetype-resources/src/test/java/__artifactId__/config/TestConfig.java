#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.config;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.ConnectionFactory;

import static ${package}.artemis.config.JmsConfig.CONNECTION_FACTORY;
import static ${package}.artemis.config.JmsConfig.MESSAGE_CONVERTER;
import static ${package}.artemis.config.JmsSubPubConfig.CONTAINER_FACTORY;

@Configuration
@ComponentScan(basePackages = {"${package}"})
public class TestConfig {
    @MockBean(name = CONTAINER_FACTORY)
    public JmsListenerContainerFactory<?> jmsListenerContainerFactory;

    @MockBean(name = CONNECTION_FACTORY)
    public ConnectionFactory getConnectionFactory;

    @MockBean(name = MESSAGE_CONVERTER)
    public MessageConverter jacksonJmsMessageConverter;
}
