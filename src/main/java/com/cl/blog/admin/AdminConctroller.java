package com.cl.blog.admin;

import com.cl.blog.Dao.Article;
import com.cl.blog.Dao.interf.ArticleRepository;
import com.cl.blog.staute.ajaxBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/")
public class AdminConctroller {
    @Autowired
   private ArticleRepository articleRepository;
@RequestMapping("/login")
   // ArticleRepository articleRepository;
    public String success() {
        return "redirect:/main.html";
    }
    @RequestMapping("/admin/forget")
    public String ResetPwd()
    {
        return "redirect:/ResetPwd.html";
    }
@PostMapping(value = "/admin/login")
    public String Login(@RequestParam("name")String username, @RequestParam("password") String password, HttpSession session) {
/*    String name=request.getParameter("name");
    String password=request.getParameter("password");
    System.out.println("username is:"+name);
    System.out.println("password is:"+password);*/
    if(!StringUtils.isEmpty(username)&&password.equals("123456")){
        session.setAttribute("msg","");
        session.setAttribute("username",username);
        return "redirect:/logSuccess.html";
    }
    else{
        session.setAttribute("msg","用户名或密码错误！");
        return "redirect:/main.html";
    }
}
@RequestMapping(value="/edit",method =RequestMethod.POST)
@ResponseBody
public String edit(@RequestBody Map<String,Object> map){
    ajaxBack msg =new ajaxBack();
    String header= (String) map.get("header");
    String content= (String) map.get("article");
    System.out.println(header+content);
    Article article=new Article();
    article.setHeader(header);
    article.setContent(content);
    articleRepository.save(article);
    msg.setMsg("文章保存成功!");
    return "成功保存！";
  //  return "redirect:/edit.html";
}
@RequestMapping("admin/manage/WriteArticle")
public String WriteArticle(){
    return "redirect:/WriteArticle.html";
}
}
