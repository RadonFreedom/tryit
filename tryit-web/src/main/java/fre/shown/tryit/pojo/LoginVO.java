package fre.shown.tryit.pojo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Radon Freedom
 * created at 2019.02.14 19:33
 */

public class LoginVO {
    private Boolean success;

    public LoginVO() {
    }

    public LoginVO(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LoginVO loginVO = (LoginVO) o;

        return new EqualsBuilder()
                .append(getSuccess(), loginVO.getSuccess())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getSuccess())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "success=" + success +
                '}';
    }
}
