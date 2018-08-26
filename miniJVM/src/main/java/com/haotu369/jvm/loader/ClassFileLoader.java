package com.haotu369.jvm.loader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.haotu369.jvm.clz.ClassFile;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public class ClassFileLoader {

    /**
     * 加载多个类文件
     */
    static final int BUFFER_SIZE = 1024;
    private List<String> clzPaths = new ArrayList<String>();

    /**
     * @param className:类的全限定名
     * @return 字节数组
     */
    public byte[] readBinaryCode(String className) {

        className = className.replace('.', File.separatorChar) + ".class";

        for (String path : clzPaths) {

            String clzFileName = path + File.separator + className;
            byte[] codes = loadClassFile(clzFileName);
            if (codes != null) {
                return codes;
            }
        }

        return null;
    }

    /**
     * 路径添加
     *
     * @param path
     */
    public void addClassPath(String path) {
        if (this.clzPaths.contains(path)) {
            return;
        }
        this.clzPaths.add(path);
    }

    /**
     * @return 拼接好的路径字符串
     */
    public String getClassPath() {
        return StringUtils.join(clzPaths, ";");
    }

    /**
     * 加载类
     *
     * @param classFileName 类的路径+全限定名
     * @return 类的字节码数组
     */
    public byte[] loadClassFile(String classFileName) {

        //jdk1.7及其以上版本  流自动关闭功能
        try (InputStream input = new FileInputStream(classFileName);) {

            return IOUtils.toByteArray(input);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param className:类的全限定名
     * @return 类的对象
     */
    public ClassFile loadClass(String className) {
        byte[] codes = readBinaryCode(className);
        ClassFileParser parser = new ClassFileParser();
        return parser.parse(codes);
    }

    /**********************自己实现**************************/
    private String getClassPath_V1() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < clzPaths.size(); i++) {
            buffer.append(clzPaths.get(i));
            if (i != clzPaths.size() - 1) {
                buffer.append(";");
            }
        }
        return buffer.toString();
    }

    private byte[] loadClassFile_V1(String clzFileName) {

        //jdk1.7新增功能
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(clzFileName));
                ByteArrayOutputStream bos = new ByteArrayOutputStream()) {

            int length = -1;
            byte[] buffer = new byte[BUFFER_SIZE];

            while ((length = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
            }

            byte[] codes = bos.toByteArray();

            return codes;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
