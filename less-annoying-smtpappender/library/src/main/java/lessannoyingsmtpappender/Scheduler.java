package lessannoyingsmtpappender;

import java.util.TimerTask;

public interface Scheduler {

	void runAtTheStrokeOfTheNextHour(TimerTask task);

}
