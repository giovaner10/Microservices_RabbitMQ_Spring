package com.microservices.services;

import com.microservices.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

import com.microservices.data.vo.ProdutoVO;
import com.microservices.entity.Produto;
import com.microservices.repository.ProdutoRepository;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoVO findById(Long id){
        if(!produtoRepository.existsById(id)){
            throw new BadRequestException("Produto não encontrado");
        }

        return ProdutoVO.create(produtoRepository.findById(id).get());
    }

    public ProdutoVO create(ProdutoVO produtoVO) {
        Produto salvoProduto = produtoRepository.save(Produto.create(produtoVO));
        return ProdutoVO.create(salvoProduto);
    }

    public List<ProdutoVO> findAll() {
        return produtoRepository.findAll().stream().map(produto -> ProdutoVO.create(produto)).collect(Collectors.toList());
    }


    public ProdutoVO update(ProdutoVO produtoVO) {
        findById(produtoVO.getId());
        Produto salvoProduto = produtoRepository.save(Produto.create(produtoVO));
        return ProdutoVO.create(salvoProduto);
    }


    public void delete(Long id) {
        findById(id);

        produtoRepository.deleteById(id);
    }


}
