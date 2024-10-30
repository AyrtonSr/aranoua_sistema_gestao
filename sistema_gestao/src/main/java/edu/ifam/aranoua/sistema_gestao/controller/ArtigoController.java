package edu.ifam.aranoua.sistema_gestao.controller;

import edu.ifam.aranoua.sistema_gestao.dto.ArtigoInputDTO;
import edu.ifam.aranoua.sistema_gestao.dto.ArtigoOutPutDTO;
import edu.ifam.aranoua.sistema_gestao.dto.AutorOutPutDTO;
import edu.ifam.aranoua.sistema_gestao.service.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artigo")
public class ArtigoController {

    @Autowired
    private ArtigoService artigoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtigoOutPutDTO>> list() {
        List<ArtigoOutPutDTO> artigoOutPutDTOs = artigoService.list();
        if (!artigoOutPutDTOs.isEmpty()) {
            return new ResponseEntity<>(artigoOutPutDTOs, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArtigoOutPutDTO> getById(@PathVariable Long id) {
        ArtigoOutPutDTO artigoOutputDTO = artigoService.getById(id);
        if (artigoOutputDTO != null) {
            return new ResponseEntity<>(artigoOutputDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ArtigoOutPutDTO> create(@RequestBody ArtigoInputDTO artigoInputDTO) {
        ArtigoOutPutDTO artigoSalvoOutputDTO = artigoService.create(artigoInputDTO);
        if (artigoSalvoOutputDTO != null){
            return new ResponseEntity<>(artigoSalvoOutputDTO,HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<ArtigoOutPutDTO> update(@PathVariable Long id, @RequestBody ArtigoInputDTO artigoInputDTO) {
        ArtigoOutPutDTO artigoAtualizadoOutputDTO = artigoService.update(id, artigoInputDTO);
        if (artigoAtualizadoOutputDTO != null){
            return new ResponseEntity<>(artigoAtualizadoOutputDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ArtigoOutPutDTO possivelArtigo = artigoService.getById(id);
        if (possivelArtigo != null) {
            artigoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
