package org.yobatis.entity.base;

// WARNING - @mbg.generated
// This file is automatically generated by MyBatis Generator, do not modify.
public abstract class BaseEmployee {
    protected Long id;

    protected String name;

    protected String phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append("]");
        return sb.toString();
    }
}