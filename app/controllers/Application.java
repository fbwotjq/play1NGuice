package controllers;

import models.Message;
import models.PostTarget;
import play.*;
import play.db.jpa.NoTransaction;
import play.mvc.*;
import service.MessageService;

import javax.inject.Inject;
import java.util.*;


public class Application extends Controller {

    @Inject static MessageService messageService;

    public static void index() {
        render();
    }

    public static void app() {

        System.out.println(messageService.getMessage());
        String aa = "aa";
        switch (aa) {
            case "aa":
                break;
            case "bb":
                break;
        }
        render();

    }

    public static void addPost(PostTarget post) {
        Logger.info(String.format("content:%s, date:%s, userId:%s", post.content, post.dateCreated, post.userId));
        messageService.addPost(post);
        ok();
    }

    @NoTransaction
    public static void addPostNoTransaction() {
        //Logger.info(String.format("content:%s, date:%s, userId:%s", post.content, post.dateCreated, post.userId));
        messageService.addPostNoTransactionA();
        ok();
    }

    public static void modifyPost(PostTarget post) {
        messageService.addPost(post);
        ok();
    }

    public static void addMessage(Message message) {
        messageService.addMessage(message);
        ok();
    }

}