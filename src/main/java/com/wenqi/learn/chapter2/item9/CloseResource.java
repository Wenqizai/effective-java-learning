package com.wenqi.learn.chapter2.item9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



/**
 * @author liangwenqi
 * @date 2022/1/21
 */
public class CloseResource {

    /**
     * try-finally - No longer the best way to close resources!
     *
     * try 块和 finally 块中的代码都能够抛出异常。
     * 例如，在 firstLineOfFile 方法中，由于底层物理设备发生故障，对 readLine 的调用可能会抛出异常，而关闭的调用也可能出于同样的原因而失败。
     * 在这种情况下，第二个异常将完全覆盖第一个异常。异常堆栈跟踪中没有第一个异常的记录，这可能会使实际系统中的调试变得非常复杂
     *
     * @param path
     * @return
     * @throws IOException
     */
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    /**
     * try-finally is ugly when used with more than one resource!
     * @param src
     * @param dst
     * @throws IOException
     */
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[1024];
                int n;
                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();
            }
        }
        finally {
            in.close();
        }
    }

    /**
     * try-with-resources - the the best way to close resources!
     * @param path
     * @return
     * @throws IOException
     */
    static String firstLineOfFileBetter(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    /**
     * try-with-resources on multiple resources - short and sweet
     * 多资源的关闭流
     *
     * @param src
     * @param dst
     * @throws IOException
     */
    static void copyBetter(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }

    /**
     * try-with-resources with a catch clause
     * 不抛出异常, 返回一个默认值
     *
     * @param path
     * @param defaultVal
     * @return
     */
    static String firstLineOfFile(String path, String defaultVal) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }
}
