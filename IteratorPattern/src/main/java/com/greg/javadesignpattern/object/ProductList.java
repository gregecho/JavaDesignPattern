package com.greg.javadesignpattern.object;

import java.util.List;

import com.greg.javadesignpattern.iterator.*;

public class ProductList extends AbstractObjectList {  
    public ProductList(List products) {  
        super(products);  
    }  
      
    public AbstractIterator createIterator() {  
        return new ProductIterator(this);  
    }  
}   
