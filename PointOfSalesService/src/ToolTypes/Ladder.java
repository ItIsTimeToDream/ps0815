package ToolTypes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ladder extends ToolType {

	public Ladder() {
		setCode();
		setDailyCharge();
		setWeekdayCharge();
		setWeekendCharge();
		setHolidayCharge();
	}

	private void setCode() {
		this.code = "Ladder";
	}

	private void setDailyCharge() {
		this.dailyCharge = new BigDecimal(1.99).setScale(2,RoundingMode.HALF_UP);
	}

	private void setWeekdayCharge() {
		this.weekdayCharge = true;
	}

	private void setWeekendCharge() {
		this.weekendCharge = true;
	}

	private void setHolidayCharge() {
		this.holidayCharge = false;
	}
}
