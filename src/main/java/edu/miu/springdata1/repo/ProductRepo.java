package edu.miu.springdata1.repo;

import edu.miu.springdata1.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo {
    private static List<Product> products;

    static {
        products = new ArrayList<>();
    }

    public void save(Product p) {
        var notExists = products
                .stream()
                .noneMatch(l -> l.getId() == p.getId());

        if (notExists) {
            products.add(p);
        }
    }

    public void delete(int id) {
        products
                .stream()
                .filter(l -> l.getId() == id)
                .forEach(l -> products.remove(l));
    }

    public Product getById(int id) {
        return products
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);

    }

}
