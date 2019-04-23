package com.example.hospitalward.vo;

import com.example.hospitalward.model.Menu;
import com.example.hospitalward.model.Staff;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper=false)
@Data
public class StaffVO extends Staff {
    private Set<String> roles;
    private Set<String> permissions;
    private List<MenuTree> menu;
}
