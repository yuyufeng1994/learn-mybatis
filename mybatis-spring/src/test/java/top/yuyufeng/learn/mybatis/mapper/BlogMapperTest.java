package top.yuyufeng.learn.mybatis.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.yuyufeng.learn.mybatis.entity.Blog;

import static org.junit.Assert.*;

/**
 * @author yuyufeng
 * @date 2018/6/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class BlogMapperTest {
    @Autowired
    private BlogMapper blogMapper;

    @Test
    public void selectBlog() throws Exception {
        Blog blog = blogMapper.selectBlog(1L);
        System.out.println(blog);
    }

    @Test
    public void selectBlogByBlogId() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertBatch() throws Exception {
    }

    @Test
    public void list() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}