package com.rts.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Role extends BasePojo {

    private String roleName;

public void setRoleName(String roleName) {
    this.roleName = roleName;
}

public String getRoleName() {
    return roleName;
}

}
