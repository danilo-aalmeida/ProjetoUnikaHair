package br.com.fean.si.poo2.projetounikahair.controller.categoriacurso;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.fean.si.poo2.projetounikahair.model.categoriacurso.CategoriaCurso;
import br.com.fean.si.poo2.projetounikahair.service.categoriacurso.CategoriaCursoService;
import br.com.fean.si.poo2.projetounikahair.view.categoriacurso.PainelCategoriaCurso;

public class CategoriaCursoController implements ActionListener {
    PainelCategoriaCurso painel = null;
    CategoriaCursoService categoriaCursoService = new CategoriaCursoService();
    int idSelecionado = 0;
    public CategoriaCursoController (PainelCategoriaCurso painelCategoriaCurso){
        painel = painelCategoriaCurso;
        painel.getBotSalvar().addActionListener(this);
        painel.getBotPesquisar().addActionListener(this);
        painel.getBotCancelar().addActionListener(this);
        painel.getBotApagar().addActionListener(this);
        painel.getBotNovo().addActionListener(this);
        painel.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent evt) {
                  // Implementação.
                  JOptionPane.showMessageDialog(null, "Tecla "+evt.getKeyCode()+" foi pressionada");
            }
        });
        
        // Quando uma tecla for pressionada (Nesse exemplo escolhi a tecla 'B').
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
            .addKeyEventDispatcher(new KeyEventDispatcher() {
                @Override
                public boolean dispatchKeyEvent(KeyEvent event) {
                    if(event.getID() == KeyEvent.KEY_RELEASED 
                       && event.getKeyCode() == KeyEvent.VK_DELETE){
                          // JOptionPane.showMessageDialog(null,"foi1");
                           clicouApagar();
                     }
                    
                     return false;
                }
        }); 
        painel.getTabTabela().addMouseListener(new MouseAdapter(){
            @SuppressWarnings("unused")
			private int linha;
            @SuppressWarnings("unused")
			private int coluna;
            @Override  
            public void mouseClicked(MouseEvent e) {  
                    linha = painel.getTabTabela().getSelectedRow();  
                    coluna = painel.getTabTabela().getSelectedColumn(); 
                    painel.getTabTabela().getColumnName(1);
                    //System.out.println(painel.getTabTabela().getColumnName(1));
                    String id=(String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 0);
                    String nome=(String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 1);
                    String email=(String) painel.getTabTabela().getValueAt(painel.getTabTabela().getSelectedRow(), 2);
                  //JOptionPane.showMessageDialog(null,"id = "+id+
                  //          " nome = "+nome+" email = "+email);
                  painel.getTexNome().setText(nome);
                  painel.getTexDescricao().setText(email);
                  idSelecionado = Integer.parseInt(id);
                  alterarStatusBotoesCampos(true,true,false,true, true, true,false);        
            }  
        });
        carregarDadosTabela();
        alterarStatusBotoesCampos(false,false,true,false, false, false,true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(null,"clicou");
        if (ae.getSource()==painel.getBotSalvar()){
            if (idSelecionado==0){
                inserir();
            }else{
                editar();
            }
            carregarDadosTabela();
            alterarStatusBotoesCampos(false,false,true,false, false, false,true);
        }else if (ae.getSource()==painel.getBotPesquisar()){
            pesquisar();
        }else if (ae.getSource()==painel.getBotNovo()){
            alterarStatusBotoesCampos(true,true,false,false, true, true,true);
        }else if (ae.getSource()==painel.getBotApagar()){
            clicouApagar();
        }else if (ae.getSource()==painel.getBotCancelar()){
            alterarStatusBotoesCampos(false,false,true,false, false, false,true);
        }
        

        
    }
    public void clicouApagar(){
        if (idSelecionado!=0){
                    apagar();
            carregarDadosTabela();
            alterarStatusBotoesCampos(false,false,true,false, false, false,true);
        }else{
            JOptionPane.showMessageDialog(null,"Para apagar você precisa selecionar uma linha na tabela");
        }
        
    }
    public void alterarStatusBotoesCampos(boolean campo1,
            boolean campo2, boolean novo, boolean apagar,
            boolean salvar, boolean cancelar, boolean limpaCampos){
        painel.getTexNome().setEnabled(campo1);
        painel.getTexDescricao().setEnabled(campo2);
        painel.getBotNovo().setVisible(novo);
        painel.getBotApagar().setVisible(apagar);
        painel.getBotSalvar().setVisible(salvar);
        painel.getBotCancelar().setVisible(cancelar);
        if (limpaCampos){
            idSelecionado=0;
            painel.getTexNome().setText("");
            painel.getTexDescricao().setText("");
        }
    }
    public void inserir(){
        String ret = "";
        try {
            
        ret = categoriaCursoService.inserir(painel.getTexNome().getText(), painel.getTexDescricao().getText());
        
        JOptionPane.showMessageDialog(null,ret);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ret);
        } 
    }
    public void editar(){
        String ret = "";
        try {
            
         ret = categoriaCursoService.editar(idSelecionado, painel.getTexNome().getText(), painel.getTexDescricao().getText());
       
        JOptionPane.showMessageDialog(null,ret);
        

        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null,ret);
        } 
    }
    
    public void apagar(){
        String ret = "";
        try {
            
            
      int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar a linha selecionada ?", "Informe", JOptionPane.YES_NO_OPTION);

      if (resposta == JOptionPane.YES_OPTION) {   
        ret = categoriaCursoService.apagar(idSelecionado);
       
        JOptionPane.showMessageDialog(null,ret);
      }

        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null,ret);
        } 
    }
    
    
    public void pesquisar(){
        painel.getModelo().setRowCount(0);
        ArrayList<CategoriaCurso> lista =new ArrayList<CategoriaCurso>();
        lista = categoriaCursoService.listar(painel.getTexPesquisa().getText());
        try {
            for(CategoriaCurso categoriaCurso:lista){
                //JOptionPane.showMessageDialog(null,"nome: "+rs.getString("nome") + " EMAIL: "+rs.getString("email"));
                painel.getModelo().addRow(new String[]{categoriaCurso.getId()+"", categoriaCurso.getNome(), categoriaCurso.getDescricao()});
            }
                
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro "+e);
        }
    }
    
    public void carregarDadosTabela(){
        painel.getModelo().setRowCount(0);
        ArrayList<CategoriaCurso> lista =new ArrayList<CategoriaCurso>();
        lista = categoriaCursoService.listar("");
       
        try {
            for(CategoriaCurso categoriaCurso:lista){
                //JOptionPane.showMessageDialog(null,"nome: "+rs.getString("nome") + " EMAIL: "+rs.getString("email"));
                painel.getModelo().addRow(new String[]{categoriaCurso.getId()+"", categoriaCurso.getNome(), categoriaCurso.getDescricao()});
            }
                
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro "+e);
        }
        
    }

}
