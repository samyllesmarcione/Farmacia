package com.generation.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class ProdutosFarmacia {
	@Entity
	@Table(name="tb_produtos")

	public class Produtos {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotBlank(message= "Esse campo é obrigatório!")
		@Size(max=500)
		private String nomeProduto;
		
		@NotBlank(message= "Esse campo é obrigatório!")
		@Size(max=3000)
		private String descricaoProduto;
		
		@NotBlank(message= "Esse campo é obrigatório!")
		private float valorProduto;
		
		@NotBlank(message= "Esse campo é obrigatório!")
		@Size(max=1000)
		private String fotoProduto;
		
		@NotBlank(message= "Esse campo é obrigatório!")
		private int estoqueProduto;
		
		@NotBlank(message= "Esse campo é obrigatório!")
		@Size(max=1000)
		private String laboratorioProduto;
		
		@ManyToOne
		@JsonIgnoreProperties("produto")
		private Categoria categoria;

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNomeProduto() {
			return nomeProduto;
		}

		public void setNomeProduto(String nomeProduto) {
			this.nomeProduto = nomeProduto;
		}

		public String getDescricaoProduto() {
			return descricaoProduto;
		}

		public void setDescricaoProduto(String descricaoProduto) {
			this.descricaoProduto = descricaoProduto;
		}

		public float getValorProduto() {
			return valorProduto;
		}

		public void setValorProduto(float valorProduto) {
			this.valorProduto = valorProduto;
		}

		public String getFotoProduto() {
			return fotoProduto;
		}

		public void setFotoProduto(String fotoProduto) {
			this.fotoProduto = fotoProduto;
		}

		public int getEstoqueProduto() {
			return estoqueProduto;
		}

		public void setEstoqueProduto(int estoqueProduto) {
			this.estoqueProduto = estoqueProduto;
		}

		public String getLaboratorioProduto() {
			return laboratorioProduto;
		}

		public void setLaboratorioProduto(String laboratorioProduto) {
			this.laboratorioProduto = laboratorioProduto;
		}
		
		
		}
}
