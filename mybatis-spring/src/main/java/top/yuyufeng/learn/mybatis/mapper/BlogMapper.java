package top.yuyufeng.learn.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.yuyufeng.learn.mybatis.entity.Blog;

import java.util.List;

/**
 * @author yuyufeng
 * @date 2018/5/25.
 */
public interface BlogMapper {

    /**
     * 查询Blog
     * @param blogId
     * @return
     */
    Blog selectBlog(Long blogId);


    /**
     * 查询Blog by Id
     * @param blogId
     * @return
     */
    @Select("SELECT blog_id,blog_title,blog_content,create_time FROM blog WHERE blog_id = #{blogId}")
    Blog selectBlogByBlogId(Long blogId);

    /**
     * 插入
     * @param blog
     * @return
     */
    int insert(Blog blog);

    /**
     * 批量插入
     * @param blogList
     * @return
     */
    int insertBatch(@Param("blogList") List<Blog> blogList);


    /**
     * 查询列表
     * @return
     */
    List<Blog> list();

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);
}
