package com.spboot.util;

/**
 * @Author WANG JI BO
 * @Date 2020/4/3 3:16 下午
 * @Description
 **/

import com.alibaba.druid.util.StringUtils;
import org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lzh on 2019/1/9.
 * Content :加密工具
 */
public class EncryptUtil {

    /**
     * 制表符、空格、换行符 PATTERN
     */
    private static Pattern BLANK_PATTERN = Pattern.compile("\\s*|\t|\r|\n");

    /**
     * 可以理解为加密salt
     */
    private static String PASSWORD = "eaf7828d2e7c6c0";

    /**
     * 加密算法
     */
    private static String ALGORITHM = "PBEWithMD5AndDES";

    public static Map getEncryptedParams(String input) {
        //输出流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        PrintStream cacheStream = new PrintStream(byteArrayOutputStream);
        //更换数据输出位置
        System.setOut(cacheStream);

        //加密参数组装
        String[] args = {"input=" + input, "password=" + PASSWORD, "algorithm=" + ALGORITHM};
        JasyptPBEStringEncryptionCLI.main(args);

        //执行加密后的输出
        String message = byteArrayOutputStream.toString();
        String str = replaceBlank(message);
        int index = str.lastIndexOf("-");

        //返回加密后的数据
        Map result = new HashMap();
        result.put("input", "ENC("+str.substring(index + 1)+")");
        result.put("password", PASSWORD);
        return result;
    }

    public static void main(String[] args) {

        System.out.println(getEncryptedParams("h3_tmp"));//print : {input=Ore69lUopDHL5R8Bw/G3bQ==, password=klklklklklklklkl}
    }

    /**
     * 替换制表符、空格、换行符
     *
     * @param str
     * @return
     */
    private static String replaceBlank(String str) {
        String dest = "";
        if (!StringUtils.isEmpty(str)) {
            Matcher matcher = BLANK_PATTERN.matcher(str);
            dest = matcher.replaceAll("");
        }
        return dest;
    }
}

