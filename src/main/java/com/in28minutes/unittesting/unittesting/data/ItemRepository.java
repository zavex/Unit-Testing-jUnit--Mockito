package com.in28minutes.unittesting.unittesting.data;

import org.springframework.data.jpa.repository.*;
import com.in28minutes.unittesting.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	
	
	
}
