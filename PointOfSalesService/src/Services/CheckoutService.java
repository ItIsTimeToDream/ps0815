package Services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;

import Exceptions.InvalidInputException;
import RentalAgreement.RentalAgreement;
import ToolTypes.ToolType;
import Tools.Tool;
import Tools.ToolFactory;

public class CheckoutService {

	private LocalDate calculateDueDate(LocalDate theCheckoutDate, Integer theRentalDays) {
		//subtract 1 to have the Due date be the last day of the rental and not the day after
		return theCheckoutDate.plusDays(theRentalDays - 1);
	}

	private Integer calculateNumberOfChargeDays(ToolType theToolType, LocalDate theCheckoutDate, LocalDate theDueDate, Integer theRentalDays) {
		HolidayService myHolidayService = new HolidayService();
		Integer myNumberOfChargeDays = theRentalDays;

		// subtract charge days if needed
		if (!theToolType.getHolidayCharge()) {
			myNumberOfChargeDays -= myHolidayService.getNumberOfHolidaysBetweenDates(theCheckoutDate, theDueDate);
		}

		// get a count of weekend days that are between the dates
		if (!theToolType.getWeekendCharge()) {
			myNumberOfChargeDays -= getNumberOfWeekendDays(theCheckoutDate, theDueDate);
		}

		// get a count of weekday days that are between the dates
		if (!theToolType.getWeekdayCharge()) {
			myNumberOfChargeDays -= getNumberOfWeekdayDays(theCheckoutDate, theDueDate);
		}

		return myNumberOfChargeDays;
	}

	public RentalAgreement PerformCheckout(String theToolCode, LocalDate theCheckoutDate, Integer theRentalDays,
			Integer theDiscountPercentage) throws InvalidInputException {
		RentalAgreement myRentalAgreement = new RentalAgreement();
		ToolFactory myToolFactory = new ToolFactory();

		validateInputs(theRentalDays, theDiscountPercentage);

		// set tool values
		Tool myTool = myToolFactory.createTool(theToolCode);
		myRentalAgreement.setToolCode(myTool.getCode());
		myRentalAgreement.setToolType(myTool.getToolType().getCode());
		myRentalAgreement.setToolBrand(myTool.getBrand().getName());

		// calculate dates
		myRentalAgreement.setCheckoutDate(theCheckoutDate);
		myRentalAgreement.setDueDate(calculateDueDate(theCheckoutDate, theRentalDays));
		myRentalAgreement.setRentalDays(theRentalDays);

		// calculate Charges
		myRentalAgreement.setDailyRentalCharge(myTool.getToolType().getDailyCharge());
		myRentalAgreement.setChargeDays(calculateNumberOfChargeDays(myTool.getToolType(),
				myRentalAgreement.getCheckoutDate(), myRentalAgreement.getDueDate(), myRentalAgreement.getRentalDays()));
		// calculate charge and round to cents
		myRentalAgreement.setPreDiscountCharge((myRentalAgreement.getDailyRentalCharge()
				.multiply(BigDecimal.valueOf(myRentalAgreement.getChargeDays()))).setScale(2, RoundingMode.HALF_UP));

		// calculate amounts
		myRentalAgreement.setDiscountPercent(theDiscountPercentage);
		// calculate amount and round to cents
		myRentalAgreement.setDiscountAmount((myRentalAgreement.getPreDiscountCharge()
				.multiply((BigDecimal.valueOf(myRentalAgreement.getDiscountPercent()).divide(BigDecimal.valueOf(100)))))
				.setScale(2, RoundingMode.HALF_UP));
		myRentalAgreement.setFinalCharge(
				myRentalAgreement.getPreDiscountCharge().subtract(myRentalAgreement.getDiscountAmount()));

		return myRentalAgreement;
	}

	private int getNumberOfWeekdayDays(LocalDate theCheckoutDate, LocalDate theDueDate) {
		// 1 extra day must be added as Dates until is Exclusive and would not count the last day
		return (int) theCheckoutDate.datesUntil(theDueDate.plusDays(1))
				.filter(date -> !DayOfWeek.SATURDAY.equals(date.getDayOfWeek())
						&& !DayOfWeek.SUNDAY.equals(date.getDayOfWeek()))
				.count();
	}

	private int getNumberOfWeekendDays(LocalDate theCheckoutDate, LocalDate theDueDate) {
		// 1 extra day must be added as Dates until is Exclusive and would not count the last day
		return (int) theCheckoutDate.datesUntil(theDueDate.plusDays(1)).filter(
				date -> DayOfWeek.SATURDAY.equals(date.getDayOfWeek()) || DayOfWeek.SUNDAY.equals(date.getDayOfWeek()))
				.count();
	}

	private void validateInputs(Integer theRentalDays, Integer theDiscountPercentage) throws InvalidInputException {
		if (theRentalDays == null || theRentalDays >= Integer.MAX_VALUE || theRentalDays < 1) {
			throw new InvalidInputException("The input Rental Day duration of: " + theRentalDays
					+ " is not a valid input. The expected value is a number of 1 or greater");
		}

		if (theDiscountPercentage == null || theDiscountPercentage < 0 || theDiscountPercentage > 100) {
			throw new InvalidInputException("The input Discount Percentage of: " + theDiscountPercentage
					+ " is not a valid input. The expected value is a number between 0 and 100");
		}
	}
}
