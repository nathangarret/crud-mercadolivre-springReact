package br.com.crud.backend.servico;

import br.com.crud.backend.modelo.ProdutoModelo;
import br.com.crud.backend.modelo.RespostaModelo;
import br.com.crud.backend.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio pr;

    @Autowired
    private RespostaModelo rm;

    // Método para listar todos os produtos
    public Iterable<ProdutoModelo> listar(){
        return pr.findAll();
    };

    // Método para cadastrar produtos uo
    // Método para alterar produtos
    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm, String acao){
        if(pm.getNome().equals("")){
            rm.setMensagem("O nome do produto é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(pm.getMarca().equals("")){
            rm.setMensagem("O nome da marca é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);
            }
        }

    }

    // Método para remover produtos
    public ResponseEntity<RespostaModelo> remover(long codigo){
        pr.deleteById(codigo);
        rm.setMensagem("O produto foi removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);

    }

}