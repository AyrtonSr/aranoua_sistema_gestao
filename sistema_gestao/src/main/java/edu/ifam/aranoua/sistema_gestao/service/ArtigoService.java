package edu.ifam.aranoua.sistema_gestao.service;

import edu.ifam.aranoua.sistema_gestao.dto.ArtigoInputDTO;
import edu.ifam.aranoua.sistema_gestao.dto.ArtigoOutPutDTO;
import edu.ifam.aranoua.sistema_gestao.repository.AutorRepository;
import edu.ifam.aranoua.sistema_gestao.repository.RevistaCientificaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.ifam.aranoua.sistema_gestao.model.Artigo;
import edu.ifam.aranoua.sistema_gestao.model.Autor;
import edu.ifam.aranoua.sistema_gestao.repository.ArtigoRepository;
@Service
public class ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private RevistaCientificaRepository revistaCientificaRepository;

    public List<ArtigoOutPutDTO> list(){
        List<Artigo> artigos = artigoRepository.findAll();
        List<ArtigoOutPutDTO> artigoOutPutDTOs = new ArrayList<>();

        for (Artigo artigo:artigos){
            artigoOutPutDTOs.add(new ArtigoOutPutDTO(artigo));
        }
        return artigoOutPutDTOs.isEmpty() ? null : artigoOutPutDTOs;
    }

    public ArtigoOutPutDTO getById(Long id){
        Optional<Artigo> possivelArtigo = artigoRepository.findById(id);
        return possivelArtigo.map(ArtigoOutPutDTO::new).orElse(null);
    }

    public ArtigoOutPutDTO create(ArtigoInputDTO artigoInputDTO){
        try {
            Artigo novoArtigo = artigoInputDTO.build(revistaCientificaRepository,autorRepository);
            Artigo artigoSalvo = artigoRepository.save(novoArtigo);
            return new ArtigoOutPutDTO(artigoSalvo);
        } catch (Exception e) {
            return null;
        }
    }

    public ArtigoOutPutDTO update(Long id, ArtigoInputDTO artigoInputDTO){
        try {
            Optional<Artigo> possivelArtigo = artigoRepository.findById(id);
            if(possivelArtigo.isPresent()){
                Artigo artigo = possivelArtigo.get();
                artigo.setTitulo(artigoInputDTO.getTitulo());
                artigo.setAnopublicacao(artigoInputDTO.getAnopublicacao());

                List<Autor> autores = new ArrayList<>();
                for(String autor : artigoInputDTO.getAutores()){
                    autores.add(autorRepository.findByNome(autor));
                }
                artigo.setAutores(autores);
                artigo.setRevistaCientifica(revistaCientificaRepository.findByNome(artigoInputDTO.getRevistaCientifica()));
                return new ArtigoOutPutDTO(artigoRepository.save(artigo));
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<ArtigoOutPutDTO> findByAutor(Long id){
        List<Artigo> artigos = autorRepository.findById(id).get().getArtigos();
        List<ArtigoOutPutDTO> artigoOuputDTOs = new ArrayList<>();
        for (Artigo artigo : artigos) {
            artigoOuputDTOs.add(new ArtigoOutPutDTO(artigo));
        }
        return artigoOuputDTOs;
    }

    public void delete(Long id){
        try{
            artigoRepository.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
