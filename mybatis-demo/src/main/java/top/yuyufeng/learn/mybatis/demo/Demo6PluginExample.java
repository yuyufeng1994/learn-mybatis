package top.yuyufeng.learn.mybatis.demo;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.yuyufeng.learn.mybatis.entity.Blog;
import top.yuyufeng.learn.mybatis.mapper.BlogMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author yuyufeng
 * @date 2018/6/8.
 */
public class Demo6PluginExample {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis/conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //从 XML 中构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession(true);
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            int result = mapper.delete(25L);
            System.out.println("result: " + result);
        } finally {
            session.close();
        }
    }
}
