package service;

import models.Message;
import models.PostTarget;
import play.db.jpa.JPAPlugin;
import util.JpaUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by KAKAO on 2016. 10. 13..
 */
public class MessageServiceImpl implements MessageService {

    @Override
    public String getMessage() {
        return "this is message";
    }

    @Override
    public void addPost(PostTarget post) {
        post.save();
    }

    @Override
    public void modifyPost(PostTarget post) {
        if(PostTarget.findById(post) == null)
            post.save();
    }

    @Override
    public void removePost(PostTarget post) {
        if(PostTarget.findById(post) == null)
            post.delete();
    }

    @Override
    public PostTarget getPost(int id) {
        return PostTarget.findById(id);
    }

    @Override
    public List<PostTarget> getPostList() {
        return PostTarget.findAll();
    }

    @Override
    public void addPostNoTransaction(PostTarget post) {

        /*play.Play.plugin(JPAPlugin.class).startTx(true);
        post.save();
        play.Play.plugin(JPAPlugin.class).closeTx(false);*/
        try {
            post.saveTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPostNoTransactionA() {
        PostTarget postTarget = new PostTarget();
        postTarget.id = 1000101;
        postTarget.content = "sdfds";
        postTarget.dateCreated = new Date();
        try {
            postTarget.saveTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMessage(Message message) {
        message.save();
    }

}