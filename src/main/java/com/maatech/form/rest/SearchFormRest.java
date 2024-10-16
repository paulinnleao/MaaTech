package com.maatech.form.rest;

import com.maatech.form.entity.SearchFormRequestDTO;
import org.springframework.http.ResponseEntity;

public interface SearchFormRest {

    //Find the products
    ResponseEntity<?> findTheProductForm(SearchFormRequestDTO form);
}
