package org.agro.projetoagro.restcontrollers;

import org.agro.projetoagro.entities.Pasto;
import org.agro.projetoagro.services.PastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pasto")
public class PastoRestController {

    @Autowired
    private PastoService pastoService;

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Pasto pasto) {
        try {
            if (pasto.getPastoNome() == null || pasto.getPastoNome().isEmpty()) {
                return ResponseEntity.badRequest().body("Nome do pasto é obrigatório");
            }
            if (pasto.getInvernada() == null) {
                return ResponseEntity.badRequest().body("Invernada é obrigatória");
            }
            Pasto result = pastoService.add(pasto);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar pasto: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> put(@RequestBody Pasto pasto) {
        try {
            Pasto existePasto = pastoService.getOneById(pasto.getPastoId());
            if (existePasto != null) {
                Pasto updated = pastoService.update(pasto);
                return ResponseEntity.ok(updated);
            }
            return ResponseEntity.badRequest().body("Pasto não encontrado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar pasto: " + e.getMessage());
        }
    }

    @GetMapping("get-one/{pastoId}")
    public ResponseEntity<Object> getOne(@PathVariable int pastoId) {
        Pasto pasto = pastoService.getOneById(pastoId);
        if (pasto != null)
            return ResponseEntity.ok(pasto);
        return ResponseEntity.badRequest().body("Pasto não encontrado");
    }

    @GetMapping("invernada/{invernadaId}")
    public ResponseEntity<Object> getByInvernada(@PathVariable int invernadaId) {
        List<Pasto> pastos = pastoService.getAllByInvernada(invernadaId);
        if (!pastos.isEmpty())
            return ResponseEntity.ok(pastos);
        return ResponseEntity.badRequest().body("Nenhum pasto encontrado para esta invernada");
    }

    @GetMapping("get-all")
    public ResponseEntity<Object> getAll() {
        List<Pasto> pastos = pastoService.getAll();
        if (!pastos.isEmpty())
            return ResponseEntity.ok(pastos);
        return ResponseEntity.badRequest().body("Nenhum pasto cadastrado");
    }

    @DeleteMapping("{pastoId}")
    public ResponseEntity<Object> delete(@PathVariable int pastoId) {
        Pasto pasto = pastoService.getOneById(pastoId);
        if (pasto != null) {
            boolean resultado = pastoService.delete(pastoId);
            if (resultado)
                return ResponseEntity.ok("Pasto excluído com sucesso");
            return ResponseEntity.badRequest().body("Erro ao excluir pasto");
        }
        return ResponseEntity.badRequest().body("Pasto não encontrado");
    }
}
