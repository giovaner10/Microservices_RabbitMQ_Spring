package com.microservices.data.vo;

import com.microservices.controller.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoVO  {


	private Long id;
	
	private String nome;
	
	private Integer estoque;
	
	private double preco;
	
	public static ProdutoVO create(Produto produto) {
		return new ProdutoVO(produto.getId(), produto.getNome(), produto.getEstoque(), produto.getPreco());
	}
	
}
