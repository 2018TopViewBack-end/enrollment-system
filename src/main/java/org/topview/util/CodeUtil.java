package org.topview.util;

import java.util.UUID;

/**
 * 生成唯一的uuid码,可用于图片标记等
 *
 * @author Medwin。
 * @since 18/8/9
 */
public class CodeUtil {
    public static String generateUniqueCode(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
