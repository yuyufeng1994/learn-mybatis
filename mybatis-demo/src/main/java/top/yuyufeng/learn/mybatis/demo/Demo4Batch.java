package top.yuyufeng.learn.mybatis.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
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
 * @date 2018/5/25.
 */
public class Demo4Batch {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis/conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //从 XML 中构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog1 = new Blog();
            blog1.setBlogTitle("这是标题1");
            blog1.setBlogContent("这是内容2");
            blog1.setCreateTime(new Date());
            List<Blog> blogList = new ArrayList<>();
            blogList.add(blog1);

            Blog blog2 = new Blog();
            blog2.setBlogTitle("这是标题1");
            blog2.setBlogContent("这是内容2");
            blog2.setCreateTime(new Date());
            blogList.add(blog2);
            int result = mapper.insertBatch(blogList);
            System.out.println(result);
            session.commit();
        } finally {
            session.close();
        }
    }
}
