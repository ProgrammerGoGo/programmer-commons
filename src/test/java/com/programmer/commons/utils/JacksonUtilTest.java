package com.programmer.commons.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @Author programmerGoGo
 * @Description
 */
public class JacksonUtilTest {

    @Test
    public void object2Json() {
        User user = new User("zhangsan", 11);
        System.out.println(JacksonUtil.object2Json(user)); //{"name":"zhangsan","age":11}
    }

    @Test
    public void listObject2ListJson() {
        User user1 = new User("zhangsan", 11);
        User user2 = new User("lisi", 12);
        System.out.println(JacksonUtil.listObject2ListJson(Lists.newArrayList(user1, user2))); // [{"name":"zhangsan","age":11}, {"name":"lisi","age":12}]

    }

    @Test
    public void listJson2ListObject() {
        String s1 = "{\"name\":\"zhangsan\",\"age\":11}";
        String s2 = "{\"name\":\"lisi\",\"age\":12}";
        List<User> list = JacksonUtil.listJson2ListObject(Lists.newArrayList(s1, s2), User.class);
        list.forEach(System.out::println);
    }

    @Test
    public void json2Object() {
        String s1 = "{\"name\":\"zhangsan\",\"age\":11}";
        User user = JacksonUtil.json2Object(s1, User.class);
        System.out.println(user);
    }

    @Test
    public void json2Object1() {
        String s1 = "{\"name\":\"zhangsan\",\"age\":11}";
        User user = JacksonUtil.json2Object(s1, new TypeReference<User>() {
        });
        System.out.println(user);
    }

    private static class User {
        private String name;
        private int age;

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}