package br.com.crud.backend.controle;

import br.com.crud.backend.modelo.ProdutoModelo;
import br.com.crud.backend.modelo.RespostaModelo;
import br.com.crud.backend.servico.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoControle {

    @Autowired
    private ProdutoServico ps;

    @GetMapping("/")
    public String rota(){
        return "API de produto funcionando!";
    }

    @GetMapping("/listar-produtos")
    public Iterable<ProdutoModelo> listar(){
        return ps.listar();
    }

    @PostMapping("/cadastrar-produtos")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterar(pm, "cadastrar");
    }

    @PutMapping("/alterar-produtos")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterar(pm, "alterar");
    }

    @DeleteMapping("/deletar-produtos/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo){
        return ps.remover(codigo);
    }


}
