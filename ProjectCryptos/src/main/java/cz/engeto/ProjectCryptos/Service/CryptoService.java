package cz.engeto.ProjectCryptos.Service;



import cz.engeto.ProjectCryptos.Model.Crypto;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CryptoService {
    private final List<Crypto> portfolio = new ArrayList<>();

    public List<Crypto> getAllCryptos(String sortBy) {
        if (sortBy != null) {
            portfolio.sort(getComparator(sortBy));
        }
        return portfolio;
    }

    public Optional<Crypto> getCryptoById(Integer id) {
        for (Crypto crypto : portfolio) {
            if (!id.equals(crypto.getId())) continue;
            return Optional.of(crypto);
        }
        return Optional.empty();
    }


    public void addCrypto(Crypto crypto) {
        portfolio.add(crypto);
    }

    public void updateCrypto(Integer id, Crypto updatedCrypto) {
        getCryptoById(id).ifPresent(crypto -> {
            crypto.setName(updatedCrypto.getName());
            crypto.setSymbol(updatedCrypto.getSymbol());
            crypto.setPrice(updatedCrypto.getPrice());
            crypto.setQuantity(updatedCrypto.getQuantity());
        });
    }

    public Double getPortfolioValue() {
        return portfolio.stream().mapToDouble(c -> c.getPrice() * c.getQuantity()).sum();
    }

    private Comparator<? super Crypto> getComparator(String sortBy) {
        return switch (sortBy) {
            case "price" -> Comparator.comparing(Crypto::getPrice);
            case "name" -> Comparator.comparing(Crypto::getName);
            case "quantity" -> Comparator.comparing(Crypto::getQuantity);
            default -> Comparator.comparing(Crypto::getId);
        };
    }
}
