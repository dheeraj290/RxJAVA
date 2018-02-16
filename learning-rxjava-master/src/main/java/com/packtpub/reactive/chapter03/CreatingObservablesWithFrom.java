package com.packtpub.reactive.chapter03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.packtpub.reactive.common.Program;

import rx.Observable;
import rx.functions.Action1;

/**
 * A set of examples of using Observable.from.
 * 
 * @author meddle
 */
public class CreatingObservablesWithFrom implements Program {

	public static Action1<?> N = (v) -> {
	};
	public static Action1<Throwable> NE = (e) -> {
	};

	@Override
	public String name() {
		return "Creating Observables with Observable.from";
	}

	@Override
	public int chapter() {
		return 3;
	}

	@Override
	public void run() {
		// from(list)
		List<String> list = Arrays.asList("blue", "red", "green", "yellow",
				"orange", "cyan", "purple");

		Observable<String> listObservable = Observable.from(list);
		listObservable.subscribe(System.out::println);
		listObservable.subscribe(color -> System.out.print(color + "|"), NE,
				System.out::println);
		listObservable.subscribe(color -> System.out.print(color + "/"), NE,
				System.out::println);

		// from(Iterable)
		Path resources = Paths.get("src", "main", "resources");
		
		try (DirectoryStream<Path> dStream = Files.newDirectoryStream(resources)) {
			Observable<Path> dirObservable = Observable.from(dStream);
			dirObservable.subscribe(
					v -> {
						
					try {
						if(v.toString().contains("letters.txt") || v.toString().contains("temp.txt")) {
							System.out.println(v);
							BufferedReader reader = new BufferedReader(new FileReader(v.toString()));
							System.out.println(reader.lines().collect(Collectors.joining())); 
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					}
					
					);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 

		// from(array)
		Observable<Integer> arrayObservable = Observable.from(new Integer[] {
				3, 5, 8 });
		arrayObservable.subscribe(System.out::println);
	}
	
	public static void main(String[] args) {
		
		new CreatingObservablesWithFrom().run();
	}
	
	

}
