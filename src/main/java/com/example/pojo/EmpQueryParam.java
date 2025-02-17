package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class EmpQueryParam {
    private Integer page;
    private Integer pageSize;
    private String name;
    private Integer age;
    private Integer gender;
    private LocalDate begin;
    private LocalDate end;


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (EmpQueryParam) obj;
        return Objects.equals(this.page, that.page) &&
                Objects.equals(this.pageSize, that.pageSize) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.age, that.age) &&
                Objects.equals(this.gender, that.gender) &&
                Objects.equals(this.begin, that.begin) &&
                Objects.equals(this.end, that.end);
    }
}