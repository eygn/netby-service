package com.alibaba.netby.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.util.function.BiFunction;

/**
 * @author: byg
 * @date 2022/6/7 11:31
 */
public class AssertUtil {

    private static final Logger log = LoggerFactory.getLogger(AssertUtil.class);


    private AssertUtil() {
    }

    public static void isNull(@Nullable Object o, StateCode retCode) {
        isNull(o, retCode, retCode.getDesc());
    }

    public static void isNull(@Nullable Object o, StateCode retCode, String message) {
        isNull(o, retCode, BizException::new, message);
    }

    public static void isNull(@Nullable Object o, StateCode retCode, BiFunction<StateCode, String, ? extends RuntimeException> constructor, String message) {
        isTrue(o == null, retCode, constructor, message);
    }

    /**
     * 非空校验
     *
     * @param object  校验对象
     * @param retCode 校验未通过时抛出的业务异常的枚举码
     */
    public static void notNull(@Nullable Object object, StateCode retCode) {
        notNull(object, retCode, BizException::new, retCode.getDesc());
    }

    public static void notNull(Object object, StateCode code, String message) {

        notNull(object, code, BizException::new, message);
    }

    /**
     * 非空校验
     *
     * @param object      校验对象
     * @param retCode     校验未通过时抛出的业务异常的枚举码
     * @param constructor 校验未通过时要抛出的异常的构造函数，该异常需继承自{@link RuntimeException}
     */
    public static void notNull(@Nullable Object object, StateCode retCode, BiFunction<StateCode, String, ? extends RuntimeException> constructor, String message) {
        isTrue(object != null, retCode, constructor, message);
    }

    /**
     * 任意一个obj都不能为空
     *
     * @param retCode 校验未通过时抛出的业务异常的枚举码
     * @param args    待校验参数
     */
    public static void notAnyNull(StateCode retCode, Object... args) {
        notAnyNull(retCode, BizException::new, args);
    }

    /**
     * 任意一个obj都不能为空
     *
     * @param code        校验未通过时抛出的业务异常的枚举码
     * @param args        待校验参数
     * @param constructor 校验未通过时要抛出的异常的构造函数，该异常需继承自{@link RuntimeException}
     */
    public static void notAnyNull(StateCode code, BiFunction<StateCode, String, ? extends RuntimeException> constructor, Object... args) {
        for (Object arg : args) {
            notNull(arg, code, constructor, code.getDesc());
        }
    }

    /**
     * 真值校验
     *
     * @param condition 表达式
     * @param retCode   校验未通过时抛出的业务异常的枚举码
     */
    public static void isTrue(boolean condition, StateCode retCode, String message) {
        isTrue(condition, retCode, BizException::new, message);
    }

    /**
     * 真值校验
     *
     * @param condition   表达式
     * @param retCode     校验未通过时抛出的业务异常的枚举码
     * @param constructor 校验未通过时要抛出的异常的构造函数，该异常需继承自{@link RuntimeException}
     */
    public static void isTrue(boolean condition, StateCode retCode, BiFunction<StateCode, String, ? extends RuntimeException> constructor, String message) {
        if (condition) {
            return;
        }
        log.error("{}", message);
        throw constructor.apply(retCode, message);
    }

    /**
     * 真值校验
     *
     * @param condition 表达式
     * @param retCode   校验未通过时抛出的业务异常的枚举码
     */
    public static void isFalse(boolean condition, StateCode retCode, String message) {
        isFalse(condition, retCode, BizException::new, message);
    }

    /**
     * 真值校验
     *
     * @param condition   表达式
     * @param retCode     校验未通过时抛出的业务异常的枚举码
     * @param constructor 校验未通过时要抛出的异常的构造函数，该异常需继承自{@link RuntimeException}
     */
    public static void isFalse(boolean condition, StateCode retCode, BiFunction<StateCode, String, ? extends RuntimeException> constructor, String message) {
        isTrue(!condition, retCode, constructor, message);
    }
}
