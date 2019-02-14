package fre.shown.tryit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Radon Freedom
 * created at 2019.02.12 19:16
 */

@Configuration
@Import(ServiceConfig.class)
public class RootConfig {
}
