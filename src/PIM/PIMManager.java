package PIM;

import DBManager.DBManager;
import DBManager.DatabaseInterface;
import java.util.ArrayList;

public class PIMManager {

    private ArrayList<PIMProduct> currentProductList;
    private DatabaseInterface dbm;
    private PIMProduct productToEdit;
    private boolean editingProduct;

    public PIMManager() {
	dbm = DBManager.getInstance();
	
	//Testing of editingProduct
	editingProduct = true;
	productToEdit = Converter.createPIMProduct(dbm.getProduct(1));
    }

    public ArrayList<PIMProduct> getAllProducts() {
	this.currentProductList = ProductSearch.getAllProducts();

	return currentProductList;
    }

    public boolean createProduct(String name, String category, String description, double price, ArrayList<Integer> imageIdList) {
	return EditProduct.createProduct(name, category, description, price, imageIdList);
    }

    public boolean editProduct(int productID, String name, String category, String description, double price, ArrayList<Integer> imageIdList) {
	return EditProduct.editProduct(productID, name, category, description, price, imageIdList);
    }

    public ArrayList<PIMage> getUnassignedPIMages() {
	return Converter.createPIMages(dbm.getUnassignedImages());
    }
    
    public ArrayList<PIMage> getPImages(int productID) {
	return Converter.createPIMages(dbm.getPImages(productID));
    }

    public void setProductToEdit(int productID) {
	productToEdit = Converter.createPIMProduct(dbm.getProduct(productID));
    }
    
    public PIMProduct getProductToEdit() {
	return productToEdit;
    }

    public boolean isEditingProduct() {
	return editingProduct;
    }

    public void setEditingProduct(boolean editingProduct) {
	this.editingProduct = editingProduct;
    }

}
