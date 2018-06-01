package top.yuyufeng.learn.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuyufeng
 * @date 2018/5/25.
 */
public class Blog implements Serializable{
    private Long blogId;
    private String blogTitle;
    private String blogContent;
    private Date createtime;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogContent='" + blogContent + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
