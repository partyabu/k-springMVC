package com.abucloud.controller;

import com.abucloud.dto.User;
import com.abucloud.exception.CustomException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author party-abu
 * @Date 2022/5/4 20:05
 */
@Controller
@RequestMapping("test")
public class TestController {

    /**
     * 返回String，其值会被解析成一个逻辑视图名，通过视图解析器会将逻辑视图解析为物理视图
     *
     * @return
     */
    @GetMapping("isOk")
    public String testOk() {
        return "ok";
    }

    /**
     * 使用对象接收路径查询字符串
     *
     * @param user
     */
    @PostMapping("user")
    @ResponseBody
    public void queryUser(User user) {
        System.out.println(user);
    }

    /**
     * 获取请求体的参数
     *
     * @param userStr
     */
    @PostMapping("body")
    public void queryUser(@RequestBody String userStr) {
        System.out.println(userStr);
    }

    /**
     * 返回void类型的四种处理
     *
     * @param response
     * @param request
     * @throws ServletException
     * @throws IOException
     */
    @GetMapping("returnVoid")
    public void returnVoid(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        System.out.println("returnVoid");

        // 1.默认不做处理，返回当前handler的请求路径对应的jsp，即/test/returnVoid.jsp

        // 2.进行转发：forward:xxx
        // request.getRequestDispatcher("/submit.jsp").forward(request, response);

        // 3.进行重定向：redirect:xxx
        // response.sendRedirect("http://www.baidu.com");

        // 4.使用HttpServletResponse响应数据
        response.setContentType("application/json;charset=utf8");

        User user = new User();
        user.setAge(19);
        user.setName("张三");

        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(user);
        response.getWriter().write(result);

    }

    /**
     * 返回视图名和内容
     *
     * @return
     */
    @GetMapping("returnMv")
    public ModelAndView returnMv() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("submit");
        mv.addObject("name", "张三");

        return mv;
    }

    /**
     * 返回json数据
     *
     * @return
     */
    @ResponseBody
    @PutMapping("userJson")
    public User toJson(@RequestBody User user) {
        return user;
    }

    /**
     * 文件上传
     * <p>
     * 前端：
     * 1.post请求方式；2.content-type是multipart/form-data；3.input标签type是file类型
     * <p>
     * 后台：
     * 表单文件参数名要和handler参数名一致，不一致可以使用@RequestParam接收，也可以使用@RequestPart()接收
     *
     * @param fileName
     * @return
     */
    @ResponseBody
    @PostMapping("file")
    public String uploadFile(MultipartFile fileName) {
        throw new CustomException("异常");
    }

    /**
     * 测试@RequestPart()
     *
     * @param file
     * @return
     */
    @ResponseBody
    @PostMapping("file02")
    public String uploadFile02(@RequestPart("file") MultipartFile file, @RequestPart("user") User user) {
        System.out.println(user);
        System.out.println(file.getName());
        return "ok";
    }

}
