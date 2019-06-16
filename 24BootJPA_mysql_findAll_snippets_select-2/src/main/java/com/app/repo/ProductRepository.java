package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.product.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	/***1..h=this for (=)**********
	 * but its prints all columns
	 * SELECT * FROM product WHERE prod_code='AA'
	 * Product [prodId=2, prodCode=BB, prodCost=2.2]
	 * Product [prodId=6, prodCode=BB, prodCost=6.3]*/
	List<Product> findByProdCode(String prodCode);
	List<Product> findByProdCostIs(Double prodCost);
	List<Product> findByProdCostEquals(Double prodCost);
	/*****2..this for(<)**
	 * SELECT * FROM product WHERE prod_cost<2.2
	 * Product [prodId=1, prodCode=AA, prodCost=1.1]
       Product [prodId=3, prodCode=CC, prodCost=1.1]
       Product [prodId=7, prodCode=AA, prodCost=1.1]
	 * ************/
	List<Product> findByProdCostLessThan(Double prodCost);
	/****3...
	 * SELECT * FROM product WHERE prod_cost>1.1
	 * Product [prodId=2, prodCode=BB, prodCost=2.2]
       Product [prodId=5, prodCode=AA, prodCost=2.2]
	 ************/
	List<Product> findByProdCostGreaterThan(Double prodCost);
	/*****4...this for(<=)*******
	 * SELECT * FROM product WHERE prod_cost<=1.1
	 * Product [prodId=1, prodCode=AA, prodCost=1.1]
       Product [prodId=6, prodCode=BB, prodCost=1.0]
	 * ****************/
	List<Product> findByProdCostLessThanEqual(Double prodCost);
	/***5...this for(Or)
	 * SELECT * FROM product WHERE prod_code='AA' OR prod_cost<2.2
       Product [prodId=3, prodCode=CC, prodCost=1.1]
       Product [prodId=4, prodCode=DD, prodCost=1.0]
       Product [prodId=5, prodCode=AA, prodCost=2.2]
	 * .******/
	List<Product> findByProdCodeOrProdCostLessThan(String prodCode,Double prodCost);
	/***6....for (And)*****
	 * SELECT * FROM product WHERE prod_code='AA' AND prod_cost=2.2
	 * Product [prodId=1, prodCode=AA, prodCost=1.1]
       Product [prodId=7, prodCode=AA, prodCost=1.1]
	 * ***********/
	List<Product> findByProdCodeAndProdCostLessThan(String prodCode,Double prodCost);
	/***7...this for (IS NULL)
	 * SELECT * FROM product WHERE prod_code IS NULL
	 * Product [prodId=1, prodCode=null, prodCost=1.1]
      Product [prodId=2, prodCode=null, prodCost=2.2]
	 * **************/
	List<Product> findByProdCodeIsNull();
	/***8...this for (IS NOT NULL)
	 * SELECT * FROM product WHERE prod_code IS NOT NULL8
	 * u8888
	 * Product [prodId=3, prodCode=CC, prodCost=1.1]
       Product [prodId=4, prodCode=DD, prodCost=1.0]   
	 * *************/
	List<Product> findByProdCodeIsNotNull();
	/***9.....[IN(prodCode,prodCost)]
	 * SELECT * FROM product WHERE prod_code IN ('AA');
	 * ****************88/
	 */
	//List<Product> findByProdCodeIn(List<String> list);
	/***10...**********/
	
	
	List<Product> findByProdCodeNotIn(List<String> list);
	





























}
