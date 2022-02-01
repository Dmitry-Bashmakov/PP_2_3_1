package crud.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "first_lesson_database", catalog = "")
public class User implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @NotEmpty(message = "Значение не должно быть пустым")
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Basic
    @NotEmpty(message = "Значение не должно быть пустым")
    @Column(name = "lastName", nullable = false, length = 30)
    private String lastName;
    @Basic
    @Column(name = "age", nullable = true)
    @Min(value = 0, message = "Значение должно быть положительным")
    private Integer age;

    public User(int id, String name, String lastName, Integer age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName) && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, age);
    }
}
