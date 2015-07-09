package lessannoyingsmtpappender;

import java.util.Timer;
import java.util.TimerTask;

import org.joda.time.DateTime;

public class SchedulerJavaTimer implements Scheduler {

	private Timer timer;
	
	public SchedulerJavaTimer() {
		super();
	}

	@Override
	public void runAtTheStrokeOfTheNextHour(TimerTask task) {
		if (timer != null)
			timer.cancel();
		timer = newTimer();
		timer.schedule(task, delayToNextHour());
	}

	static long delayToNextHour() {
		DateTime now = DateTime.now();
		DateTime nextHour = now
			.plusHours(1)
			.withMinuteOfHour(0)
			.withSecondOfMinute(0)
			.withMillisOfSecond(0);
		return nextHour.getMillis() - now.getMillis();
	}

	private static Timer newTimer() {
		return new Timer(SchedulerJavaTimer.class.getName(), true);
	}

}

