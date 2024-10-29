package edu.ifam.aranoua.sistema_gestao.controller;

import edu.ifam.aranoua.sistema_gestao.dto.AutorInputDTO;
import edu.ifam.aranoua.sistema_gestao.dto.AutorOutPutDTO;
import edu.ifam.aranoua.sistema_gestao.model.Autor;
import edu.ifam.aranoua.sistema_gestao.service.AutorService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/autor")
public class AutorController {

    private AutorService autorService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AutorOutPutDTO>> list(){
        List<AutorOutPutDTO> autorOutPutDTOs = autorService.list();
        if(!autorOutPutDTOs.isEmpty()){
            return new ResponseEntity<>(autorOutPutDTOs,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutorOutPutDTO> getById(@PathVariable Long id){
        AutorOutPutDTO possivelAutor = autorService.getById(id);
        if(possivelAutor != null){
            return new ResponseEntity<>(possivelAutor,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutorOutPutDTO> create(@RequestBody AutorInputDTO autorInputDTO){
        AutorOutPutDTO autorSalvoOutputDTO = autorService.create(autorInputDTO);
        if(autorSalvoOutputDTO != null){
            return new ResponseEntity<>(autorSalvoOutputDTO,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutorOutPutDTO> update(@PathVariable Long id, @RequestBody AutorInputDTO autorInputDTO){
        AutorOutPutDTO autorAtualizadoOutPutDTO = autorService.update(id,autorInputDTO);
        if (autorAtualizadoOutPutDTO != null){
            return new ResponseEntity<>(autorAtualizadoOutPutDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        AutorOutPutDTO possivelAutor = autorService.getById(id);
        if (possivelAutor != null) {
            autorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
