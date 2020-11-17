package com.cqie.autogener.common.entity;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;

/** 统一返回格式
 * @author helit747@gmail.com
 * @date 2020/9/19 下午8:50
 */
public class ResponseBo extends JSONObject {
    //如果想设置成可以连着点下去的就必须让其先实例化,如果想静态的访问则不能连着点下去,
    public ResponseBo put(String key, Object value) {
        super.put(key, value);
        return this;
    }
    public ResponseBo() {
        this.put("code", HttpStatus.OK);
        this.put("msg", "成功");
    }

    public static ResponseBo ok() {
        return new ResponseBo();
    }
    public static ResponseBo ok(Object message) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("msg", message);
        return responseBo;
    }

    public static ResponseBo fail() {
        return ResponseBo.fail("操作失败");
    }
    public static ResponseBo fail(Object msg) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code",520);
        responseBo.put("msg", msg);
        return responseBo;
    }
}
