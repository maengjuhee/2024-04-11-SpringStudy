package com.sist.vo;

import java.util.*;

import lombok.Data;
/*
 *   보안 : userName,userPwd
 *         ======== id
 */
@Data
public class MemberVO {
    private String userId,userPwd,userName,sex,post,addr1,addr2,email,phone,content;
    private int enabled;
    private Date regdate,modifydate,lastlogin;
    private String msg,authority;
}
