package fre.shown.tryit.pojo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * 与表user关联的DO类。
 *
 * @author Radon Freedom
 * created at 2019.02.13 20:33
 */

public class UserDO {

    private Integer id;
    private String account;
    private String password;
    private String name;

    public UserDO() {
    }

    public UserDO(Integer id, String account, String password, String name) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
    }



    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserDO userDO = (UserDO) o;

        return new EqualsBuilder()
                .append(getId(), userDO.getId())
                .append(getAccount(), userDO.getAccount())
                .append(getPassword(), userDO.getPassword())
                .append(getName(), userDO.getName())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getAccount())
                .append(getPassword())
                .append(getName())
                .toHashCode();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
