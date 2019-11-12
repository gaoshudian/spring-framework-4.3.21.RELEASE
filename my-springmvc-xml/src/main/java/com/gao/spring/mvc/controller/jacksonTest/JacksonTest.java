package com.gao.spring.mvc.controller.jacksonTest;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.gao.spring.mvc.controller.User;
import org.junit.Test;
import org.springframework.cglib.core.Local;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;

public class JacksonTest {

    /**
     * 下面代码是截取的spring源码中把对象转换成json字符串的核心代码
     */
    @Test
    public void test() throws Exception{
        OutputStream bos = System.out;

        ObjectMapper mapper = new ObjectMapper();
        JsonGenerator generator = mapper.getFactory().createGenerator(bos, JsonEncoding.UTF8);

        //设置json字符串前缀
        generator.writeRaw("json返回值:(");

        ObjectWriter objectWriter = mapper.writer();
        objectWriter.writeValue(generator, new User("gsd","28"));

//        mapper.writeValue(bos,new User("gsd","28"));

        //设置json字符串后缀
        generator.writeRaw(")");
        generator.flush();

    }

    //上面方法的变种
    @Test
    public void test2() throws Exception{
        OutputStream bos = System.out;

        ObjectMapper mapper = new ObjectMapper();
        JsonGenerator generator = mapper.getFactory().createGenerator(bos, JsonEncoding.UTF8);

        //设置json字符串前缀
        generator.writeRaw("json返回值:(");

        generator.writeObject(new User("gsd","28", LocalDateTime.now()));
//        mapper.writeValue(bos,new User("gsd","28"));

        //设置json字符串后缀
        generator.writeRaw(")");
        generator.flush();

    }


}
