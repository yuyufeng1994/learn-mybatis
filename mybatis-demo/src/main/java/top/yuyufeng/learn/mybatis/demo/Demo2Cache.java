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
public class Demo2Cache {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis/conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //从 XML 中构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog1 = mapper.selectBlog(1L);
            System.out.println("blog1:" + blog1);
            Blog blog2 = mapper.selectBlog(1L);
            System.out.println("blog2:" + blog2);
        } finally {
            session.close();
        }
    }
}
