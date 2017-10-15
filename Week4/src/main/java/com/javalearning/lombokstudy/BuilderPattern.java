package com.javalearning.lombokstudy;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
public class BuilderPattern {

    private final String userName;
    private final String password;
    private final int age;
    private final Date birthday;

    private BuilderPattern(Builder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
        this.age = builder.age;
        this.birthday = builder.birthday;
    }


    public static class Builder {
        private final String userName;
        private final String password;

        private int age = 0;
        private Date birthday = new Date();

        public Builder(String name, String pwd) {
            this.userName = name;
            this.password = pwd;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setBirthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public BuilderPattern Builder() {
            return new BuilderPattern(this);
        }
    }
}
