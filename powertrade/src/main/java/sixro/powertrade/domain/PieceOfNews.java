package sixro.powertrade.domain;

import java.net.URL;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PieceOfNews {

	private final String title;
	private final String source;
	private final LocalDateTime datetime;
	private final String summary;
	private final URL link;

}
