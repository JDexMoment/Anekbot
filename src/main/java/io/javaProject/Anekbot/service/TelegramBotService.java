package io.javaProject.Anekbot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import io.javaProject.Anekbot.model.Jokes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class TelegramBotService {

    private final TelegramBot telegramBot;
    private final JokesService jokesService;

    public TelegramBotService(@Autowired TelegramBot telegramBot, JokesService jokesService) {
        this.telegramBot = telegramBot;
        this.jokesService = jokesService;

        this.telegramBot.setUpdatesListener(updates -> {
            updates.forEach(this::handleUpdate);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        }, Throwable::printStackTrace);
    }

    private static final Keyboard keyboard = new ReplyKeyboardMarkup(
            new KeyboardButton("Показать все анекдоты"),
            new KeyboardButton("Случайный анекдот")
    );

    private void handleUpdate(Update update) {
        String botAnswer = "";
        String message = update.message().text();
        List<Jokes> jokeList = jokesService.getAllJokes();


        if (message.startsWith("/start")) {
            botAnswer = "Привет! когда ты сдашь эту лабораторную ты забудешь меня навсегда(((((";
        }
        else if (message.equals("Случайный анекдот")) {
            Random random = new Random();
            Jokes randJoke = jokeList.get(random.nextInt(jokeList.size()));
            botAnswer = "<strong>" + randJoke.getJoke() + "</strong>\n\n" + "Дата создания: " + randJoke.getDate_of_birth() + "\n" + "Дата изменения: " + randJoke.getDate_of_change() + "\n\n\n";
        }
        else if (message.equals("Показать все анекдоты")) {
            for (Jokes joke : jokeList) {
                botAnswer += joke.getId() + ".\n<strong>" + joke.getJoke() + "</strong>\n\n" + "Дата создания: " + joke.getDate_of_birth() + "\n" + "Дата изменения: " + joke.getDate_of_change() + "\n\n\n";
            }
        }

        else {
            botAnswer = "Прости меня, но я тебя не понимаю(";
        }

        SendMessage request = new SendMessage(update.message().chat().id(), botAnswer)
                .parseMode(ParseMode.HTML)
                .disableNotification(true)
                .replyMarkup(keyboard);
        this.telegramBot.execute(request);
    }
}