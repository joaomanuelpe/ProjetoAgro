package org.agro.projetoagro.restcontrollers;

import org.agro.projetoagro.entities.Fazenda;
import org.agro.projetoagro.services.FazendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/fazenda")
public class FazendaRestController {

    @Autowired
    FazendaService fazendaService;

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Fazenda fazenda) {
        if(fazendaService.add(fazenda) != null) {
            return ResponseEntity.ok(fazenda);
        }
        return ResponseEntity.badRequest().body("Não foi possível cadastrar fazenda!");
    }

    @PutMapping
    public ResponseEntity<Object> put(@RequestBody Fazenda fazenda) {
        Fazenda existeFazenda = fazendaService.getOneById(fazenda.getFazendaId());
        if(existeFazenda != null) {
            Fazenda fazenda1 = fazendaService.add(fazenda);
            return ResponseEntity.ok("Fazenda atualizada com sucesso:\n " + fazenda.toString());
        }
        return ResponseEntity.badRequest().body("Não foi possível atualizar fazenda: " + fazenda.getFazendaNome() + ".");
    }

    @GetMapping("get-one/id/{fazendaId}")
    public ResponseEntity<Object> getOneById(@PathVariable int fazendaId) {
        Fazenda fazenda = fazendaService.getOneById(fazendaId);
        if(fazenda != null)
            return ResponseEntity.ok(fazenda);
        return ResponseEntity.badRequest().body("Não foi possívelencontrar fazenda de ID: " + fazendaId +  ".");
    }

    @GetMapping("get-one/string/{fazendaNome}")
    public ResponseEntity<Object> getByNome(@PathVariable String fazendaNome) {
        Fazenda fazenda = fazendaService.getOneByNome(fazendaNome);
        if(fazenda != null)
            return ResponseEntity.ok(fazenda);
        return ResponseEntity.badRequest().body("Não foi possível encontrar a fazenda: " + fazendaNome + ".");
    }

    @GetMapping("get-all")
    public ResponseEntity<Object> getAll() {
        List<Fazenda> fazendas = fazendaService.getAll();
        if(!fazendas.isEmpty())
            return ResponseEntity.ok(fazendas);
        return ResponseEntity.badRequest().body("Não foi possível recuperar as fazendas.");
    }

    @DeleteMapping("{fazendaId}")
    public ResponseEntity<Object> delete(@PathVariable int fazendaId) {
        Fazenda fazenda = fazendaService.getOneById(fazendaId);
        if (fazenda != null) {
            boolean resultado = fazendaService.delete(fazenda.getFazendaId());
            if(resultado)
                return ResponseEntity.ok("Fazenda excluída com sucesso: " + fazenda.getFazendaNome() + ".");
            return ResponseEntity.badRequest().body("Não foi possível excluir a fazenda: " + fazenda.getFazendaNome() + ".");
        }
        return ResponseEntity.badRequest().body("Não foi possível encontrar a fazenda de ID: " + fazendaId + ".");
    }

}
