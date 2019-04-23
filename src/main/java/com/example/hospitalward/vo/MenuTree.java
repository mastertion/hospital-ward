package com.example.hospitalward.vo;

import com.example.hospitalward.model.Menu;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper=false)
@Data
public class MenuTree extends Menu {
    private List<Menu> children;
}
