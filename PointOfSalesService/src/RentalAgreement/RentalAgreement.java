package RentalAgreement;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import Exceptions.InvalidInputException;

public class RentalAgreement {
	private String toolCode;
	private String toolType;
	private String toolBrand;
	private Integer rentalDays;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BigDecimal dailyRentalCharge;
	private Integer chargeDays;
	private BigDecimal preDiscountCharge;
	private Integer discountPercent;
	private BigDecimal discountAmount;
	private BigDecimal finalCharge;

	public RentalAgreement() throws InvalidInputException {
		super();
	}

	public Integer getChargeDays() {
		return chargeDays;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public BigDecimal getDailyRentalCharge() {
		return dailyRentalCharge;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public Integer getDiscountPercent() {
		return discountPercent;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public BigDecimal getFinalCharge() {
		return finalCharge;
	}

	public BigDecimal getPreDiscountCharge() {
		return preDiscountCharge;
	}

	public Integer getRentalDays() {
		return rentalDays;
	}

	public String getToolBrand() {
		return toolBrand;
	}

	public String getToolCode() {
		return toolCode;
	}

	public String getToolType() {
		return toolType;
	}
	
	public void printRentalAgreementToConsole() {
		DateTimeFormatter myDateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yy");
		NumberFormat myCurrencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
		
		System.out.println("Tool Code: " + toolCode);
		System.out.println("Tool Type: " + toolType);
		System.out.println("Tool Brand: " + toolBrand);
		System.out.println("Rental Days: " + rentalDays);
		System.out.println("Checkout Date: " + checkoutDate.format(myDateTimeFormatter));
		System.out.println("Due Date: " + dueDate.format(myDateTimeFormatter));
		System.out.println("Daily Rental Charge: " + myCurrencyFormatter.format(dailyRentalCharge));
		System.out.println("Charge Days: " + chargeDays);
		System.out.println("Pre-Discount Charge: " + myCurrencyFormatter.format(preDiscountCharge));
		System.out.println("Discount Percent: " + discountPercent + "%");
		System.out.println("Discount Amount: " + myCurrencyFormatter.format(discountAmount));
		System.out.println("Final Charge: " + myCurrencyFormatter.format(finalCharge));
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public void setToolType(String toolTypeCode) {
		this.toolType = toolTypeCode;
	}

	public void setToolBrand(String toolBrand) {
		this.toolBrand = toolBrand;
	}

	public void setRentalDays(Integer rentalDays) {
		this.rentalDays = rentalDays;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public void setDailyRentalCharge(BigDecimal dailyRentalCharge) {
		this.dailyRentalCharge = dailyRentalCharge;
	}

	public void setChargeDays(Integer chargeDays) {
		this.chargeDays = chargeDays;
	}

	public void setPreDiscountCharge(BigDecimal preDiscountCharge) {
		this.preDiscountCharge = preDiscountCharge;
	}

	public void setDiscountPercent(Integer discountPercentage) {
		this.discountPercent = discountPercentage;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public void setFinalCharge(BigDecimal finalCharge) {
		this.finalCharge = finalCharge;
	}
	
	
}
