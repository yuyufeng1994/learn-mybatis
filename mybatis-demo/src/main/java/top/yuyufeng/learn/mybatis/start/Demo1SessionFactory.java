package top.yuyufeng.learn.mybatis.start;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.yuyufeng.learn.mybatis.entity.Blog;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yuyufeng
 * @date 2018/5/25.
 */
public class Demo1SessionFactory {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis/conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Blog blog = session.selectOne("top.yuyufeng.learn.mybatis.mapper.BlogMapper.selectBlog", 1L);
            System.out.println(blog);
        } finally {
            session.close();
        }
    }
}
