package com.children.gernater;

import com.children.gernater.core.DataGen;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;

@Getter
@Setter
public class DataGenAttr {
    private Field   field;
    private DataGen dataGen;
}