import models.Message;
import org.junit.Assert;
import org.junit.Test;
import play.test.FunctionalTest;

import java.util.Date;
import java.util.List;

/**
 * Created by KAKAO on 2016. 10. 17..
 */
public class MessageSpecTest extends FunctionalTest {

    @Test
    public void messageTest() {

        Message.deleteAll();

        Message message = new Message();
        message.content = "hello message";
        message.createdDate = new Date();
        message.save();

        Long messageId = message.id;
        Message messageClone = Message.findById(messageId);
        Assert.assertEquals(messageClone.content, "hello message");

        List<Message> messages =  Message.findAll();
        Assert.assertTrue(messages.size() > 0);


    }

}
