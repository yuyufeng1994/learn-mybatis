package top.yuyufeng.learn.mybatis.interceptor;

import com.github.pagehelper.sqlsource.PageRawSqlSource;
import com.github.pagehelper.sqlsource.PageSqlSource;
import com.github.pagehelper.sqlsource.PageStaticSqlSource;
import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.RawSqlSource;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 插件（plugins）
 * MyBatis 允许你在已映射语句执行过程中的某一点进行拦截调用。默认情况下，MyBatis 允许使用插件来拦截的方法调用包括：
 * <p>
 * Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
 * ParameterHandler (getParameterObject, setParameters)
 * ResultSetHandler (handleResultSets, handleOutputParameters)
 * StatementHandler (prepare, parameterize, batch, update, query)
 * 这些类中方法的细节可以通过查看每个方法的签名来发现，或者直接查看 MyBatis 发行包中的源代码。 如果你想做的不仅仅是监控方法的调用，那么你最好相当了解要重写的方法的行为。 因为如果在试图修改或重写已有方法的行为的时候，你很可能在破坏 MyBatis 的核心模块。 这些都是更低层的类和方法，所以使用插件的时候要特别当心。
 * <p>
 * 通过 MyBatis 提供的强大机制，使用插件是非常简单的，只需实现 Interceptor 接口，并指定想要拦截的方法签名即可。
 *
 * @author yuyufeng
 * @date 2018/6/8.
 */
@Intercepts({@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class})})
public class DeleteWarningPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
        System.out.println();
        if ("DELETE".equals(ms.getSqlCommandType().name())) {
            SqlSource sqlSource = ms.getSqlSource();
            RawSqlSource rawSqlSource = (RawSqlSource) sqlSource;
            MetaObject metaObject = SystemMetaObject.forObject(rawSqlSource);
            SqlSource thisSqlSource = (StaticSqlSource) metaObject.getValue("sqlSource");
            MetaObject metaObjectSql = SystemMetaObject.forObject(thisSqlSource);
            String sql = (String) metaObjectSql.getValue("sql");
            System.out.println("系统发生删除操作：" + sql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        for (String key : properties.stringPropertyNames()) {
            System.out.println(key + " " + properties.get(key));
        }
    }
}
