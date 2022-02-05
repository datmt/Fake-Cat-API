package com.datmt.fake_api.repository;

import com.datmt.fake_api.model.Cat;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.List;

@ApplicationScope
@Component
@Getter
public class CatRepository {

    private List<Cat> allCats;
    public CatRepository() {
        this.allCats = new ArrayList<>();
    }

}
