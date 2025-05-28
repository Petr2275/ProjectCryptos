package cz.engeto.ProjectCryptos;


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

    public Optional<cz.engeto.ProjectCryptos.Crypto> getCryptoById(Integer id) {
        return portfolio.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
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

    private Comparator<Crypto> getComparator(String sortBy) {
        return switch (sortBy) {
            case "price" -> Comparator.comparing(Crypto::getPrice);
            case "name" -> Comparator.comparing(Crypto::getName);
            case "quantity" -> Comparator.comparing(Crypto::getQuantity);
            default -> Comparator.comparing(Crypto::getId);
        };
    }
}
