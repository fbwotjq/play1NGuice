package models;

import play.db.jpa.GenericModel;
import play.db.jpa.Model;
import util.JpaUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by KAKAO on 2016. 10. 15..
 */
@Entity
public class PostTarget extends GenericModel {

    @Id
    public int id;
    public int version;
    public String content;
    @Column(name="date_created")
    public Date dateCreated;
    @Column(name="user_id")
    public String userId;

    public PostTarget() {

    }

    public PostTarget(int id, int version, String content, String userId) {
        this.id = id;
        this.version = version;
        this.content = content;
        this.userId = userId;
    }

    public static void put() {

        PostTarget postTarget = new PostTarget(1000, 1, "putInner", "fbwotjq");
        postTarget.content = "sdfds";
        postTarget.dateCreated = new Date();
        try {
            postTarget.saveTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PostTarget saveTransaction() throws Exception {

        final PostTarget postTarget = this;

        return JpaUtil.declareTrasaction(new JpaUtil.TxContext<PostTarget>() {
            @Override
            public PostTarget handle() {
                return postTarget.save();
            }
        });

    }
}
