package Services;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class HolidayService {

	// Generate the holidays within the rental period
	public Integer getNumberOfHolidaysBetweenDates(LocalDate theStartDate, LocalDate theEndDate) {
		Integer myNumberOfHolidays = 0;

		myNumberOfHolidays += generate4thOfJuly(theStartDate, theEndDate);
		myNumberOfHolidays += generateLaborDay(theStartDate, theEndDate);

		return myNumberOfHolidays;
	}

	private Integer generate4thOfJuly(LocalDate theStartDate, LocalDate theEndDate) {
		Integer myNumberOfHolidays = 0;

		// Generate the 4th of July for each year and move it to the nearest weekday if
		// it falls on a weekend
		for (int myYearCounter = theStartDate.getYear(); myYearCounter <= theEndDate.getYear(); myYearCounter++) {
			LocalDate currentYearHoliday = LocalDate.of(myYearCounter, 7, 4);
			if (currentYearHoliday.getDayOfWeek() == DayOfWeek.SATURDAY) {
				currentYearHoliday = currentYearHoliday.minusDays(1);
			} else if (currentYearHoliday.getDayOfWeek() == DayOfWeek.SUNDAY) {
				currentYearHoliday = currentYearHoliday.plusDays(1);
			}

			//add a count if the generated 4th of July is between or on the input dates
			if ((!currentYearHoliday.isBefore(theStartDate)) && (!currentYearHoliday.isAfter(theEndDate))) {
				myNumberOfHolidays++;
			}
		}

		return myNumberOfHolidays;
	}

	
	private Integer generateLaborDay(LocalDate theStartDate, LocalDate theEndDate) {
		Integer myNumberOfHolidays = 0;

		// Generate the first of september and then add the necessary number of days to get to the first monday
		for (int myYearCounter = theStartDate.getYear(); myYearCounter <= theEndDate.getYear(); myYearCounter++) {
			LocalDate currentYearHoliday = LocalDate.of(myYearCounter, 9, 1);
			if (currentYearHoliday.getDayOfWeek() != DayOfWeek.MONDAY) {
				currentYearHoliday = currentYearHoliday.plusDays(8 - currentYearHoliday.getDayOfWeek().getValue());
			}

			//add a count if the generated labor day is between or on the input dates
			if ((!currentYearHoliday.isBefore(theStartDate)) && (!currentYearHoliday.isAfter(theEndDate))) {
				myNumberOfHolidays++;
			}
		}

		return myNumberOfHolidays;
	}
}
