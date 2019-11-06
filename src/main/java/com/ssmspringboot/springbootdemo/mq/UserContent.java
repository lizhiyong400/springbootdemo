package com.ssmspringboot.springbootdemo.mq;
/**
 * 发送消息体
 *
 */

import lombok.*;
import lombok.experimental.Accessors;

@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Accessors(chain = true)
@Getter
@Setter
@Builder
@Data
public class UserContent {
    private String username;
    private String pwd;

}
