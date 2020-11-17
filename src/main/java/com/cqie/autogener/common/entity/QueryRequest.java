package com.cqie.autogener.common.entity;


import lombok.Data;

/**需要分页的请求
 * @author helit747@gmail.com
 * @date 2020/9/19 下午8:39
 */
@Data
public class QueryRequest{

        /**
         * 当前页面数据量
         */
        private int pageSize = 10;

        /**
         * 当前页码
         */
        private int pageNum = 1;

        /**
         * 排序字段
         */
        private String field;

        /**
         * 排序规则，asc升序，desc降序
         */
        private String order;
}
