package top.yuyufeng.learn.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import top.yuyufeng.learn.mybatis.entity.Blog;

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

}
