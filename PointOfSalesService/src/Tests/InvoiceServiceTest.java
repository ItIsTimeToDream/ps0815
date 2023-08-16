package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import Exceptions.InvalidInputException;
import RentalAgreement.RentalAgreement;
import Services.CheckoutService;
import Tools.Tool;

class InvoiceServiceTest {

	RentalAgreement rentalAgreement;
	
	@Test
	void invalidDiscontPercentageTooBig() {
		CheckoutService myCheckoutService = new CheckoutService();
		    Throwable exception = assertThrows(InvalidInputException.class, () -> myCheckoutService.PerformCheckout("JAKR", LocalDate.of(2015, 9, 3), 5, 101));
		    assertEquals("The input Discount Percentage of: 101 is not a valid input. The expected value is a number between 0 and 100", exception.getMessage());
	}
	
	@Test
	void invalidDiscontPercentageNegative() {
		CheckoutService myCheckoutService = new CheckoutService();
		    Throwable exception = assertThrows(InvalidInputException.class, () -> myCheckoutService.PerformCheckout("JAKR", LocalDate.of(2015, 9, 3), 5, -1));
		    assertEquals("The input Discount Percentage of: -1 is not a valid input. The expected value is a number between 0 and 100", exception.getMessage());
	}
	
	@Test
	void invalidDiscontPercentage() {
		CheckoutService myCheckoutService = new CheckoutService();
		    Throwable exception = assertThrows(InvalidInputException.class, () -> myCheckoutService.PerformCheckout("KATR", LocalDate.of(2015, 9, 3), 5, 0));
		    assertEquals("The input Tool Code: KATR was not found in our inventory. please confirm you have the corret item", exception.getMessage());
	}
	
	@Test
	void ladder10PercentLongTime() throws InvalidInputException  {
		CheckoutService myCheckoutService = new CheckoutService();
		rentalAgreement = myCheckoutService.PerformCheckout("LADW", LocalDate.of(2020, 7, 2), 1000000000, 10);
		rentalAgreement.printRentalAgreementToConsole();
	}
	
	@Test
	void ladder10PercentOneDay() throws InvalidInputException  {
		CheckoutService myCheckoutService = new CheckoutService();
		rentalAgreement = myCheckoutService.PerformCheckout("LADW", LocalDate.of(2020, 7, 2), 1, 10);
		rentalAgreement.printRentalAgreementToConsole();
	}
	
