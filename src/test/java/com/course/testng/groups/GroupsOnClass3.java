package com.course.testng.groups;

import org.testng.annotations.Test;


@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void tea1(){
        System.out.println("GroupsOnClass3中的tea1");
    }
    public void tea2(){
        System.out.println("GroupsOnClass3中的tea2");
    }
}