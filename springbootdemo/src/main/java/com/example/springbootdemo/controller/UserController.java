package com.example.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String index(Model model) {
        List<User> list=userService.queryList();
        model.addAttribute("list",list);
        System.out.print(list.get(0).getId());
        return "index";
    }

    @ResponseBody
    @RequestMapping(value="/delete", method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
    public String delete(@RequestBody String num) {
        /*int num1=userService.delete(num);
        Map map=new HashMap();
        if(num1>0) {
            map.put("message", "删除成功");
        }else
            {
                map.put("message", "删除失败");
            }*/
        Map map=new HashMap();
        map.put("message", "删除成功");
        System.out.print(num);
        return JSONObject.toJSON(map).toString();
    }

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "D://toolS//";

    //Single file upload
    @PostMapping("/api/upload")
    // If not @RestController, uncomment this
    //@ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile uploadfile) {


        if (uploadfile.isEmpty()) {

            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }

        try {

            saveUploadedFiles(Arrays.asList(uploadfile));

        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Successfully uploaded - " +
                uploadfile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);

    }

    //save file
    private void saveUploadedFiles(List<MultipartFile> files) throws IOException {

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

        }

    }
}

