package edu.ifam.aranoua.sistema_gestao.controller;

import edu.ifam.aranoua.sistema_gestao.dto.RevistaCientificaInputDTO;
import edu.ifam.aranoua.sistema_gestao.dto.RevistaCientificaOutPutDTO;
import edu.ifam.aranoua.sistema_gestao.service.RevistaCientificaService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/revistacientifica")
public class RevistaCientificaController {
    @Autowired
    private RevistaCientificaService revistaCientificaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RevistaCientificaOutPutDTO>> list(){
        List<RevistaCientificaOutPutDTO> revistaCientificaOutPutDTOs = revistaCientificaService.list();
        if (!revistaCientificaOutPutDTOs.isEmpty()){
            return new ResponseEntity<>(revistaCientificaOutPutDTOs, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RevistaCientificaOutPutDTO> getById(@PathVariable Long id){
        RevistaCientificaOutPutDTO possivelRevistaCientificaOutPutDTO = revistaCientificaService.getById(id);
        if(possivelRevistaCientificaOutPutDTO != null){
            return new ResponseEntity<>(possivelRevistaCientificaOutPutDTO,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<RevistaCientificaOutPutDTO> create(@RequestBody RevistaCientificaInputDTO revistaCientificaInputDTO){
        RevistaCientificaOutPutDTO revistaCientificaOutPutDTOsalvo =  revistaCientificaService.create(revistaCientificaInputDTO);
        if(revistaCientificaOutPutDTOsalvo != null){
            return new ResponseEntity<>(revistaCientificaOutPutDTOsalvo, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RevistaCientificaOutPutDTO> update(@PathVariable Long id, @RequestBody RevistaCientificaInputDTO revistaCientificaInputDTO){
        RevistaCientificaOutPutDTO revistaCientificaOutPutDTOatualziada = revistaCientificaService.update(id,revistaCientificaInputDTO);
        if (revistaCientificaOutPutDTOatualziada != null) {
            return new ResponseEntity<>(revistaCientificaOutPutDTOatualziada,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        RevistaCientificaOutPutDTO revistaCientificaOutPutDTOpossivel = revistaCientificaService.getById(id);
        if (revistaCientificaOutPutDTOpossivel != null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}