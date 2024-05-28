package com.generation.lojadegames.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity //classe vai se tornar uma entidade do banco de dados
@Table(name="tb_produtos")//nomeando a tabela no banco de dados de tb_postagens
public class Produto {
		
		@Id //tornar o campo uma chave primaria no banco de dados
		@GeneratedValue(strategy=GenerationType.IDENTITY)//tornando a chave primaria auto increment
		private Long id;
		
		@NotBlank(message = "O atributo nome é obrigatório!")//validation - validar nosso atributo NN e também não vazio
		@Size(min = 5, max = 100, message="O atributo nome deve ter no mínimo 5 caracteres e no máximo 100 caracteres.")
		private String nome;
		
		@NotBlank(message="O atributo descrição é obrigatório!")
		@Size(min = 10, max = 1000,  message = "O atributo descrição deve ter no mínimo 10 caracteres e no máximo 1000 caracteres")
		private String descricao;
		
		private Long quantidade;
		
		@NotNull(message="O atributo preço é obrigatório")
		private float preco;
		
		@ManyToOne
		@JsonIgnoreProperties("produto")
		private Categoria categoria;
		
		
		//geramos os getteres and setteres dos atributos para conseguir recuperar e inserir dados nos atributos

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public float getPreco() {
			return preco;
		}

		public void setPreco(float preco) {
			this.preco = preco;
		}

		public Long getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(Long quantidade) {
			this.quantidade = quantidade;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}


	}