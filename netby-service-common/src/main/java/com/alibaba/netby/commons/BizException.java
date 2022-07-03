package com.alibaba.netby.commons;

public class BizException extends RuntimeException {

    private StateCode stateCode;
    private String errorMsg;

    public BizException(StateCode errorCode) {
        super(errorCode.getDesc());
        this.stateCode = errorCode;
        this.errorMsg = errorCode.getDesc();
    }

    public BizException(StateCode errorCode, String errorMsg) {
        super(errorMsg);
        this.stateCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public StateCode getStateCode() {
        return stateCode;
    }

    public void setStateCode(StateCode stateCode) {
        this.stateCode = stateCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
