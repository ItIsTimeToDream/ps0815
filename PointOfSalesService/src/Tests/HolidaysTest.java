package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import Services.HolidayService;

class HolidaysTest {

	@Test
	void One4thOfJulyInRange() {
		HolidayService holidayService = new HolidayService();
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2022, 7, 1), LocalDate.of(2022, 7, 5)));
	}

	@Test
	void OneLaborDayInRange() {
		HolidayService holidayService = new HolidayService();
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2022, 9, 1), LocalDate.of(2022, 9, 9)));
	}
	
	@Test
	void TwoHolidaysInRange() {
		HolidayService holidayService = new HolidayService();
		assertEquals(2,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2022, 7, 1), LocalDate.of(2022, 9, 9)));
	}
	
	@Test
	void ZeroHolidaysInRange() {
		HolidayService holidayService = new HolidayService();
		assertEquals(0,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2022, 10, 1), LocalDate.of(2022, 10, 9)));
	}
	
	@Test
	void AllLaborDayHolidaysInRange() {
		HolidayService holidayService = new HolidayService();
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2014, 9, 1), LocalDate.of(2014, 9, 1)));
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2015, 9, 7), LocalDate.of(2015, 9, 7)));
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2016, 9, 5), LocalDate.of(2016, 9, 5)));
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2017, 9, 4), LocalDate.of(2017, 9, 4)));
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2018, 9, 3), LocalDate.of(2018, 9, 3)));
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2019, 9, 2), LocalDate.of(2019, 9, 2)));
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2021, 9, 6), LocalDate.of(2021, 9, 6)));
	}
	
	@Test
	void AllJuly4thHolidaysInRange() {
		HolidayService holidayService = new HolidayService();
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2020, 7, 3), LocalDate.of(2020, 7, 3)));
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2023, 7, 4), LocalDate.of(2023, 7, 4)));
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2024, 7, 4), LocalDate.of(2024, 7, 4)));
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2025, 7, 4), LocalDate.of(2025, 7, 4)));
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2026, 7, 3), LocalDate.of(2026, 7, 3)));
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2027, 7, 5), LocalDate.of(2027, 7, 5)));
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2029, 7, 4), LocalDate.of(2029, 7, 4)));
		assertEquals(1,holidayService.getNumberOfHolidaysBetweenDates(LocalDate.of(2033, 7, 4), LocalDate.of(2033, 7, 4)));
	}
}
