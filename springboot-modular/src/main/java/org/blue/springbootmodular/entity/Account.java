package org.blue.springbootmodular.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName account
 */
@TableName(value ="account")
@Data
public class Account implements Serializable {
    /**
     * 账户UUID
     */
    @TableId
    private String accountId;

    /**
     * 账户姓名
     */
    private String accountName;

    /**
     * 账户性别
     */
    private String accountSex;

    /**
     * 账户年龄
     */
    private Integer accountAge;

    /**
     * 账户所在地
     */
    private String accountAddress;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
        Account other = (Account) that;
        return (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getAccountName() == null ? other.getAccountName() == null : this.getAccountName().equals(other.getAccountName()))
            && (this.getAccountSex() == null ? other.getAccountSex() == null : this.getAccountSex().equals(other.getAccountSex()))
            && (this.getAccountAge() == null ? other.getAccountAge() == null : this.getAccountAge().equals(other.getAccountAge()))
            && (this.getAccountAddress() == null ? other.getAccountAddress() == null : this.getAccountAddress().equals(other.getAccountAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getAccountName() == null) ? 0 : getAccountName().hashCode());
        result = prime * result + ((getAccountSex() == null) ? 0 : getAccountSex().hashCode());
        result = prime * result + ((getAccountAge() == null) ? 0 : getAccountAge().hashCode());
        result = prime * result + ((getAccountAddress() == null) ? 0 : getAccountAddress().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", accountId=").append(accountId);
        sb.append(", accountName=").append(accountName);
        sb.append(", accountSex=").append(accountSex);
        sb.append(", accountAge=").append(accountAge);
        sb.append(", accountAddress=").append(accountAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}