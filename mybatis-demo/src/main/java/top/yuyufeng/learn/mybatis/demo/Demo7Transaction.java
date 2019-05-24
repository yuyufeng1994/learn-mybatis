package top.yuyufeng.learn.mybatis.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.yuyufeng.learn.mybatis.entity.Blog;
import top.yuyufeng.learn.mybatis.mapper.BlogMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yuyufeng
 * @date 2018/6/8.
 */
public class Demo7Transaction {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis/conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //从 XML 中构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession(false);

        Blog blog = new Blog();
        blog.setBlogTitle("这是标题1");
        blog.setBlogContent("这是内容2");
        blog.setCreateTime(new Date());

        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            mapper.insert(blog);
            mapper.insert(blog);
            session.commit();
        }catch (Exception e){
            //手动回滚
            session.rollback();
        }finally {
            session.close();
        }
    }


}
