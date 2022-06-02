package com.microservices.controller.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.microservices.data.vo.ProdutoVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6168690423241195980L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private Integer estoque;
	

	private double preco;
	
	
	public static Produto create(ProdutoVO produtoVO) {
		return new Produto(produtoVO.getId(), produtoVO.getNome(), produtoVO.getEstoque(), produtoVO.getPreco());
	}
	
	
}
