package com.relayr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relayr.model.PricingModel;
import com.relayr.model.Product;
import com.relayr.model.Product_Store_Details;
import com.relayr.model.Store;
import com.relayr.repo.ProductRepository;
import com.relayr.repo.ProductStoreDetailRepositroy;
import com.relayr.repo.StoreRepository;
import com.relayr.service.PricingService;

@Service
public class PricingServiceImpl implements PricingService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductStoreDetailRepositroy productStoreDetailRepositroy;

	@Autowired
	private StoreRepository storeRepository;

	@Override
	public Iterable<PricingModel> findByProductName(String productName) {
		try {
			List<Product> productList = productRepository.findByName(productName);

			List<PricingModel> pricingList = new ArrayList<>();

			for (Product product : productList) {
				Long productId = product.getId();
				List<Product_Store_Details> productStoreList = productStoreDetailRepositroy.findByProductId(productId);
				String category = product.getCategory();
				PricingModel pricingModel = null;
				for (Product_Store_Details productStore : productStoreList) {
					String link = productStore.getLink();
					Store store = storeRepository.findById(productStore.getStoreId()).get();
					String storeName = store.getName();
					double mrp = productStore.getMrp();
					double sp = productStore.getSp();
					double discount = productStore.getDiscount();
					int rating = productStore.getRating();
					pricingModel = new PricingModel(productName, storeName, link, mrp, sp, discount, category, rating);
				}

				if (pricingModel != null) {
					pricingList.add(pricingModel);
				}
			}
			return pricingList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Error in findByProductName");
		}
	}

	@Override
	public Iterable<PricingModel> findByProductAndCategory(String productName, String category) {
		try {
			List<Product> productList = productRepository.findByNameAndCategory(productName, category);

			List<PricingModel> pricingList = new ArrayList<>();

			for (Product product : productList) {
				Long productId = product.getId();
				List<Product_Store_Details> productStoreList = productStoreDetailRepositroy.findByProductId(productId);

				PricingModel pricingModel = null;
				for (Product_Store_Details productStore : productStoreList) {
					String link = productStore.getLink();
					Store store = storeRepository.findById(productStore.getStoreId()).get();
					String storeName = store.getName();
					double mrp = productStore.getMrp();
					double sp = productStore.getSp();
					double discount = productStore.getDiscount();
					int rating = productStore.getRating();
					pricingModel = new PricingModel(productName, storeName, link, mrp, sp, discount, storeName, rating);
					pricingList.add(pricingModel);
				}
			}
			return pricingList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Error in findByProductAndCategory");
		}
	}

	@Override
	public void savePricingModel(List<PricingModel> pricingModels) {
		try {
			for (PricingModel pricingModel : pricingModels) {
				long productId = -1L;
				long storeId = -1L;

				if (null != pricingModel.getProductName() && null != pricingModel.getCategory()) {
					productId = saveProduct(pricingModel.getProductName().toLowerCase(),
							pricingModel.getCategory().toLowerCase());
				}

				if (null != pricingModel.getStoreName()) {
					storeId = saveStore(pricingModel.getStoreName().toLowerCase());
				}

				if (storeId != -1 && productId != -1) {
					Product_Store_Details productStore = new Product_Store_Details(pricingModel.getLink().toLowerCase(),
							storeId, productId, pricingModel.getMrp(), pricingModel.getSp(), pricingModel.getDiscount(),
							pricingModel.getRating());
					productStoreDetailRepositroy.save(productStore);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Error in savePricingModel");
		}
	}

	private long saveProduct(String productName, String category) {
		try {
			List<Product> product = productRepository.findByName(productName);
			if (product.size() > 0) {
				return product.get(0).getId();
			} else {
				Product product1 = productRepository.save(new Product(productName, category));
				return product1.getId();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Error in saveProduct");
		}
	}

	private long saveStore(String storeName) {
		try {
			List<Store> store = storeRepository.findByName(storeName);
			if (store.size() > 0) {
				return store.get(0).getId();
			} else {
				Store store1 = storeRepository.save(new Store(storeName));
				return store1.getId();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Error in saveStore");
		}
	}

	@Override
	public Iterable<PricingModel> findAll(String PricingModelName) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
