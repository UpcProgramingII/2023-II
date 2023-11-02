package com.mycompany.main.Logic;

import com.mycompany.main.Datos.IProductCrud;
import com.mycompany.main.Datos.ProductDao;
import com.mycompany.main.model.Product;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public class ListProduct {
    
    private IProductCrud dataProducts;

    public ListProduct() {
        this.dataProducts = new ProductDao();
    }
    
    public void insertProduct(Product product) throws IllegalArgumentException{
        this.dataProducts.insertProduct(product);
    }
    
    public Product findProductById(int productId)throws IllegalArgumentException{
        return this.dataProducts.findProductById(productId);
    }
    
    public List<Product> getListProduct(){
        return this.dataProducts.getListProduct();
    }
    public void deleteProduct(Product product) throws IllegalArgumentException{
        this.dataProducts.deleteProduct(product);
    }
    
    public List<Product> findProductByDescription(String str){
        return this.dataProducts.findProductByDescription(str);
    }
    
}
