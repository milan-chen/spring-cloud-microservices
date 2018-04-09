package com.cfx.spring.cloud.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * @Author: cfx
 * @Description: xml转换成对象
 * @Date: Created in 2018/4/5 22:25
 */
public class XmlBuilder {
    /**
     * 将XML转换为指定的POJO
     * @param clazz
     * @param xmlStr
     * @return
     * @throws Exception
     */
    public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws Exception {
        Object xmlObject = null;
        Reader reader = null;
        JAXBContext context = JAXBContext.newInstance(clazz);

        //XML转为对象接口
        Unmarshaller unmarshaller = context.createUnmarshaller();

        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);

        if (null != reader) {
            reader.close();
        }
        return xmlObject;
    }
}
