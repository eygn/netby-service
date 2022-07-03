package com.alibaba.netby.commons;

import com.alibaba.cola.dto.SingleResponse;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author byg
 * @date 2022/7/3 16:48
 */
public abstract class Results {

    /**
     * 成功结果
     */
    public static <T> SingleResponse<T> newSuccessResult(T data) {
        return newSuccessResult(data, CommonStateCode.SUCCESS.getDesc());
    }

    /**
     * 成功结果
     */
    public static <T> SingleResponse<T> newSuccessResult(T data, String statusText) {
        return newResult(data, CommonStateCode.SUCCESS, statusText);
    }

    /**
     * 成功结果
     */
    public static <T> SingleResponse<T> newSuccessResult(T data, String statusText, String appMsg) {
        return newResult(data, CommonStateCode.SUCCESS, statusText, appMsg);
    }

    /**
     * 没有数据回传的失败结果
     */
    public static <T> SingleResponse<T> newFailedResult(StateCode failedCode) {
        return newFailedResult(null, failedCode);
    }

    /**
     * 没有数据回传的失败结果
     */
    public static <T> SingleResponse<T> newFailedResult(StateCode failedCode, String statusText) {
        return newFailedResult(null, failedCode, statusText);
    }

    /**
     * 没有数据回传的失败结果
     */
    public static <T> SingleResponse<T> newFailedResult(StateCode failedCode, String statusText, String appMsg) {
        return newFailedResult(null, failedCode, statusText, appMsg);
    }

    /**
     * 有数据回传的失败结果
     */
    public static <T> SingleResponse<T> newFailedResult(T data, StateCode failedCode) {
        return newFailedResult(data, failedCode, failedCode.getDesc());
    }

    /**
     * 有数据回传的失败结果
     */
    public static <T> SingleResponse<T> newFailedResult(T data, StateCode failedCode, String statusText) {
        return newFailedResult(data, failedCode, statusText, null);
    }

    /**
     * 有数据回传的失败结果
     */
    public static <T> SingleResponse<T> newFailedResult(T data, StateCode failedCode, String statusText, String appMsg) {
        checkNotNull(failedCode);
        checkArgument(failedCode.getCode() < 0,
                "invalid code, for failed result, code must be negative integers");

        return newResult(data, failedCode, statusText, appMsg);
    }

    /**
     * 仅返回状态码
     */
    public static <T> SingleResponse<T> newResult(StateCode code) {
        return newResult(null, code, code.getDesc());
    }

    /**
     * 有数据回传的结果
     */
    public static <T> SingleResponse<T> newResult(T data, StateCode failedCode, String statusText) {
        return newResult(data, failedCode, statusText, null);
    }

    /**
     * 有数据回传的结果
     */
    public static <T> SingleResponse<T> newResult(T data, StateCode failedCode, String statusText, String appMsg) {
        SingleResponse<T> result = new SingleResponse<T>();
        result.setData(data);
        result.setSuccess(failedCode.getCode() > 0 ? true : false);
        result.setErrCode(Objects.toString(failedCode.getCode()));
        result.setErrMessage(statusText);
        return result;
    }
}
