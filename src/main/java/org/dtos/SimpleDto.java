package org.dtos;

public class SimpleDto {

    private int basicIdAsPrimaryKey;
    private String name;
    private int age;
    private int anotherIdAsForeignKey;

    public int getAnotherIdAsForeignKey() {
        return anotherIdAsForeignKey;
    }

    public void setAnotherIdAsForeignKey(int anotherIdAsForeignKey) {
        this.anotherIdAsForeignKey = anotherIdAsForeignKey;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBasicIdAsPrimaryKey() {
        return basicIdAsPrimaryKey;
    }

    public void setBasicIdAsPrimaryKey(int basicIdAsPrimaryKey) {
        this.basicIdAsPrimaryKey = basicIdAsPrimaryKey;
    }
}
