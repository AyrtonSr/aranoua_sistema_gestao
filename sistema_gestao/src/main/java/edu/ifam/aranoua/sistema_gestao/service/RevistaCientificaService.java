package edu.ifam.aranoua.sistema_gestao.service;

import edu.ifam.aranoua.sistema_gestao.dto.RevistaCientificaInputDTO;
import edu.ifam.aranoua.sistema_gestao.dto.RevistaCientificaOutPutDTO;
import edu.ifam.aranoua.sistema_gestao.model.RevistaCientifica;
import edu.ifam.aranoua.sistema_gestao.repository.RevistaCientificaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RevistaCientificaService {
    @Autowired
    private RevistaCientificaRepository revistaCientificaRepository;

    public List<RevistaCientificaOutPutDTO> list(){
        List<RevistaCientifica> revistaCientificas = revistaCientificaRepository.findAll();
        List<RevistaCientificaOutPutDTO> revistaCientificaOutPutDTOs = new ArrayList<>();

        for(RevistaCientifica revistaCientifica : revistaCientificas){
            revistaCientificaOutPutDTOs.add(new RevistaCientificaOutPutDTO(revistaCientifica));
        }

        return revistaCientificaOutPutDTOs.isEmpty() ? null : revistaCientificaOutPutDTOs;
    }

    public RevistaCientificaOutPutDTO getById(Long id){
        Optional<RevistaCientifica> possivelRevistaCientifica = revistaCientificaRepository.findById(id);
        return possivelRevistaCientifica.map(RevistaCientificaOutPutDTO::new).orElse(null);
    }

    public RevistaCientificaOutPutDTO create(RevistaCientificaInputDTO revistaCientificaInputDTO){
        try{
            RevistaCientifica novaRevistaCientifica = revistaCientificaInputDTO.build();
            RevistaCientifica revistaCientificaSalva = revistaCientificaRepository.save(novaRevistaCientifica);
            return new RevistaCientificaOutPutDTO(revistaCientificaSalva);
        }catch (Exception e){
            return null;
        }
    }

    public RevistaCientificaOutPutDTO update(Long id, RevistaCientificaInputDTO revistaCientificaInputDTO){
        try{
            Optional<RevistaCientifica> possivelRevistaCientifica = revistaCientificaRepository.findById(id);
            if (possivelRevistaCientifica.isPresent()){
                RevistaCientifica revistaCientificaEncontrada = possivelRevistaCientifica.get();
                revistaCientificaEncontrada.setNome(revistaCientificaInputDTO.getNome());
                revistaCientificaEncontrada.setIssn(revistaCientificaInputDTO.getIssn());
                RevistaCientifica revistaCientificaAtualizada = revistaCientificaRepository.save(revistaCientificaEncontrada);
                return new RevistaCientificaOutPutDTO(revistaCientificaAtualizada);
            }else{
                return null;
            }
        }catch (Exception e){
            return  null;
        }
    }

    public void delete(Long id){
        try {
            revistaCientificaRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
