package org.agro.projetoagro.restcontrollers;

import org.agro.projetoagro.entities.Invernada;
import org.agro.projetoagro.services.InvernadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/invernada")
public class InvernadaRestController {
    @Autowired
    InvernadaService invernadaService;

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Invernada invernada) {
        if(invernadaService.add(invernada) != null)
            return ResponseEntity.ok(invernada);
        return ResponseEntity.badRequest().body("Não foi possível cadastrar invernada!");
    }

    @PutMapping
    public ResponseEntity<Object> put(@RequestBody Invernada invernada) {
        Invernada existeInvernada = invernadaService.getOneById(invernada.getInvernadaId());
        if(existeInvernada != null) {
            Invernada invernada1 = invernadaService.add(invernada);
            return ResponseEntity.ok("Invernada atualizada com sucesso:\n" + invernada1.toString());
        }
        return ResponseEntity.badRequest().body("Não foi possível atualizar a invernada: " + invernada.getInvernadaNome() + ".");
    }

    @GetMapping("get-one/id/{invernadaId}")
    public ResponseEntity<Object> getOneById(@PathVariable int invernadaId) {
        Invernada invernada = invernadaService.getOneById(invernadaId);
        if(invernada != null)
            return ResponseEntity.ok(invernada);
        return ResponseEntity.badRequest().body("Não foi possível encontrar a invernada de ID: " + invernadaId + ".");
    }

    @GetMapping("get-one/string/{invernadaNome}")
    public ResponseEntity<Object> getOneByNome(@PathVariable String invernadaNome) {
        Invernada invernada = invernadaService.getOneByNome(invernadaNome);
        if(invernada != null)
            return ResponseEntity.ok(invernada);
        return ResponseEntity.badRequest().body("Não foi possível encontrar a invernada: " + invernadaNome + ".");
    }

    @GetMapping("get-all")
    public ResponseEntity<Object> getAll() {
        List<Invernada> invernadas = invernadaService.getAll();
        if(!invernadas.isEmpty())
            return ResponseEntity.ok(invernadas);
        return ResponseEntity.badRequest().body("Não foi possível reucperar as invernadas.");
    }

    @DeleteMapping("{invernadaId}")
    public ResponseEntity<Object> delete(@PathVariable int invernadaId) {
        Invernada invernada = invernadaService.getOneById(invernadaId);
        if(invernada != null) {
            boolean resultado = invernadaService.delete(invernada.getInvernadaId());
            if(resultado)
                return ResponseEntity.ok("Invernada excluída com sucesso: " + invernada.getInvernadaNome() + ".");
            return ResponseEntity.badRequest().body("Não foi possível excluir a invernada: " + invernada.getInvernadaNome() + ".");
        }
        return ResponseEntity.badRequest().body("Não foi possível encontrar a invernada de ID: " + invernadaId + ".");
    }
}
