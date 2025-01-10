package com.restaurant.fullstack.domain.mapper;

import com.restaurant.fullstack.domain.dto.request.FuncionarioRequestDTO;
import com.restaurant.fullstack.domain.dto.response.FuncionarioResponseDTO;
import com.restaurant.fullstack.domain.entity.FuncionarioEntity;

public class FuncionarioMapper {


    public static FuncionarioEntity requestToEntity(FuncionarioRequestDTO funcionarioRequestDTO){
        if (funcionarioRequestDTO == null){
            return null;
        }
        FuncionarioEntity entity = new FuncionarioEntity();
        entity.setCpf(funcionarioRequestDTO.getCpf());
        entity.setNome(funcionarioRequestDTO.getNome());
        entity.setIdade(funcionarioRequestDTO.getIdade());
        entity.setNumeroDeTelefone(funcionarioRequestDTO.getNumeroDeTelefone());
        entity.setEmail(funcionarioRequestDTO.getEmail());
        entity.setSenha(funcionarioRequestDTO.getSenha());
        entity.setSalario(funcionarioRequestDTO.getSalario());
        entity.setHoraInicioExpediente(funcionarioRequestDTO.getHoraInicioExpediente());
        entity.setHoraFimExpediente(funcionarioRequestDTO.getHoraFimExpediente());
        return entity;
    }

    public static FuncionarioResponseDTO entityToResponse(FuncionarioEntity funcionarioEntity){
        if (funcionarioEntity == null){
            return null;
        }
        FuncionarioResponseDTO responseDTO = new FuncionarioResponseDTO();
        responseDTO.setCpf(funcionarioEntity.getCpf());
        responseDTO.setNome(funcionarioEntity.getNome());
        responseDTO.setIdade(funcionarioEntity.getIdade());
        responseDTO.setNumeroDeTelefone(funcionarioEntity.getNumeroDeTelefone());
        responseDTO.setEmail(funcionarioEntity.getEmail());
        responseDTO.setSalario(funcionarioEntity.getSalario());
        responseDTO.setHoraInicioExpediente(funcionarioEntity.getHoraInicioExpediente());
        responseDTO.setHoraFimExpediente(funcionarioEntity.getHoraFimExpediente());
        responseDTO.setDataInicioAdmissao(funcionarioEntity.getDataInicioAdmissao());
        return responseDTO;
    }
}
