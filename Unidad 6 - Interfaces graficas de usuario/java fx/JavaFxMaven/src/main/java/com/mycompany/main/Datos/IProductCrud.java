package com.mycompany.main.Datos;

import com.mycompany.main.model.Product;
import java.util.List;

public interface IProductCrud {
    void insertProduct(Product product);
    Product findProductById(int productId);
    List<Product> getListProduct();
    void deleteProduct(Product product);
    List<Product>findProductByDescription(String str);
}
