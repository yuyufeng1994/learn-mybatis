package top.yuyufeng.learn.mybatis.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.yuyufeng.learn.mybatis.entity.Blog;
import top.yuyufeng.learn.mybatis.mapper.BlogMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yuyufeng
 * @date 2018/5/25.
 */
public class Demo3CacheSecond {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis/conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session1 = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper1 = session1.getMapper(BlogMapper.class);
            Blog blog1 = mapper1.selectBlog(1L);
            System.out.println("blog1:" + blog1);
            session1.commit();
        } finally {
            session1.close();
        }

        SqlSession session2 = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper2 = session2.getMapper(BlogMapper.class);
            Blog blog2 = mapper2.selectBlog(1L);
            System.out.println("blog2:" + blog2);
            session2.commit();
        } finally {
            session2.close();
        }
    }
}
