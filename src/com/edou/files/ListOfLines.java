package com.edou.files;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ClassName ListOfLines
 * @Description TODO
 * @Author 中森明菜
 * @Date 2020/9/25 16:36
 * @Version 1.0
 */
public class ListOfLines {
    // 不打印注释
    // 打印每行内容的一半
    public static void main(String[] args) throws Exception {
        URL resource = ListOfLines.class.getResource("../streams/Cheese.dat");
        Files.readAllLines(Paths.get(resource.toURI()))
                .stream()
                .filter(line -> !line.startsWith("//"))
                .map(line -> line.substring(0, line.length()/2))
                .forEach(System.out::println);
        Files.readAllLines(Paths.get("src","com","edou","streams","Cheese.dat"))
                .stream()
                .filter(line -> !line.startsWith("//"))
                .map(line -> line.substring(0, line.length()/2))
                .forEach(System.out::println);
        Files.readAllLines(Paths.get("src/com/edou/streams/Cheese.dat").toRealPath())
                .stream()
                .filter(line -> !line.startsWith("//"))
                .map(line -> line.substring(0, line.length()/2))
                .forEach(System.out::println);
        Path path = Paths.get("ListOfLines.java").toAbsolutePath();
        System.out.println(path);
//        Path path1 = Paths.get("ListOfLines.java").toRealPath();
//        System.out.println(path1);
        Path path1 = Paths.get("..");
        System.out.println(path1.toRealPath());
    }
}
