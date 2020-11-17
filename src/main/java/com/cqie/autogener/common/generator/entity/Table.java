package com.cqie.autogener.common.generator.entity;

import lombok.Data;

/**
 * @author helit747@gmail.com
 * @date 2020/9/18 上午10:24
 */
@Data
public class Table {
        /**
         * 名称
         */
        private String name;
        /**
         * 备注
         */
        private String remark;
        /**
         * 数据量（行）
         */
        private Long dataRows;
        /**
         * 创建时间
         */
        private String createTime;
        /**
         * 修改时间
         */
        private String updateTime;

}
