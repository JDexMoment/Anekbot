package io.javaProject.Anekbot;

import io.javaProject.Anekbot.model.Jokes;
import io.javaProject.Anekbot.repository.JokesRepository;
import io.javaProject.Anekbot.service.JokesServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class AnekbotApplicationTests {

	private JokesRepository jokesRepository = Mockito.mock(JokesRepository.class);

	private final JokesServiceImpl jokesService = new JokesServiceImpl(jokesRepository);

	@DisplayName("Test register new joke")
	@Test
	void registerJoke() {

		Jokes joke = new Jokes("Test joke", new Date());
		jokesService.registerJokes(joke);

		Mockito.verify(jokesRepository, Mockito.times(1)).save(joke);
	}

	@DisplayName("Test delete joke")
	@Test
	void deleteJokeById() {
		Long jokeId = 1L;
		jokesService.deleteJokeById(jokeId);

		Mockito.verify(jokesRepository, Mockito.times(1)).deleteById(jokeId);
	}

	@DisplayName("Test update joke")
	@Test
	void putJokeById() {
		Long jokeId = 1L;
		Jokes updatedJoke = new Jokes();
		updatedJoke.setJoke("Test joke");

		jokesService.putJokeById(jokeId, updatedJoke);

		Mockito.verify(jokesRepository, Mockito.times(1)).findById(jokeId);
		Mockito.verify(jokesRepository, Mockito.times(1)).save(updatedJoke);
	}
}
