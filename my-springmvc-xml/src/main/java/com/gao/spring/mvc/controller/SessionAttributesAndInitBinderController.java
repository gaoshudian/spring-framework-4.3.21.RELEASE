package com.gao.spring.mvc.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 名称: SessionAttributesController.java
 * 描述: 测试@SessionAttributes注解的用法
 *
 * @author gaoshudian
 * @date 2019/10/31 4:54 PM
 */
@SessionAttributes(value={"user"}, types={String.class})
@Controller
public class SessionAttributesAndInitBinderController {

    /**
     * 测试@SessionAttributes的用法
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map){
        map.put("user", "gaosd");
        return "success";
    }

    @InitBinder
    public 	void InitBinder(WebDataBinder binder){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
        binder.registerCustomEditor(Date.class,dateEditor);
    }

    @RequestMapping(value="/testInitBinderparam",method= RequestMethod.GET)
    public String getFormatData(Date date, ModelMap map) throws ParseException{
        map.put("user", "gaosd");
        map.put("date",date);
        return "success";
    }


}
