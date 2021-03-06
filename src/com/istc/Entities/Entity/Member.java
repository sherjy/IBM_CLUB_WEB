package com.istc.Entities.Entity;
/**--------------------------------------------------------------------------------
 *
 * proxy,权限管理
 * 把权限管理集中起来
 * 作为M层的安全机制
 *
 * C->接口，修改部门信息(主席)->proxy,判定权限，M层查询(匹配用户名和密码，查询权限)，如果均匹配，正常执行
 * 如果条件不满足，抛出illegalAccess
 * Java有一个Proxy类，叫代理，invoke(Method,args)->modify
 * 1.对象继承层次，只有chairman 对象可以
 * 2.给定的其他条件(咱们定义的权限)
 *
 * 所有的权限管理都放在proxy里
 *
 * */
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lurui on 2016/11/20 0020.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Member extends Person {

    @ManyToMany(fetch = FetchType.LAZY )//猜测？有mappedBy的一方是多对多关系中不维护关系的一方 正确
    @JoinTable(name = "dept_member",joinColumns = {@JoinColumn(name = "mem_id")},
    inverseJoinColumns = {@JoinColumn(name = "dept_id")})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<Department> enterDepts;

    //多对多中如果设置为级联是save_update, 则会将集合中的数据作为数据库中没有的数据进行插入
    //这样，在甲方保存时，乙方不但会被保存在关系表，还会被重新插入，这可能导致乙方表中出现重复主键的错误
    @ManyToMany
    @JoinTable(name = "register_member",
            joinColumns = {@JoinColumn(name = "member_id")},
            inverseJoinColumns ={@JoinColumn(name = "register_dept"),@JoinColumn(name = "register_times")} )
    private Set<Register> registerRecords;

    @OneToMany( fetch = FetchType.LAZY)
    @JoinColumn(name = "member_homeWork")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<HomeWork> homeWorks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        if (!super.equals(o)) return false;

        Member member = (Member) o;

        if (enterDepts != null ? !enterDepts.equals(member.enterDepts) : member.enterDepts != null) return false;
        if (registerRecords != null ? !registerRecords.equals(member.registerRecords) : member.registerRecords != null)
            return false;
        return homeWorks != null ? homeWorks.equals(member.homeWorks) : member.homeWorks == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return result;
    }

    public Member() {
    }

    public Set<Register> getRegisterRecords() {
        return registerRecords;
    }

    public void setRegisterRecords(Set<Register> registerRecords) {
        this.registerRecords = registerRecords;
    }

    public Set<Department> getEnterDepts() {
        return enterDepts;
    }

    public void setEnterDepts(Set<Department> enterDepts) {
        this.enterDepts = enterDepts;
    }

    public Set<HomeWork> getHomeWorks() {
        return homeWorks;
    }

    public void setHomeWorks(Set<HomeWork> homeWorks) {
        this.homeWorks = homeWorks;
    }

    public Set<Department> getManageDepts() {
        return enterDepts;
    }

    public void setManageDepts(Set<Department> manageDepts) {
        this.enterDepts = manageDepts;
    }

    public void addDepartment(Department department){
        if(this.enterDepts == null)this.enterDepts = new HashSet<Department>();
        this.enterDepts.add(department);
    }
    public void addDepartments(Department[] departments){
        for(Department dept: departments)
        this.enterDepts.add(dept);
    }
    @Override
    public String toString() {
        return super.toString() + "Member{" +
                "authority=" + authority +
                ", enterDepts=" + enterDepts +
                ", registerRecords=" + registerRecords +
                ", homeWorks=" + homeWorks +
                '}';
    }
}
