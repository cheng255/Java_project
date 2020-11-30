package org.example.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nuonuo
 * @create 2020-11-30 17:36
 */
public class JSONUtilTest {

    @Test
    public void testSerialize() {
        //测试序列化操作：使用map模拟复杂对象
        Map map = new HashMap();
        map.put("age","14");
        map.put("students",new int[]{1,2,3});
        String json = JSONUtil.serialize(map);
        System.out.println(json);
        Assert.assertNotNull(json);
    }
    @Test
    public void testDeserialize() {
        //测试反序列化操作
        InputStream is = JSONUtilTest.class.getClassLoader()
                .getResourceAsStream("login.json");
        Map map = JSONUtil.deserialize(is, Map.class);
        System.out.println(map);
        Assert.assertNotNull(map);
    }
}
