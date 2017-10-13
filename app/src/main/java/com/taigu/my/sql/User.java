package com.taigu.my.sql;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/10/13 0013.
 */
@Entity
public class User {
    @Id
    private Long id;
    private String title;
    private String image;
    @Generated(hash = 19117769)
    public User(Long id, String title, String image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }

}
