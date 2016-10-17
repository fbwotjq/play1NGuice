import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import config.InjectionConfig;
import config.InjectionModule;
import models.Message;
import models.PostTarget;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import play.db.jpa.JPA;
import play.db.jpa.JPAPlugin;
import play.test.FunctionalTest;
import service.MessageService;
import service.MessageServiceImpl;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by KAKAO on 2016. 10. 17..
 */
public class MessageServiceSpecTest extends FunctionalTest {

    protected Injector injector = Guice.createInjector(new InjectionModule());

    @Before
    public void setup () {
        injector.injectMembers(this);
    }

    @Inject MessageService messageService;

    @Test
    public void addPostTargetTest() {

        PostTarget postTarget = new PostTarget();
        postTarget.version = 1;
        postTarget.dateCreated = new Date();
        postTarget.id = 2039481;

        messageService.addPost(postTarget);
        postTarget.delete();

    }

    @Test
    public void addPostTargetTestNoA() {

        messageService.addPostNoTransactionA();

    }

    @Test
    public void addMessageTest() {

        Message message = new Message();
        message.content = "1hello message";
        message.createdDate = new Date();
        messageService.addMessage(message);
        message.delete();

    }

}