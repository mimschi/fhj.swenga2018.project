package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
	
	@Transactional
	Food findByItem(String item);
}