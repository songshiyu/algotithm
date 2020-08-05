package category.pojo;

import org.omg.CORBA.INTERNAL;

import java.util.Objects;

/**
 * @description:
 * @E-mail: ssy3@meitu.com
 * @create: 2020/8/5 10:16:43
 **/
public class Student implements Comparable<Object>{

    private String name;
    private Integer age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getName(), student.getName()) &&
                Objects.equals(getAge(), student.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public int compareTo(Object o) {
        if (o == null){
            throw new IllegalArgumentException("INPUT OBJECT IS NULL");
        }

        if (!(o instanceof Student)){
            throw new IllegalArgumentException("INPUT OBJECT IS NOT INSTANCE OF STUDENT");
        }

        Student that = (Student)o;

        return this.age.compareTo(that.getAge());
    }
}
