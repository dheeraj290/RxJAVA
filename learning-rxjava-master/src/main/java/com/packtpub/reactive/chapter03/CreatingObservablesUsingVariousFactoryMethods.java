package com.packtpub.reactive.chapter03;

import static com.packtpub.reactive.common.Helpers.subscribePrint;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

import com.packtpub.reactive.common.Program;

/**
 * Demonstrates using Observable.interval, Observable.timer, Observable.error,
 * Observable.never, Observable.empty and Observable.range for Obsevable creation.
 * 
 * @author meddle
 */
public class CreatingObservablesUsingVariousFactoryMethods implements Program {

	@Override
	public String name() {
		return "A few factory methods for creating Observables";
	}

	@Override
	public int chapter() {
		return 3;
	}

	@Override
	public void run() {
		subscribePrint(Observable.interval(500L, TimeUnit.MILLISECONDS),
				"Interval Observable");
		
		Observable.interval(1000L, TimeUnit.MILLISECONDS).subscribe(
				v -> {System.out.println("helol");}
				);

		subscribePrint(Observable.timer(4L, 1L, TimeUnit.SECONDS),
				"Timed Interval Observable");

		subscribePrint(Observable.timer(1L, TimeUnit.SECONDS),
				"Timer Observable");

		subscribePrint(Observable.error(new Exception("Test Error!")),
				"Error Observable");

		subscribePrint(Observable.empty(), "Empty Observable");
		subscribePrint(Observable.never(), "Never Observable");
		
		subscribePrint(Observable.range(1, 10), "Range Observable");
		
		try {
			System.out.println("hello");
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
		}

	}
	
	public static void main(String[] args) {
		new CreatingObservablesUsingVariousFactoryMethods().run();
	}

}
