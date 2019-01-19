package com.chen.ellen.amy.util;

import com.tencent.mmkv.MMKV;

public class MMKVUtils {

    private static MMKVUtils mmkvUtils;

    private MMKVUtils(){
        mmkv = MMKV.defaultMMKV();
    }

    private MMKV mmkv;

    public static MMKVUtils getInstance() {
        if (mmkvUtils == null) {
            synchronized (MMKVUtils.class) {
                if (mmkvUtils == null) {
                    mmkvUtils = new MMKVUtils();
                }
            }
        }
        return mmkvUtils;
    }

    public void save(String key, Object value) {
        if (value instanceof String) {
            mmkv.encode(key, (String) value);
        } else if (value instanceof Integer) {
            mmkv.encode(key, (Integer) value);
        } else if (value instanceof Long) {
            mmkv.encode(key, (Long) value);
        } else if (value instanceof Float) {
            mmkv.encode(key, (Float) value);
        } else if (value instanceof Double) {
            mmkv.encode(key, (Double) value);
        } else if (value instanceof Boolean) {
            mmkv.encode(key, (Boolean) value);
        } else {
            //如果不是基本类型则以toString的方式保存
            mmkv.encode(key, value.toString());
        }
    }

    public Object get(String key, Object defalutValue) {
        Object result = null;
        if (defalutValue instanceof String) {
            result = mmkv.decodeString(key, (String) defalutValue);
        } else if (defalutValue instanceof Integer) {
            result = mmkv.decodeInt(key, (Integer) defalutValue);
        } else if (defalutValue instanceof Long) {
            result = mmkv.decodeLong(key, (Long) defalutValue);
        } else if (defalutValue instanceof Float) {
            result = mmkv.decodeFloat(key, (Float) defalutValue);
        } else if (defalutValue instanceof Double) {
            result = mmkv.decodeDouble(key, (Double) defalutValue);
        } else if (defalutValue instanceof Boolean) {
            result = mmkv.decodeBool(key, (Boolean) defalutValue);
        } else {
            //如果不是基本类型则以toString的方式保存1
            result = mmkv.decodeString(key, defalutValue.toString());
        }
        return result;
    }
}
