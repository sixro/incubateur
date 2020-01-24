package net.sixro.xuperior;

import static org.junit.Assert.*;

import org.junit.Test;

public class SynthesizerTest {

	@Test public void availableAudioBufferSizes_returns_expected() {
		assertArrayEquals(new int[]{ 64, 128 }, Synthesizer.availableAudioBufferSizes(128));
	}

}
