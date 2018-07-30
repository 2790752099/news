package com.example.springbootdemo.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
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
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String index(Model model) {
        List<User> list=userService.queryList();
        model.addAttribute("list",list);

        return "index";
    }

    @RequestMapping(value = "/update.html/{id}", produces = { "text/html;charset=UTF-8" } )
    public String update(@PathVariable int id,Model model) {
        User list=userService.query(id);
        model.addAttribute("list",list);

        return "update";
    }

    @RequestMapping(value="/delete", method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String delete(User num) {
        int num1=userService.delete(num.getId());
        Map map=new HashMap();
        if(num1>0) {
            map.put("message", "删除成功");
        }else {
            map.put("message", "删除失败");
        }
        return JSONArray.toJSONString(map);
    }

    @RequestMapping(value="/update", method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String update(User num) {
        int num1=userService.update(num);
        Map map=new HashMap();
        if(num1>0) {
            map.put("message", "修改成功");
        }else {
            map.put("message", "修改失败");
        }
        return JSONArray.toJSONString(map);
    }


    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "D://toolS//";

    // Multiple file upload
    @PostMapping("/api/upload")
    public ResponseEntity<?> uploadFileMulti(@RequestParam("files") MultipartFile[] uploadfiles) {
        String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));
        if (StringUtils.isEmpty(uploadedFileName)) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }
        try {
            saveUploadedFiles(Arrays.asList(uploadfiles));
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Successfully uploaded - "
                + uploadedFileName, HttpStatus.OK);

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

