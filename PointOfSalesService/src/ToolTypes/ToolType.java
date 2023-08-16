package ToolTypes;

import java.math.BigDecimal;

public abstract class ToolType {
	protected String code;
	protected BigDecimal dailyCharge;
	protected Boolean weekdayCharge;
	protected Boolean weekendCharge;
	protected Boolean holidayCharge;

	public ToolType() {
		super();
	}

	public String getCode() {
		return code;
	}

	public BigDecimal getDailyCharge() {
		return dailyCharge;
	}

	public Boolean getWeekdayCharge() {
		return weekdayCharge;
	}

	public Boolean getWeekendCharge() {
		return weekendCharge;
	}

	public Boolean getHolidayCharge() {
		return holidayCharge;
	}
	
}
