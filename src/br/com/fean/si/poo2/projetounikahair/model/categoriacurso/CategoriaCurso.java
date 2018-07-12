package br.com.fean.si.poo2.projetounikahair.model.categoriacurso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*
* @author jordan
*/

@Entity
@Table(name = "categoriacurso")
public class CategoriaCurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
   private int id;
	
	@Column (name = "nome")
   private String nome;
	
	@Column (name = "descricao")
   private String descricao;

   public CategoriaCurso(String nome, String descricao) {
       this.nome = nome;
       this.descricao = descricao;
   }

   public int getId() {
       return id;
   }

   public void setId(int id) {
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

   public CategoriaCurso(int id, String nome, String descricao) {
       this.id = id;
       this.nome = nome;
       this.descricao = descricao;
   }
   
    public CategoriaCurso(int id) {
       this.id = id;
       
   }
   
   
   
   
}
