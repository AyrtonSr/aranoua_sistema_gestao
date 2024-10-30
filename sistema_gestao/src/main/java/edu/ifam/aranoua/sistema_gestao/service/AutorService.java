package edu.ifam.aranoua.sistema_gestao.service;

import edu.ifam.aranoua.sistema_gestao.dto.AutorInputDTO;
import edu.ifam.aranoua.sistema_gestao.dto.AutorOutPutDTO;
import edu.ifam.aranoua.sistema_gestao.model.Autor;
import edu.ifam.aranoua.sistema_gestao.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<AutorOutPutDTO> list(){
        List<Autor> autores = autorRepository.findAll();
        List<AutorOutPutDTO> autorOutPutDTOs = new ArrayList<>();

        for (Autor autor:autores){
            autorOutPutDTOs.add(new AutorOutPutDTO(autor));
        }
        return autorOutPutDTOs.isEmpty() ? null : autorOutPutDTOs;
    }

    public AutorOutPutDTO getById(Long id){
        Optional<Autor> possivelAutor = autorRepository.findById(id);
        return possivelAutor.map(AutorOutPutDTO::new).orElse(null);
    }

    public AutorOutPutDTO create(AutorInputDTO autorInputDTO){
        try{
            Autor novoAutor = autorInputDTO.build();
            Autor autorSalvo = autorRepository.save(novoAutor);
            return new AutorOutPutDTO(autorSalvo);
        }catch (Exception e){
            return null;
        }

    }

    public AutorOutPutDTO update(Long id, AutorInputDTO autorInputDTO){
        try{
            Optional<Autor> possivelAutor = autorRepository.findById(id);
            if (possivelAutor.isPresent()){
                Autor autorEncontrado =  possivelAutor.get();
                autorEncontrado.setNome(autorInputDTO.getNome());
                autorEncontrado.setInstituicao(autorInputDTO.getInstituicao());

                Autor autorAtualizado = autorRepository.save(autorEncontrado);
                return new AutorOutPutDTO(autorAtualizado);
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    public void delete(Long id){
        try{
            autorRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
