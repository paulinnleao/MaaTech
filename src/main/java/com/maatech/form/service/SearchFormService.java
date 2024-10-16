package com.maatech.form.service;

import com.maatech.form.entity.SearchFormRequestDTO;
import org.springframework.http.ResponseEntity;

public interface SearchFormService {

    ResponseEntity<?> findTheProductForm(SearchFormRequestDTO form);
}
