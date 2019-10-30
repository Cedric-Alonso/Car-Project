//package com.cars.cars.DAO;
//import com.cars.cars.model.Car;
//import java.util.List;

//public interface ProductDao {
//     List<Car> findAll();
//     Car findById(int id);
//     List<Car> save(Car car);
//     List<Car> update(Car car);
//     Car delete(int id);
//}

package com.cars.cars.DAO;

import com.cars.cars.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Car, Integer> {

    Car findById(int id);

}


