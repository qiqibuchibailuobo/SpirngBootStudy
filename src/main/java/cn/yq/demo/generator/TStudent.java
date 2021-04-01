package cn.yq.demo.generator;

import java.io.Serializable;

/**
 * t_student
 * @author 
 */
public class TStudent implements Serializable {
    private String stuId;

    private String classId;

    private String stuName;

    private String stuSex;

    private String stuTelphone;

    private static final long serialVersionUID = 1L;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuTelphone() {
        return stuTelphone;
    }

    public void setStuTelphone(String stuTelphone) {
        this.stuTelphone = stuTelphone;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TStudent other = (TStudent) that;
        return (this.getStuId() == null ? other.getStuId() == null : this.getStuId().equals(other.getStuId()))
            && (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getStuName() == null ? other.getStuName() == null : this.getStuName().equals(other.getStuName()))
            && (this.getStuSex() == null ? other.getStuSex() == null : this.getStuSex().equals(other.getStuSex()))
            && (this.getStuTelphone() == null ? other.getStuTelphone() == null : this.getStuTelphone().equals(other.getStuTelphone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStuId() == null) ? 0 : getStuId().hashCode());
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        result = prime * result + ((getStuName() == null) ? 0 : getStuName().hashCode());
        result = prime * result + ((getStuSex() == null) ? 0 : getStuSex().hashCode());
        result = prime * result + ((getStuTelphone() == null) ? 0 : getStuTelphone().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stuId=").append(stuId);
        sb.append(", classId=").append(classId);
        sb.append(", stuName=").append(stuName);
        sb.append(", stuSex=").append(stuSex);
        sb.append(", stuTelphone=").append(stuTelphone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}