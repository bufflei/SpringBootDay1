package com.baizhi.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping("/file")
public class uploadAction {
    @RequestMapping("/upload")
    public String upload(MultipartFile upload, HttpSession session) throws Exception{
        String realPath = session.getServletContext().getRealPath("/upload");
        File file = new File(realPath + "/" + upload.getOriginalFilename());
        upload.transferTo(file);

        return "index";
    }
}
