package com.maatech.form.rest;

import com.maatech.form.entity.SearchFormRequestDTO;
import com.maatech.form.service.SearchFormServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search-form")
public class SearchFormRestImp implements SearchFormRest{

    @Autowired
    private SearchFormServiceImp service;

    @Operation(
            summary = "Busca produtos com base no formulário do usuário",
            description = "Recebe os dados do formulário e retorna uma lista de produtos recomendados pela IA Gemini."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados do formulário inválidos")
    })
    @PostMapping
    public ResponseEntity<?> findTheProductForm(@RequestBody SearchFormRequestDTO form) {
        return service.findTheProductForm(form);
    }
}
