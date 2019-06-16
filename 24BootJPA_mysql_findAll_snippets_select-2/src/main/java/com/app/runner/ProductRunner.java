package com.app.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.product.Product;
import com.app.repo.ProductRepository;
@Component
public class ProductRunner implements CommandLineRunner {
	@Autowired
	private ProductRepository repo;
	@Override
	public void run(String... args) throws Exception {
		/*repo.save(new Product("AA",1.1));
		repo.save(new Product("BB",2.2));
		repo.save(new Product("CC",3.3));
		repo.save(new Product("DD",4.4));
		repo.save(new Product("AA",3.3));
		repo.save(new Product("BB",6.3));
		repo.save(new Product("AA",6.3));
		repo.save(new Product("FF",3.3));*/
		/**************1....this for(=)**************
		 * but its prints all columns
		 * SELECT * FROM product WHERE prod_code='AA'
		 * Product [prodId=2, prodCode=BB, prodCost=2.2]
		 * Product [prodId=6, prodCode=BB, prodCost=6.3]*/
		//repo.findByProdCode("AA").forEach(System.out::println);
		//or
		/*List<Product> list=repo.findByProdCode("BB");
		for (Product product : list) {
			System.out.println(product);
		}*/
		//repo.findByProdCostIs(2.2).forEach(System.out::println);;
		//or
		//repo.findByProdCostEquals(1.1).forEach(System.out::println);;
		/*****2..this for(<)**
		 * SELECT * FROM product WHERE prod_cost<2.2
		 * Product [prodId=1, prodCode=AA, prodCost=1.1]
           Product [prodId=3, prodCode=CC, prodCost=1.1]
           Product [prodId=7, prodCode=AA, prodCost=1.1]
		 * ************/
		//repo.findByProdCostLessThan(2.2).forEach(System.out::println);
		/****3...
		 * SELECT * FROM product WHERE prod_cost>1.1
		 * Product [prodId=2, prodCode=BB, prodCost=2.2]
           Product [prodId=5, prodCode=AA, prodCost=2.2]
		 ************/
		//repo.findByProdCostGreaterThan(1.1).forEach(System.out::println);
		/*****4...this for(<=)*******
		 * SELECT * FROM product WHERE prod_cost<=1.1
		 * Product [prodId=1, prodCode=AA, prodCost=1.1]
	       Product [prodId=6, prodCode=BB, prodCost=1.0]
		 * ****************/
		//repo.findByProdCostLessThanEqual(1.1).forEach(System.out::println);
		/***5...this for(Or)
		 * SELECT * FROM product WHERE prod_code='AA' OR prod_cost<2.2
           Product [prodId=3, prodCode=CC, prodCost=1.1]
           Product [prodId=4, prodCode=DD, prodCost=1.0]
           Product [prodId=5, prodCode=AA, prodCost=2.2]
		 * .******/
		//repo.findByProdCodeOrProdCostLessThan("AA", 2.2).forEach(System.out::println);
		/***6....for (And)*****
		 * SELECT * FROM product WHERE prod_code='AA' AND prod_cost=2.2
		 * Product [prodId=1, prodCode=AA, prodCost=1.1]
           Product [prodId=7, prodCode=AA, prodCost=1.1]
		 * ***********/
		//repo.findByProdCodeAndProdCostLessThan("AA", 2.2).forEach(System.out::println);
		/***7...thid=s for (IS NULL)
		 * SELECT * FROM product WHERE prod_code IS NULL
		 * Product [prodId=1, prodCode=null, prodCost=1.1]
	      Product [prodId=2, prodCode=null, prodCost=2.2]
		 * **************/
		//repo.findByProdCodeIsNull().forEach(System.out::println);;
		//repo.findByProdCodeIsNotNull().forEach(System.out::println);
		/***8...(IN)***********88/
		//repo.findByProdCodeIn(Arrays.asList("AA","BB","CC","tt")).forEach(System.out::println);;
		
		/***9.........(NotIn)*********/
		
		repo.findByProdCodeNotIn(Arrays.asList("AA","BB")).forEach(System.out::println);;

	}

}
