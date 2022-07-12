package com.kangkang.store.utils;

import com.kangkang.store.controller.ex.FileEmptyException;
import com.kangkang.store.controller.ex.FileSizeException;
import com.kangkang.store.controller.ex.FileTypeException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * ClassName:RandomFileName
 * Package:com.kangkang.store.utils
 * Description:
 *
 * @date:2022/3/26 16:50
 * @author:kangkang
 */
public class RandomFileName {
    public static final int MAX_SIZE = 1024 * 1024 *10;
    public static final List<String> AVATAR_TYPES = new ArrayList<String>();

    /** 初始化允许上传的头像的文件类型 */
    static {
        AVATAR_TYPES.add("image/jpeg");
        AVATAR_TYPES.add("image/png");
        AVATAR_TYPES.add("image/bmp");
        AVATAR_TYPES.add("image/gif");
    }

    public static void isCorrect(MultipartFile file){
        if (file.isEmpty()){
            throw new FileEmptyException("文件不存在");
        }
        if (file.getSize() > MAX_SIZE){
            throw  new FileSizeException("文件过大");
        }

        String type = file.getContentType();
        if (!AVATAR_TYPES.contains(type)){
            throw new FileTypeException("文件类型错误");
        }

    }

    public static String getRandomName(MultipartFile file,File dir){
//        得到原始文件的名字
        String originalFilename = file.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);

//        改名
        String filename = UUID.randomUUID().toString().toUpperCase() + suffix;

        File dest = new File(dir,filename);

        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String avatar = "/upload/" + filename;

        return avatar;


//



    }

}
