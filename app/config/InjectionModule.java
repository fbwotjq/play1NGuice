package config;

import com.google.inject.AbstractModule;
import service.MessageService;
import service.MessageServiceImpl;

/**
 * Created by KAKAO on 2016. 10. 17..
 */
public class InjectionModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MessageService.class).to(MessageServiceImpl.class);
    }

}