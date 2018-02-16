package com.packtpub.reactive.chapter03;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import com.packtpub.reactive.common.Program;

/**
 * Demonstrates using Observable.just for creating Observables.
 * 
 * @author meddle
 */
public class CreatingObservablesUsingJust implements Program {

	@Override
	public String name() {
		return "Using the Observable.just method to create Observables";
	}

	@Override
	public int chapter() {
		return 3;
	}

	public static class User {
		
		private final String forename;
		private final String lastname;

		public User(String forename, String lastname) {
			this.forename = forename;
			this.lastname = lastname;
		}

		public String getForename() {
			return this.forename;
		}

		public String getLastname() {
			return this.lastname;
		}
		
	}

	@Override
	public void run() {
		System.out.println("klsjk==="+Thread.currentThread().getName());
		
		Observable.just('S','R')
		.subscribeOn(Schedulers.io())
		.subscribe(
				//System.out::println
				onCall -> {System.out.println(onCall);
				System.out.println(Thread.currentThread().getName());},
				error -> {System.out.println(error.getMessage());},
				() -> {System.out.println("complete");}
				
				);
		
		Observable.just('R', 'x', 'J', 'a', 'v', 'a').subscribe(
				System.out::print, System.err::println, System.out::println);

		Observable.just(new User("Dali", "Bali"))
				.map(u -> u.getForename() + " " + u.getLastname())
				.subscribe(System.out::println);
	}
	
	public static void main(String[] args) {
		new CreatingObservablesUsingJust().run();
		System.out.println("done");
	}

}
