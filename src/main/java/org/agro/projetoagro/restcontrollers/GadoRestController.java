package org.agro.projetoagro.restcontrollers;

import org.agro.projetoagro.entities.Gado;
import org.agro.projetoagro.services.GadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/gado")
public class GadoRestController {
    @Autowired
    GadoService gadoService;

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Gado gado) {
        if(gadoService.add(gado) != null)
            return ResponseEntity.ok(gado);
        return ResponseEntity.badRequest().body("Não foi possível cadastrar o gado: " + gado.getGadoNome());
    }

    @PutMapping
    public ResponseEntity<Object> put(@RequestBody Gado gado) {
        Gado existeGado = gadoService.get(gado.getGadoNome());
        if(existeGado != null) {
            Gado gado1 = gadoService.add(gado);
            return ResponseEntity.ok("Gado atualizado com sucesso:\n" + gado1.toString());
        }
        return ResponseEntity.badRequest().body("Não foi possível atualizar o gado: " + gado.getGadoNome() + ".");
    }

    @GetMapping("get-one/{gadoNome}")
    public ResponseEntity<Object> getOne(@PathVariable String gadoNome) {
        Gado gado = gadoService.get(gadoNome);
        if(gado != null)
            return ResponseEntity.ok(gado);
        return ResponseEntity.badRequest().body("Não foi possível encontrar o gado: " + gadoNome + ".");
    }

    @GetMapping("get-all")
    public ResponseEntity<Object> getAll() {
        List<Gado> gados = gadoService.getAll();
        if(!gados.isEmpty())
            return ResponseEntity.ok(gados);
        return ResponseEntity.badRequest().body("Não foi possível recuperar os gados.");
    }

    @DeleteMapping("{gadoNome}")
    public ResponseEntity<Object> delete(@PathVariable String gadoNome) {
        Gado gado = gadoService.get(gadoNome);
        if(gado != null) {
            boolean resultado = gadoService.delete(gado.getGadoNome());
            if(resultado)
                return ResponseEntity.ok("Gado excluído com sucesso: " + gado.getGadoNome() + ".");
            return ResponseEntity.badRequest().body("Não foi possível excluir o gado: " + gado.getGadoNome() + ".");
        }
        return ResponseEntity.badRequest().body("Não foi possível encontrar o gado: " + gadoNome + ".");
    }
}
