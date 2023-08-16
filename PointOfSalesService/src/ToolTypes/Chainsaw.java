package ToolTypes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Chainsaw extends ToolType {

	public Chainsaw() {
		setCode();
		setDailyCharge();
		setWeekdayCharge();
		setWeekendCharge();
		setHolidayCharge();
	}

	private void setCode() {
		this.code = "Chainsaw";
	}

	private void setDailyCharge() {
		this.dailyCharge = new BigDecimal(1.49).setScale(2,RoundingMode.HALF_UP);
	}

	private void setWeekdayCharge() {
		this.weekdayCharge = true;
	}

	private void setWeekendCharge() {
		this.weekendCharge = false;
	}

	private void setHolidayCharge() {
		this.holidayCharge = true;
	}
}
