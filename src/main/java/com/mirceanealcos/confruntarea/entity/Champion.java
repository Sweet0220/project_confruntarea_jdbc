package com.mirceanealcos.confruntarea.entity;

public class Champion {
    private Long id;
    private String name;
    private Integer hp;
    private Integer power;

    public Champion() {
    }

    public Champion(Long id, String name, Integer hp, Integer power) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.power = power;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", power=" + power +
                '}';
    }
}