	@Test
	void ladder10PercentOneDayOnHoliday() throws InvalidInputException  {
		CheckoutService myCheckoutService = new CheckoutService();
		rentalAgreement = myCheckoutService.PerformCheckout("LADW", LocalDate.of(2020, 7, 3), 1, 10);
		rentalAgreement.printRentalAgreementToConsole();
	}
	
	
	@Test
	void ladder10Percent() throws InvalidInputException  {
		CheckoutService myCheckoutService = new CheckoutService();
		rentalAgreement = myCheckoutService.PerformCheckout("LADW", LocalDate.of(2020, 7, 2), 3, 10);
		assertTrue(rentalAgreement.getChargeDays().equals(2));
		assertTrue(rentalAgreement.getCheckoutDate().equals(LocalDate.of(2020, 7, 2)));
		assertTrue(rentalAgreement.getDailyRentalCharge().equals(Tool.LADW.getToolType().getDailyCharge()));
		assertTrue(rentalAgreement.getDiscountAmount().equals(new BigDecimal(0.4).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(rentalAgreement.getDiscountPercent().equals(10));
		assertTrue(rentalAgreement.getDueDate().equals(LocalDate.of(2020, 7, 4)));
		assertTrue(rentalAgreement.getFinalCharge().equals(new BigDecimal(3.58).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(rentalAgreement.getPreDiscountCharge().equals(new BigDecimal(3.98).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(rentalAgreement.getRentalDays().equals(3));
		assertTrue(rentalAgreement.getToolBrand().equals(Tool.LADW.getBrand().getName()));
		assertTrue(rentalAgreement.getToolCode().equals(Tool.LADW.getCode()));
		assertTrue(rentalAgreement.getToolType().equals(Tool.LADW.getToolType().getCode()));
		rentalAgreement.printRentalAgreementToConsole();
	}

	@Test
	void chainsaw25Percent() throws InvalidInputException  {
		CheckoutService myCheckoutService = new CheckoutService();
		rentalAgreement = myCheckoutService.PerformCheckout("CHNS", LocalDate.of(2015, 7, 2), 5, 25);
		assertTrue(rentalAgreement.getChargeDays().equals(3));
		assertTrue(rentalAgreement.getCheckoutDate().equals(LocalDate.of(2015, 7, 2)));
		assertTrue(rentalAgreement.getDailyRentalCharge().equals(Tool.CHNS.getToolType().getDailyCharge()));
		assertTrue(rentalAgreement.getDiscountAmount().equals(new BigDecimal(1.12).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(rentalAgreement.getDiscountPercent().equals(25));
		assertTrue(rentalAgreement.getDueDate().equals(LocalDate.of(2015, 7, 6)));
		assertTrue(rentalAgreement.getFinalCharge().equals(new BigDecimal(3.35).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(rentalAgreement.getPreDiscountCharge().equals(new BigDecimal(4.47).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(rentalAgreement.getRentalDays().equals(5));
		assertTrue(rentalAgreement.getToolBrand().equals(Tool.CHNS.getBrand().getName()));
		assertTrue(rentalAgreement.getToolCode().equals(Tool.CHNS.getCode()));
		assertTrue(rentalAgreement.getToolType().equals(Tool.CHNS.getToolType().getCode()));
		rentalAgreement.printRentalAgreementToConsole();
	}

	@Test
	void jackhammerDeWalt0Percent() throws InvalidInputException  {
		CheckoutService myCheckoutService = new CheckoutService();
		rentalAgreement = myCheckoutService.PerformCheckout("JAKD", LocalDate.of(2015, 9, 3), 6, 0);
		assertTrue(rentalAgreement.getChargeDays().equals(3));
		assertTrue(rentalAgreement.getCheckoutDate().equals(LocalDate.of(2015, 9, 3)));
		assertTrue(rentalAgreement.getDailyRentalCharge().equals(Tool.JAKD.getToolType().getDailyCharge()));
		assertTrue(rentalAgreement.getDiscountAmount().equals(new BigDecimal(0).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(rentalAgreement.getDiscountPercent().equals(0));
		assertTrue(rentalAgreement.getDueDate().equals(LocalDate.of(2015, 9, 8)));
		assertTrue(rentalAgreement.getFinalCharge().equals(new BigDecimal(8.97).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(rentalAgreement.getPreDiscountCharge().equals(new BigDecimal(8.97).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(rentalAgreement.getRentalDays().equals(6));
		assertTrue(rentalAgreement.getToolBrand().equals(Tool.JAKD.getBrand().getName()));
		assertTrue(rentalAgreement.getToolCode().equals(Tool.JAKD.getCode()));
		assertTrue(rentalAgreement.getToolType().equals(Tool.JAKD.getToolType().getCode()));
		rentalAgreement.printRentalAgreementToConsole();
	}

	@Test
	void jackhammerRigid0Percent() throws InvalidInputException  {
		CheckoutService myCheckoutService = new CheckoutService();
		rentalAgreement = myCheckoutService.PerformCheckout("JAKR", LocalDate.of(2015, 7, 2), 9, 0);
		assertTrue(rentalAgreement.getChargeDays().equals(6));
		assertTrue(rentalAgreement.getCheckoutDate().equals(LocalDate.of(2015, 7, 2)));
		assertTrue(rentalAgreement.getDailyRentalCharge().equals(Tool.JAKR.getToolType().getDailyCharge()));
		assertTrue(rentalAgreement.getDiscountAmount().equals(new BigDecimal(0).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(rentalAgreement.getDiscountPercent().equals(0));
		assertTrue(rentalAgreement.getDueDate().equals(LocalDate.of(2015, 7, 10)));
		assertTrue(rentalAgreement.getFinalCharge().equals(new BigDecimal(17.94).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(rentalAgreement.getPreDiscountCharge().equals(new BigDecimal(17.94).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(rentalAgreement.getToolBrand().equals(Tool.JAKR.getBrand().getName()));
		assertTrue(rentalAgreement.getToolCode().equals(Tool.JAKR.getCode()));
		assertTrue(rentalAgreement.getToolType().equals(Tool.JAKR.getToolType().getCode()));
		rentalAgreement.printRentalAgreementToConsole();
	}

	@Test
	void jackhammer50Percent() throws InvalidInputException  {
		CheckoutService myCheckoutService = new CheckoutService();
		rentalAgreement = myCheckoutService.PerformCheckout("JAKR", LocalDate.of(2020, 7, 2), 4, 50);
		assertTrue(rentalAgreement.getChargeDays().equals(1));
		assertTrue(rentalAgreement.getCheckoutDate().equals(LocalDate.of(2020, 7, 2)));
		assertTrue(rentalAgreement.getDailyRentalCharge().equals(Tool.JAKR.getToolType().getDailyCharge()));
		assertTrue(rentalAgreement.getDiscountAmount().equals(new BigDecimal(1.5).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(rentalAgreement.getDiscountPercent().equals(50));
		assertTrue(rentalAgreement.getDueDate().equals(LocalDate.of(2020, 7, 5)));
		assertTrue(rentalAgreement.getFinalCharge().equals(new BigDecimal(1.49).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(rentalAgreement.getPreDiscountCharge().equals(new BigDecimal(2.99).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(rentalAgreement.getToolBrand().equals(Tool.JAKR.getBrand().getName()));
		assertTrue(rentalAgreement.getToolCode().equals(Tool.JAKR.getCode()));
		assertTrue(rentalAgreement.getToolType().equals(Tool.JAKR.getToolType().getCode()));
		rentalAgreement.printRentalAgreementToConsole();
	}

}
