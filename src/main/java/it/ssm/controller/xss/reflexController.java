package it.ssm.controller.xss;

import it.ssm.domain.article;
import it.ssm.service.impl.reflexServiceImpl;
import it.ssm.tools.charEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/xss")
public class reflexController {

    @Autowired
    private reflexServiceImpl reflexServiceimpl;


    @RequestMapping("/reflex")
    public ModelAndView reflex(@RequestParam("title") String title){

        article articleOne = reflexServiceimpl.getArticleBytitle(title);
        ModelAndView index = new ModelAndView();
        index.setViewName("../article.jsp");
        index.addObject("keyword",title);

        //xss过滤
//        index.addObject("keyword",charEncoding.charFilterESAPI(title));

        if (articleOne!=null){
            index.addObject("title", articleOne.getTitle());
            index.addObject("author",articleOne.getAuthor());
            index.addObject("ctime",articleOne.getCtime());
            index.addObject("context",articleOne.getContent());
        }else{
            index.addObject("title", "");
            index.addObject("author","");
            index.addObject("ctime","");
            index.addObject("context","");
        }

        return index;
    }
}
