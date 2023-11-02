package com.mycompany.main.Datos;

import com.mycompany.main.model.Product;
import java.util.ArrayList;
import java.util.List;


public class ProductDao implements IProductCrud{
    
    private List<Product> dbProducts;

    public ProductDao() {
        this.dbProducts= new ArrayList();
    }
    
    @Override
    public void insertProduct(Product product) throws IllegalArgumentException {
        
        if(product==null)
            throw new IllegalArgumentException("No es posible registrar un producto con valor NULL");
        
        if(product.getDescription().isBlank())
            throw new IllegalArgumentException("EL producto no tiene registrado la DESCRIPCION");
        
        if(product.getPrice()<0)
            throw new IllegalArgumentException("EL producto no debe tener PRECIO NEGATIVO");
        
        if(product.getStock()<0)
            throw new IllegalArgumentException("EL producto no debe tener STOCK NEGATIVO");
        
        this.dbProducts.add(product);
    }

    @Override
    public Product findProductById(int productId) throws IllegalArgumentException {
        Product product=null;
        
        for(Product p: this.dbProducts){
            if(p.getId()==productId){
                product = p;
            }
        }
        
        if(product==null)
            throw new IllegalArgumentException("No hay productos registrados con el id " + productId);
        
        return product;
    }

    @Override
    public List<Product> getListProduct() {
        return this.dbProducts;
    }

    @Override
    public void deleteProduct(Product product) throws IllegalArgumentException {
        if(product==null)
            throw new IllegalArgumentException("No es posible eliminar un producto con valor NULL");
        
        this.dbProducts.remove(product);
    }

    @Override
    public List<Product> findProductByDescription(String str) {
        List<Product> products = new ArrayList();
        for(Product p: this.dbProducts){
            if(p.getDescription().contains(str)){
                products.add(p);
            }
        }
        
        return products;
    }
    
}
