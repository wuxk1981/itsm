package com.zdhy.platform.itsm.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * 功能: 
 * JsonDateValueProcessor.java
 * 创建人： 吴心宽
 * 时间： 2016年11月18日-下午5:57:59
 * @version v1.0.0
 */
public class JsonDateValueProcessor implements JsonValueProcessor{
	private String format ="yyyy-MM-dd k:mm:ss"; 
	
    public JsonDateValueProcessor() {  
        super();  
    }  
      
    public JsonDateValueProcessor(String format) {  
        super();  
        this.format = format;  
    } 
	public Object processArrayValue(Object paramObject, JsonConfig paramJsonConfig) {
		return process(paramObject);
	}

	public Object processObjectValue(String paramString, Object paramObject, JsonConfig paramJsonConfig) {
		return process(paramObject); 
	}

	private Object process(Object value){  
        if(value instanceof Date){    
            SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.CHINA);    
            return sdf.format(value);  
        }    
        return value == null ? "" : value.toString();    
    }  
}
