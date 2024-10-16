package com.maatech.form.rest;

import com.maatech.form.entity.SearchFormRequestDTO;
import com.maatech.form.service.SearchFormServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search-form")
public class SearchFormRestImp implements SearchFormRest{

    @Autowired
    private SearchFormServiceImp service;

    @GetMapping
    public ResponseEntity<?> findTheProductForm(SearchFormRequestDTO form) {
        return service.findTheProductForm(form);
    }
}
