package kNN;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

public class kNNAlgorithm implements Runnable {

	private Thread th;
	private boolean alive = true;

	private Date start;

	public kNNAlgorithm() {
		th = new Thread(this);
	}

	void start() {
		start = new Date();
		th.start();
	}

	@Override
	public void run() {
		while (alive) {
			alive = false;
		}
		LocalDateTime runTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(new Date().getTime() - start.getTime()), TimeZone.getDefault().toZoneId());
		System.out.println("Time: " + runTime);
	}

}
