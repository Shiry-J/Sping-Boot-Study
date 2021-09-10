package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

//author: 悟空非空也（B站/知乎/公众号）
@Controller
public class FileController {

    @GetMapping("/upload")
    public String upload(){
        return "upload";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(
            @RequestParam("fileUpload") MultipartFile[] uploadFiles,
            Model model,
            HttpServletRequest request){
        model.addAttribute("uploadStatus","文件上传成功");
        for (MultipartFile file : uploadFiles) {
            String originalFilename = file.getOriginalFilename();// 获得文件名及后缀，例如  wukong.jpg
            //重新命名
            String newFilename = UUID.randomUUID() +"-"+ originalFilename;
            // 创建上传文件的存放目录 :设置为tomcat服务器中的路径
            String newPath = request.getServletContext().getRealPath("/upload");
            System.out.println(newPath);

            // String newPath ="D:\\upload";
            File file1 = new File(newPath);
            if (!file1.exists()){
                file1.mkdir();
            }

            //创建新文件，接受传递过来的文件流
            try {
                file.transferTo(new File(newPath,newFilename));
                model.addAttribute("uploadStatus","上传成功");
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("uploadStatus","上传失败");
            }
        }
        return "upload";
    }

}
