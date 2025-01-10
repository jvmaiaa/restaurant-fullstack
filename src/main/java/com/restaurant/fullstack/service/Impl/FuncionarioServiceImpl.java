package com.restaurant.fullstack.service.Impl;

import com.restaurant.fullstack.domain.dto.request.FuncionarioRequestDTO;
import com.restaurant.fullstack.domain.dto.response.FuncionarioResponseDTO;
import com.restaurant.fullstack.domain.entity.FuncionarioEntity;
import com.restaurant.fullstack.domain.mapper.FuncionarioMapper;
import com.restaurant.fullstack.infra.exception.DadoInvalidoException;
import com.restaurant.fullstack.infra.exception.EntityNotFoundException;
import com.restaurant.fullstack.repository.FuncionarioRepository;
import com.restaurant.fullstack.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Override
    @Transactional
    public FuncionarioResponseDTO cadastra(FuncionarioRequestDTO funcionarioRequestDTO) {
        FuncionarioEntity funcionario = FuncionarioMapper.requestToEntity(funcionarioRequestDTO);
        funcionarioRepository.save(funcionario);
        return FuncionarioMapper.entityToResponse(funcionario);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<FuncionarioResponseDTO> buscaPaginada(int pagina, int quantidadeRegistros) {
        Page<FuncionarioEntity> funcionariosPaginados = funcionarioRepository.findAll(PageRequest.of(pagina, quantidadeRegistros));
        return funcionariosPaginados.map(FuncionarioMapper::entityToResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public FuncionarioResponseDTO buscaPorId(Long id) {
        FuncionarioEntity funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entidade não Encontrada"));
        return FuncionarioMapper.entityToResponse(funcionario);
    }

    @Override
    @Transactional
    public FuncionarioResponseDTO atualiza(Long id, FuncionarioRequestDTO funcionarioRequestDTO) {
        FuncionarioEntity funcionario = FuncionarioMapper.requestToEntity(funcionarioRequestDTO);
        atualizaCampos(funcionario, funcionarioRequestDTO);
        return FuncionarioMapper.entityToResponse(funcionarioRepository.save(funcionario));
    }

    @Override
    @Transactional
    public void deleta(Long id) {
        try {
            FuncionarioEntity funcionario = funcionarioRepository.getReferenceById(id);
            funcionarioRepository.delete(funcionario);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("Entidade não Encontrada");
        } catch (DadoInvalidoException ex) {
            throw new DadoInvalidoException("Esse campo não pode ser excluído");
        }
    }

    private void atualizaCampos(FuncionarioEntity entity, FuncionarioRequestDTO request) {
        entity.setCpf(request.getCpf() != null ? request.getCpf() : entity.getCpf());
        entity.setNome(request.getNome() != null ? request.getNome() : entity.getNome());
        entity.setIdade(request.getIdade() != null ? request.getIdade() : entity.getIdade());
        entity.setNumeroDeTelefone(request.getNumeroDeTelefone() != null ? request.getNumeroDeTelefone() : entity.getNumeroDeTelefone());
        entity.setEmail(request.getEmail() != null ? request.getEmail() : entity.getEmail());
        entity.setSenha(request.getSenha() != null ? request.getSenha() : entity.getSenha());
        entity.setSalario(request.getSalario() != null ? request.getSalario() : entity.getSalario());
        entity.setHoraInicioExpediente(request.getHoraInicioExpediente() != null ? request.getHoraInicioExpediente() : entity.getHoraInicioExpediente());
        entity.setHoraFimExpediente(request.getHoraFimExpediente() != null ? request.getHoraFimExpediente() : entity.getHoraFimExpediente());
    }
}
