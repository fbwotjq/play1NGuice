package config;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import service.MessageService;
import service.MessageServiceImpl;
import support.GuiceSupport;

/**
 * Created by fbwotjq on 2016. 10. 13..
 */
public class InjectionConfig extends GuiceSupport {

    protected Injector configure() {
        return Guice.createInjector(new InjectionModule());
    }

}