package com.restaurant.fullstack.controller;

import com.restaurant.fullstack.domain.dto.request.FuncionarioRequestDTO;
import com.restaurant.fullstack.domain.dto.response.FuncionarioResponseDTO;
import com.restaurant.fullstack.service.FuncionarioService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {


    private final FuncionarioService funcionarioService;


    @PostMapping("/gerente")
    @ResponseStatus(CREATED)
    public FuncionarioResponseDTO cadastraGerente(@Valid @RequestBody FuncionarioRequestDTO funcionarioRequestDTO,
                                           @NotNull HttpServletResponse response) {
        FuncionarioResponseDTO funcionarioEntity = funcionarioService.cadastra(funcionarioRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(funcionarioEntity.getId())
                .toUri();
        response.setHeader("Location", uri.toString());
        return funcionarioEntity;
    }

    @GetMapping
    @ResponseStatus(OK)
    public Page<FuncionarioResponseDTO> buscaPaginada(@RequestParam int pagina,
                                                      @RequestParam int quantidadeRegistros) {
        return funcionarioService.buscaPaginada(pagina, quantidadeRegistros);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public FuncionarioResponseDTO buscaGerentePorId(@PathVariable Long id) {
        return funcionarioService.buscaPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public FuncionarioResponseDTO atualizaGerente(@PathVariable Long id,
                                                  @RequestBody FuncionarioRequestDTO funcionarioRequestDTO){
        return funcionarioService.atualiza(id, funcionarioRequestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletaGerente(@PathVariable Long id){
        funcionarioService.deleta(id);
    }

}
