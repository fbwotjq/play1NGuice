package service;

import models.Message;
import models.PostTarget;

import java.util.List;

/**
 * Created by fbwotjq on 2016. 10. 13..
 */
public interface MessageService {

    public String getMessage();

    public void addPost(PostTarget post);

    public void modifyPost(PostTarget post);

    public void removePost(PostTarget post);

    public PostTarget getPost(int id);

    public List<PostTarget> getPostList();

    public void addPostNoTransaction(PostTarget post);

    public void addPostNoTransactionA();

    public void addMessage(Message message);

}
