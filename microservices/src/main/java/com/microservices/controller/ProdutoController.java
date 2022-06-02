package com.microservices.controller;

import com.microservices.data.vo.ProdutoVO;
import com.microservices.services.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/produto")
@AllArgsConstructor
public class ProdutoController {


    private ProdutoService produtoService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoVO> listar() {
        return produtoService.findAll();
    }


    @GetMapping("/{id}")
    public ProdutoVO buscar(@PathVariable Long id) {

        return produtoService.findById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoVO salvar(@RequestBody @Valid ProdutoVO produtoVO) {

        return produtoService.create(produtoVO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProdutoVO> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoVO produtoVO) {

        produtoVO.setId(id);
        ProdutoVO ProdutoVOAtualizado = produtoService.update(produtoVO);
        return ResponseEntity.ok(ProdutoVOAtualizado);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {

        produtoService.delete(id);
    }




}

