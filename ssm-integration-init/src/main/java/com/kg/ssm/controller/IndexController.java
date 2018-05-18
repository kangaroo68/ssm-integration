package com.kg.ssm.controller;

import com.kg.ssm.pojo.PageEntity;
import com.kg.ssm.pojo.User;
import com.kg.ssm.service.IUserService;
import com.kg.ssm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/index")
    public String index(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        HttpServletRequest request, Model model) {
        PageEntity pageEntity = new PageEntity(page, 10);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", pageEntity.getStart());
        map.put("size", pageEntity.getPageSize());


        List<User> users = userService.list(map);
        Long total = userService.getTotal(map);
        model.addAttribute("users", users);
        StringBuffer param = new StringBuffer();

        String pageHtml = PageUtil.genPagination(request.getContextPath() + "/index", total, page, 10, param.toString());
        model.addAttribute("pageHtml", pageHtml);
        return "index";
    }
}
