package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import Exceptions.InvalidInputException;
import Tools.Tool;
import Tools.ToolFactory;

class ToolFactoryTest {

	@Test
	void CHNSValid() throws InvalidInputException {
		ToolFactory toolFactory = new ToolFactory();
		Tool myTool = toolFactory.createTool("CHNS");
		assertTrue(myTool.equals(Tool.CHNS));
		assertTrue(myTool.getToolType().getDailyCharge().equals(new BigDecimal(1.49).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(myTool.getToolType().getWeekdayCharge() == true);
		assertTrue(myTool.getToolType().getWeekendCharge() == false);
		assertTrue(myTool.getToolType().getHolidayCharge() == true);
	}

	@Test
	void LADWValid() throws InvalidInputException {
		ToolFactory toolFactory = new ToolFactory();
		Tool myTool = toolFactory.createTool("LADW");
		assertTrue(myTool.equals(Tool.LADW));		
		assertTrue(myTool.getToolType().getDailyCharge().equals(new BigDecimal(1.99).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(myTool.getToolType().getWeekdayCharge() == true);
		assertTrue(myTool.getToolType().getWeekendCharge() == true);
		assertTrue(myTool.getToolType().getHolidayCharge() == false);
	}
	
	@Test
	void JAKDValid() throws InvalidInputException {
		ToolFactory toolFactory = new ToolFactory();
		Tool myTool = toolFactory.createTool("JAKD");
		assertTrue(myTool.equals(Tool.JAKD));
		assertTrue(myTool.getToolType().getDailyCharge().equals(new BigDecimal(2.99).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(myTool.getToolType().getWeekdayCharge() == true);
		assertTrue(myTool.getToolType().getWeekendCharge() == false);
		assertTrue(myTool.getToolType().getHolidayCharge() == false);
	}
	
	@Test
	void JAKRValid() throws InvalidInputException {
		ToolFactory toolFactory = new ToolFactory();
		Tool myTool = toolFactory.createTool("JAKR");
		assertTrue(myTool.equals(Tool.JAKR));
		assertTrue(myTool.getToolType().getDailyCharge().equals(new BigDecimal(2.99).setScale(2,RoundingMode.HALF_UP)));
		assertTrue(myTool.getToolType().getWeekdayCharge() == true);
		assertTrue(myTool.getToolType().getWeekendCharge() == false);
		assertTrue(myTool.getToolType().getHolidayCharge() == false);
	}
	
	@Test
	void InvalidInput() throws InvalidInputException {
		ToolFactory toolFactory = new ToolFactory();
	    Throwable exception = assertThrows(InvalidInputException.class, () -> toolFactory.createTool("CHNR"));
	    assertEquals("The input Tool Code: CHNR was not found in our inventory. please confirm you have the corret item", exception.getMessage());

	}
}
