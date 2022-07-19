package com.mirceanealcos.confruntarea.entity;

public class UC_Link {
    private Long user_id;
    private Long champion_id;

    public UC_Link() {
    }

    public UC_Link(Long user_id, Long champion_id) {
        this.user_id = user_id;
        this.champion_id = champion_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getChampion_id() {
        return champion_id;
    }

    public void setChampion_id(Long champion_id) {
        this.champion_id = champion_id;
    }

    @Override
    public String toString() {
        return "UC_Link{" +
                "user_id=" + user_id +
                ", champion_id=" + champion_id +
                '}';
    }
}
