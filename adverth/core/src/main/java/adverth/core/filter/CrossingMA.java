package adverth.core.filter;

import java.math.BigDecimal;
import java.util.List;

import adverth.core.Filter;
import adverth.core.MAType;
import adverth.core.Outcome;
import adverth.core.TimeFrame;

public class CrossingMA implements Filter {

	private final MAProvider provider;
	private final TimeFrame timeFrame;
	private final MAType firstMAType;
	private final int firstMAPeriods;
	private final MAType secondMAType;
	private final int secondMAPeriods;
	private final int lastPeriods;

	public CrossingMA(MAProvider provider, TimeFrame timeFrame, MAType firstMAType, int firstMAPeriods,
			MAType secondMAType, int secondMAPeriods, int lastPeriods) {
		super();
		this.provider = provider;
		this.timeFrame = timeFrame;
		this.firstMAType = firstMAType;
		this.firstMAPeriods = firstMAPeriods;
		this.secondMAType = secondMAType;
		this.secondMAPeriods = secondMAPeriods;
		this.lastPeriods = lastPeriods;
		if (lastPeriods < 2)
			throw new IllegalArgumentException("'lastPeriods' parameter cannot be minor than 2");
	}
	
	public TimeFrame getTimeFrame() {
		return timeFrame;
	}

	public MAType getFirstMAType() {
		return firstMAType;
	}

	public int getFirstMAPeriods() {
		return firstMAPeriods;
	}

	public MAType getSecondMAType() {
		return secondMAType;
	}

	public int getSecondMAPeriods() {
		return secondMAPeriods;
	}

	public int getLastPeriods() {
		return lastPeriods;
	}

	@Override
	public Outcome accept(String ticker) {
		List<BigDecimal> ma1Values = provider.getMAValues(ticker, firstMAType, firstMAPeriods, timeFrame, lastPeriods);
		List<BigDecimal> ma2Values = provider.getMAValues(ticker, secondMAType, secondMAPeriods, timeFrame, lastPeriods);
		boolean isUpAtStart = ma1Values.get(0).compareTo(ma2Values.get(0)) > 0;
		//System.out.println("Matching " + ma1Values.get(0) + " vs " + ma2Values.get(0) + "...");
		for (int i = 1; i < ma1Values.size(); i++) {
			boolean isCurrentlyUp = ma1Values.get(i).compareTo(ma2Values.get(i)) > 0;
			//System.out.println("Matching " + ma1Values.get(0) + " vs " + ma2Values.get(0) + "...");
			if (isUpAtStart != isCurrentlyUp)
				return Outcome.ok;
		}
		return Outcome.ko;
	}

	public static interface MAProvider {

		List<BigDecimal> getMAValues(String ticker, MAType maType, int periods, TimeFrame timeFrame, int lastValues);
		
	}
	
}
