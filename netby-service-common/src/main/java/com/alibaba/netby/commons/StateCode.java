package com.alibaba.netby.commons;

import lombok.Data;

import java.io.Serializable;

/**
 * @author byg
 * @date 2022/7/3 14:58
 **/
@Data
public final class StateCode implements Serializable {

    /* 状态码值 */
    private Integer code;
    /* 状态描述 */
    private String desc;

    /**
     * @param code 状态码
     * @param desc 描述
     */
    public StateCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
