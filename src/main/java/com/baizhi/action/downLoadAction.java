package com.baizhi.action;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping("/down")
public class downLoadAction {
    @RequestMapping("/load")
    public ResponseEntity<byte[]> download(String filename, HttpSession session) throws Exception{
        /*获取目标文件的绝对路径*/
        String realPath = session.getServletContext().getRealPath("/upload");
        File file = new File(realPath + "/" + filename);
        //把目标文件转化为字节数组
        byte[] bytes = FileUtils.readFileToByteArray(file);
        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        //避免乱码问题
        String newName = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
        //设置文件下载打开的方式
        headers.setContentDispositionFormData("attachment",newName);
        //设置文件下载的方式  以二进制流的形式下载
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(bytes,headers, HttpStatus.CREATED);
    }
    /*@RequestMapping("/download")
    public void download(String fileName, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String realPath = request.getRealPath("/upload");
        FileInputStream is = new FileInputStream(new File(realPath, fileName));
        ServletOutputStream os = response.getOutputStream();
        response.setHeader("content-disposition", "attachment;fileName=" +
                URLEncoder.encode(fileName, "UTF-8"));
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }*/
}
