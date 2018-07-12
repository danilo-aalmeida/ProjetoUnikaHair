package br.com.fean.si.poo2.projetounikahair.service.categoriacurso;

import java.util.ArrayList;

import br.com.fean.si.poo2.projetounikahair.dao.categoriacurso.HIBERNATECategoriaCursoDAO;
import br.com.fean.si.poo2.projetounikahair.model.categoriacurso.CategoriaCurso;

public class CategoriaCursoService {
    //JDBCCategoriaCursoDAO categoriaCursoDAO = new JDBCCategoriaCursoDAO();
    HIBERNATECategoriaCursoDAO categoriaCursoDAO = new HIBERNATECategoriaCursoDAO();
    
    
    
    public String inserir (String nome, String descricao){
        CategoriaCurso categoriaCurso= new CategoriaCurso(nome,  descricao);
        //implementar a regra de negócio aqui
        
                    
        String retorno = categoriaCursoDAO.inserir(categoriaCurso);            
        
        return retorno;
    }
    public String editar (int id, String nome, String descricao){
        CategoriaCurso categoriaCurso= new CategoriaCurso(id,nome,  descricao);
        //implementar a regra de negócio aqui
        
        String retorno = categoriaCursoDAO.editar(categoriaCurso);    
        
        
        return retorno;
    }
    public String apagar (int id){
        CategoriaCurso categoriaCurso= new CategoriaCurso(id);
        //implementar a regra de negócio aqui
        
        String retorno = categoriaCursoDAO.apagar(categoriaCurso);    
        
        
        return retorno;
    }
    public ArrayList<CategoriaCurso> listar(String termoPesquisa){
        ArrayList<CategoriaCurso> lista = categoriaCursoDAO.listar(termoPesquisa);
        
        return lista;
    }
}
