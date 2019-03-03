package com.cl.blog.admin;

import com.cl.blog.Dao.Article;
import com.cl.blog.Dao.interf.ArticleRepository;
//import com.sun.deploy.net.HttpResponse;
//import jdk.incubator.http.HttpResponse;
//import org.graalvm.compiler.core.GraalCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.resource.HttpResource;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

//import static org.graalvm.compiler.nodeinfo.Verbosity.Id;

@Controller
@RequestMapping("/")
public class PagesControllers {
    @Autowired
    public ArticleRepository articleRepository;
    @RequestMapping("/")
    public String index()
    {
        return "redirect:/index.html";
    }
    @RequestMapping("/pages/SelfIntrodution")
    public String SelfIntrodution()
    {
        return "redirect:/SelfIntrodution.html";
    }
    @RequestMapping("pages/shares")
    public String Shares()
    {
        return "redirect:/shares.html";
    }
    @RequestMapping("pages/LeftMessage")
    public String LeftMessage()
    {
        return "redirect:/LeftMessage.html";
    }
    @RequestMapping("pages/getArticle")
    @ResponseBody
    public List<Article> GetArticles()
    {
      //  List<Article> articleList;
       // articleList= (List<Article>) articleRepository.findAll();
        return (List<Article>) articleRepository.findAll();
    }
    //@RequestMapping("/pages/ReadMore")
    @GetMapping("/pages/ReadMore")
    public String ReadMore(@RequestParam("id")String id, Model model)
    {
        int Id=Integer.parseInt(id);
        System.out.println(Id);
        Optional<Article> article=articleRepository.findById(Id);
        Article temp=article.get();
        model.addAttribute("header",temp.getHeader());
        model.addAttribute("content",temp.getContent());
     //   map.put("header",temp.getHeader());
      //  map.put("content",temp.getContent());
     //  System.out.println(temp.getHeader());
        return "pages/ReadMore";
    }
}
