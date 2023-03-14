package com.programmer.commons.utils;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Pattern;

/**
 * @Author programmerGoGo
 * @Description
 */
public class NumberUtil {

    private static final Pattern PATTERN = Pattern.compile("^(([1-9]{1}\\d*)|(0{1}))(\\.\\d{1,2})?$");

    /**
     * 校验小数点后最多两位
     *
     * @param data
     * @return
     */
    public static boolean upToTwoDecimalPlaces(String data) {
        if (StringUtils.isBlank(data)) {
            return false;
        }
        return PATTERN.matcher(data.trim()).matches();
    }

    public static void main(String[] args) {

        System.out.println("5 === " + upToTwoDecimalPlaces("5"));
        System.out.println("5. === " + upToTwoDecimalPlaces("5."));
        System.out.println("5.1 === " + upToTwoDecimalPlaces("5.1"));
        System.out.println("5.12 === " + upToTwoDecimalPlaces("5.12"));
        System.out.println("5.123 === " + upToTwoDecimalPlaces("5.123"));
        System.out.println("0.12 === " + upToTwoDecimalPlaces("0.12"));
    }

}
