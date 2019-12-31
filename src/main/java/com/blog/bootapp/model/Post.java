
package com.blog.bootapp.model;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@Proxy(lazy=false)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;

    private String title;

    @Column(columnDefinition = "text")
    private String content;

    @Column(name= "author_id")
    private long authorId;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "post_category", joinColumns = {@JoinColumn(name="post_id")}, inverseJoinColumns = {@JoinColumn(name="category_id")})
    List<Category> categoryList = new ArrayList<Category>();

    public Post() {
        super();
    }

    public long getAuthorId() {
        return authorId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id",referencedColumnName="author_id", insertable=false, updatable=false)
    private User user;

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getId() {
        return Id;
    }

    public void setId(long postId) {
        this.Id = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "Post{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", authorId=" + authorId +
                ", categoryList=" + categoryList +
                ", user=" + user +
                '}';
    }
}



