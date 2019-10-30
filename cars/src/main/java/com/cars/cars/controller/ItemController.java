package com.cars.cars.controller;
import com.cars.cars.model.Car;
import com.cars.cars.model.Product;
import com.cars.cars.DAO.ProductDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api( tags = "API pour CRUD item")
@RestController
public class ItemController {

    @Autowired
    ProductDao productDao;

    @ApiOperation("hello")
    @GetMapping("/produits")
    public Iterable<Car> productsList(){
        return productDao.findAll();
    }
    @GetMapping("/produits/{id}")
    public Car readProduct(@PathVariable int id){
        return productDao.findById(id);
    }
    @PostMapping("/produits")
    public void addProduct(@RequestBody Car car){
        productDao.save(car);
    }
    @PutMapping("/produits")
    public void ModifyProduct(@RequestBody Car car){
//        return productDao.update(car);
        productDao.save(car);
    }
    @DeleteMapping("/produits/{id}")
    public void deleteProduct(@PathVariable int id){
        Car dataDelete = readProduct(id);
        productDao.delete(dataDelete);
    }
}
