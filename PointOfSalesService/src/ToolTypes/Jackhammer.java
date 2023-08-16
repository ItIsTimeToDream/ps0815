package ToolTypes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Jackhammer extends ToolType {

	public Jackhammer() {
		setCode();
		setDailyCharge();
		setWeekdayCharge();
		setWeekendCharge();
		setHolidayCharge();
	}

	private void setCode() {
		this.code = "Jackhammer";
	}

	private void setDailyCharge() {
		this.dailyCharge = new BigDecimal(2.99).setScale(2,RoundingMode.HALF_UP);
	}

	private void setWeekdayCharge() {
		this.weekdayCharge = true;
	}

	private void setWeekendCharge() {
		this.weekendCharge = false;
	}

	private void setHolidayCharge() {
		this.holidayCharge = false;
	}
}
