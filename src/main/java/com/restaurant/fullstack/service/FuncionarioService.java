package com.restaurant.fullstack.service;

import com.restaurant.fullstack.domain.dto.request.FuncionarioRequestDTO;
import com.restaurant.fullstack.domain.dto.response.FuncionarioResponseDTO;
import org.springframework.data.domain.Page;

public interface FuncionarioService {

    FuncionarioResponseDTO cadastra(FuncionarioRequestDTO funcionarioRequestDTO);

    Page<FuncionarioResponseDTO> buscaPaginada(int pagina, int quantidadeRegistros);

    FuncionarioResponseDTO buscaPorId(Long id);

    FuncionarioResponseDTO atualiza(Long id, FuncionarioRequestDTO funcionarioRequestDTO);

    void deleta(Long id);
}
