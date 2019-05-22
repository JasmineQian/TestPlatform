package com.example.demo.controller;

import com.example.demo.bean.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class UserController {


    @Autowired
    private UserService userService;



    @RequestMapping(value={"/login"})
    public String login(Model model) {

        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth instanceof AnonymousAuthenticationToken) {
                return "user/login";
            } else {
                //获取用户登录权限详细
                Object pinciba=auth.getPrincipal();
                if(pinciba instanceof UserDetails){
                    UserDetails userDetail = ((UserDetails) pinciba);
                    model.addAttribute("username", userDetail.getUsername());
                    UserEntity u =userService.getByUsername(userDetail.getUsername());
                    model.addAttribute("realName",u.getNickname());
                }

                //登录成功跳到主页
                System.out.println("会员登录成功！");
                return "index";

            }
        } catch (Exception e) {
            e.printStackTrace();
            return "user/login";
        }


    }



    /**
     * 添加一个用户
     * @param user
     * @return
     */
    /*@RequestMapping(value = "/addSingleUser",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addSingleUser(@ModelAttribute(value="user")User user){
        Map<String, Object> result = new HashMap<String, Object>();
        try{
            userServiceImpl.save(user);
            //TODO 可以封装成工具类
            result.put("flag", true);
            result.put("msg", "保存成功");
        }catch (Exception e){
            result.put("flag", false);
            result.put("msg", "系统错误，请联系管理员！");
        }
        return result;
    }*/

    /**
     * 无权限访问页
     * @return
     */
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.setViewName("403");
        return model;
    }

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "user/user";
    }

    @GetMapping("/register")
    public String register() {
        return "user/register";
    }

    @PostMapping("/register")
    public String doRegister(UserEntity userEntity) {
        System.out.println(userEntity);
        int count_name = userService.checkUsername(userEntity.getUsername());
        if (count_name==0) {
            int count = userService.insert(userEntity);
            System.out.println(count);
            if (count > 0)
                return "redirect:register?success";
            return "redirect:register?error";
        } else {
            return "redirect:register?error";
        }
    }


}
