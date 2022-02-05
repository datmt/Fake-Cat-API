package com.datmt.fake_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cat {
    int id;
    String name;
    String breed;
    String color;
    String avatar;
}
