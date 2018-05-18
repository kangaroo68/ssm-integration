package com.kg.ssm.controller;

import com.kg.ssm.pojo.User;
import com.kg.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @RequestMapping("/frontUserSet/{id}")
    public String frontUserSet(@PathVariable int id, Model model) {
        return "front/user/userSet";
    }

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "showUser";
    }


    @RequestMapping("/showUser/{id}")
    public String showUser(@PathVariable int id, HttpServletRequest request) {
        User u = userService.getUserById(id);
        request.setAttribute("user", u);
        return "showUser";
    }

    @RequestMapping("/turnToIndex")
    public String turnToIndex() {
        return "index";
    }

    @RequestMapping("/turnToUserList")
    public String turnToUserList() {
        return "user/userList";
    }

    /**
     * @param @param user
     * @param @param request
     * @return void
     * @throws IOException
     * @throws
     * @Description: 新建用户
     * @author chj
     * @date 2016-1-2  下午11:06:27
     */
    @RequestMapping("/create")
    public void createUser(User user, HttpServletResponse response) throws IOException {
        try {
            userService.createUser(user);
            response.getWriter().print("true");
        } catch (Exception e) {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/delete")
    public void delete(String ids, HttpServletResponse response) throws IOException {
        String[] str_ids = ids.split(",");
        for (String id : str_ids) {
            userService.deleteByPrimaryKey(Integer.parseInt(id));
            response.getWriter().print("true");
        }
    }

    @RequestMapping("/edit")
    public void edit(User user, HttpServletResponse response) {
        try {
            userService.updateByPrimaryKeySelective(user);
            response.getWriter().print("true");
        } catch (Exception e) {
        }
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:../login.jsp";
    }


}
