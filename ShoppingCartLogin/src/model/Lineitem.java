package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the LINEITEMS database table.
 * 
 */
@Entity
@Table(name="LINEITEMS",schema="TESTUSERDB")
@NamedQuery(name="Lineitem.findAll", query="SELECT l FROM Lineitem l")
public class Lineitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LINEITEMS_LINEITEMID_GENERATOR",sequenceName="SEQ_LINEITEMS",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="LINEITEMS_LINEITEMID_GENERATOR")
	@Column(name="LINEITEM_ID")
	private long lineitemId;

	@Column(name="PRODUCT_DATE")
	private String productDate;

	@Column(name="PRODUCT_ID")
	private int productId;

	@Column(name="PRODUCT_NAME")
	private String productName;

	@Column(name="PRODUCT_PRICE")
	private double productPrice;

	@Column(name="PRODUCT_QUANTITY")
	private int productQuantity;

	@Column(name="PRODUCT_UNITPRICE")
	private double productUnitprice;

	@Column(name="USER_ID")
	private int userId;

	public Lineitem() {
	}

	public long getLineitemId() {
		return this.lineitemId;
	}

	public void setLineitemId(long lineitemId) {
		this.lineitemId = lineitemId;
	}

	public String getProductDate() {
		return this.productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return this.productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductUnitprice() {
		return this.productUnitprice;
	}

	public void setProductUnitprice(double productUnitprice) {
		this.productUnitprice = productUnitprice;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}