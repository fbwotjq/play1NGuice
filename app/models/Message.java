package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by KAKAO on 2016. 10. 17..
 */
@Entity
public class Message extends Model {

    public String content;
    public Date createdDate;

}
