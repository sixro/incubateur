package net.sixro.xuperior;

import java.util.*;

import android.media.*;

/**
 * Represents the synthesizer.
 */
public class Synthesizer {

	private static final int MIN_AUDIO_BUFFER_SIZE = 64;

	private static final double TWO_PI = 8. * Math.atan(1.);
	
	public static final int DEFAULT_MAX_AMPLITUDE = 32768;
	public static final int DEFAULT_SAMPLE_RATE = 44100;
	
	private final int sampleRate;
	private final int bufferSize;
	private final int maxConcurrentTones;
	private final int maxAmplitude;
	
	private short waves[][];
	private double[] wavesPh;

	private double tones[];
	@SuppressWarnings("unused")
	private float octaveMultiplier;
	private float pitchRaise;
	private int[] volumes;
	
	private Player player;

	public Synthesizer(int bufferSize, int maxConcurrentTones) {
		this(DEFAULT_SAMPLE_RATE, bufferSize, maxConcurrentTones, DEFAULT_MAX_AMPLITUDE);
	}
	
	Synthesizer(int sampleRate, int bufferSize, int maxConcurrentTones, int maxAmplitude) {
		this.sampleRate = sampleRate;
		this.bufferSize = bufferSize;
		this.maxConcurrentTones = maxConcurrentTones;
		this.maxAmplitude = maxAmplitude;
		
		initInternals();
	}

	private void initInternals() {
		waves = new short[maxConcurrentTones][bufferSize];
		wavesPh = new double[maxConcurrentTones];
		tones = new double[maxConcurrentTones];
		octaveMultiplier = 1.f;
		pitchRaise = 0.f;
		volumes = new int[maxConcurrentTones];
		
		AudioTrack audioTrack = new AudioTrack(
				AudioManager.STREAM_MUSIC, 
				Synthesizer.DEFAULT_SAMPLE_RATE, 
				AudioFormat.CHANNEL_OUT_MONO, 
				AudioFormat.ENCODING_PCM_16BIT, 
				Synthesizer.minAudioDeviceBufferSize(), 
				AudioTrack.MODE_STREAM
		);
		
		player = new Player(bufferSize, this, audioTrack);
	}

	public void tone(int id, double tone) {
		this.tones[id] = tone;
	}
	
	public double tone(int id) {
		return this.tones[id];
	}

	public void volume(int id, int volume) {
		if (volume > 100) volume = 100;
		this.volumes[id] = volume;
	}

	public int volume(int id) {
		return this.volumes[id];
	}

	public void octave(int value) {
		this.octaveMultiplier = (float) Math.pow(2, value);
	}

	public void raisePitch(float hertz) {
		this.pitchRaise = hertz;
	}

	public synchronized void play() {
		player.start();
	}

	public synchronized void stop() {
		player.terminate();
	}

	/**
	 * Returns available audio buffer sizes.
	 * 
	 * @return available audio buffer sizes
	 */
	public static int[] availableAudioBufferSizes() {
		return availableAudioBufferSizes(minAudioDeviceBufferSize());
	}

	/**
	 * Returns the minimum buffer size required by audio device.
	 * 
	 * @return minimum buffer size required by audio device
	 */
	public static int minAudioDeviceBufferSize() {
		return AudioTrack.getMinBufferSize(
				DEFAULT_SAMPLE_RATE, 
				AudioFormat.CHANNEL_OUT_MONO, 
				AudioFormat.ENCODING_PCM_16BIT
		);
	}

	static int[] availableAudioBufferSizes(int greaterAudioBufferSize) {
		int bufferSize = greaterAudioBufferSize;
		List<Integer> availableBufferSizes = new LinkedList<Integer>();
		while (bufferSize > MIN_AUDIO_BUFFER_SIZE) {
			availableBufferSizes.add(bufferSize);
			bufferSize /= 2;
		}
		availableBufferSizes.add(MIN_AUDIO_BUFFER_SIZE);
		
		Collections.sort(availableBufferSizes);

		int[] results = new int[availableBufferSizes.size()];
		int i = 0;
		for (Integer val : availableBufferSizes)
			results[i++] = val;
		return results;
	}
	
	private static class Player extends Thread {

		private final int bufferSize;
		private final Synthesizer synthesizer;
		private final AudioTrack audioTrack;
		
		private boolean terminate;
		private short samples[];
		
		public Player(int bufferSize, Synthesizer synthesizer, AudioTrack audioTrack) {
			super();
			this.bufferSize = bufferSize;
			this.synthesizer = synthesizer;
			this.audioTrack = audioTrack;
			
			init();
		}

		public void terminate() {
			terminate = true;
		}

		private void init() {
			samples = new short[bufferSize];

			setPriority(Thread.MAX_PRIORITY);
		}
		
		@Override
		public void run() {
			audioTrack.play();

			while (! terminate) {
				for (int i = 0; i < synthesizer.waves.length; i++) {
					for (int k = 0; k < synthesizer.waves[i].length; k++) {
						int toneVolume = synthesizer.volumes[i] * synthesizer.maxAmplitude /100;
						synthesizer.waves[i][k] = (short) (toneVolume * Math.sin(synthesizer.wavesPh[i]));
						if (synthesizer.waves[i][k] > Short.MAX_VALUE)
							synthesizer.waves[i][k] = Short.MAX_VALUE;
						else if (synthesizer.waves[i][k] < Short.MIN_VALUE)
							synthesizer.waves[i][k] = Short.MIN_VALUE;
						
						// FIXME pitchRaise
						//synthesizer.wavesPh[i] += TWO_PI * synthesizer.tones[i] * synthesizer.octaveMultiplier / synthesizer.sampleRate;
						synthesizer.wavesPh[i] += TWO_PI * (synthesizer.tones[i] + synthesizer.pitchRaise) / synthesizer.sampleRate;
					}
				}
				
				for (int i = 0; i < samples.length; i++) {
					samples[i] = 0;
					for (int c = 0; c < synthesizer.waves.length; c++)
						samples[i] += 1. / synthesizer.maxConcurrentTones * synthesizer.waves[c][i];
					
					if (samples[i] > Short.MAX_VALUE)
						samples[i] = Short.MAX_VALUE;
					else if (samples[i] < Short.MIN_VALUE)
						samples[i] = Short.MIN_VALUE;
				}
				
				audioTrack.write(samples, 0, samples.length);
			}

			audioTrack.stop();
			audioTrack.release();
		}
		
	}

}
