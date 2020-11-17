package com.cqie.autogener.common.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author helit747@gmail.com
 * @date 2020/9/19 下午10:50
 */
public class BaseController {
    /**
     * 包装返回分页信息
     *
     * @param pageInfo
     * @return
     */
    protected Map<String,Object> getDataTable(IPage<?> pageInfo) {
        return getDataTable(pageInfo, 2);
    }
    protected Map<String, Object> getDataTable(IPage<?> pageInfo, int dataMapInitialCapacity) {
        Map<String, Object> data = new HashMap<>(dataMapInitialCapacity);
        data.put("rows", pageInfo.getRecords());
        data.put("total", pageInfo.getTotal());
        return data;
    }
}
