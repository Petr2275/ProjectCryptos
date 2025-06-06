package cz.engeto.ProjectCryptos.Controller;

import cz.engeto.ProjectCryptos.Model.Crypto;
import cz.engeto.ProjectCryptos.Service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cryptos")
public class CryptoController {

    @Autowired
    public CryptoService cryptoService;

    @GetMapping
    public List<Crypto> getAllCryptos(@RequestParam(required = false) String sort) {
        return cryptoService.getAllCryptos(sort);
    }

    @GetMapping("/{id}")
    public Crypto getCryptoById(@PathVariable Integer id) {
        return cryptoService.getCryptoById(id).orElseThrow(() -> new RuntimeException("Crypto not found"));
    }

    @PostMapping
    public void addCrypto(@RequestBody Crypto crypto) {
        cryptoService.addCrypto(crypto);
    }

    @PutMapping("/{id}")
    public void updateCrypto(@PathVariable Integer id, @RequestBody Crypto updatedCrypto) {
        cryptoService.updateCrypto(id, updatedCrypto);
    }

    @GetMapping("/portfolio-value")
    public Double getPortfolioValue() {
        return cryptoService.getPortfolioValue();
    }
}
