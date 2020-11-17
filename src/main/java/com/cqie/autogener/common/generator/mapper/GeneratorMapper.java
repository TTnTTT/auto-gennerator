package com.cqie.autogener.common.generator.mapper;

import com.cqie.autogener.common.generator.entity.Column;
import com.cqie.autogener.common.generator.entity.Table;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author helit747@gmail.com
 * @date 2020/9/18 上午11:14
 */
@Repository
public interface GeneratorMapper {
    /**
     * 获取数据库下所有表
     * @param schemaName
     * @return
     */
    List<Table> getTables(@Param("schemaName") String schemaName);

    /**
     * 获取表下的所有字段属性
     * @param databaseType 数据库类型
     * @param schemaName
     * @param tableName
     * @return
     */
    List<Column> getColumns(String databaseType,String schemaName, String tableName);
}
