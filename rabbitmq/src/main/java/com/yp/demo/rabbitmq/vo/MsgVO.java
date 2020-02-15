package com.yp.demo.rabbitmq.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
public class MsgVO implements Serializable {
    private static final long serialVersionUID = 1394338278499857372L;
    private Long acctId;
    private String customerName;
}
