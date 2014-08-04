package vo;

import org.springframework.beans.BeanUtils;

public class Item {
	private String itemId;
	private String productId;
	private String supplier;
	private String status;
	private String attr1;
	private String attr2;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

	public String toString() {
		StringBuilder buf = new StringBuilder(30);
		buf.append("{");
		buf.append(itemId);
		buf.append(", ");
		buf.append(productId);
		buf.append(", ");
		buf.append(supplier);
		buf.append(", ");
		buf.append(attr1);
		buf.append(", ");
		buf.append(attr2);
		buf.append("}");
		return buf.toString();
	}

}
