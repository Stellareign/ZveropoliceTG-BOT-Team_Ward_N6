package com.ward_n6.listener;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.TelegramBot;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Consumer;

public class PhotoHandler implements EventHandler {
    private final TelegramBot telegramBot;

    public PhotoHandler(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @Value("${path.to.file}")
    String folderPath; // путь к файлам
    private Consumer<Update> actionOnNextMessage;

    @Override
    public boolean handle(Update update) {
        if (actionOnNextMessage != null) {
            actionOnNextMessage.accept(update);
            actionOnNextMessage = null;
            return false;
        }
        var messagePhoto = update.message().photo();
        var messageText = update.message().photo();
        telegramBot.execute(new SendMessage(update.message().chat().id(),
                "Отправьте фото Вашего питомца."));
        actionOnNextMessage = upd -> {
            if (messagePhoto != null) {
                var photo = update.message().photo()[3]; // 3 - самое лучшее качество
                var getFile = telegramBot.execute(new GetFile(photo.fileId()));
                var outFile = new File(folderPath, (photo.fileId() + "-owner-" + update.message().chat().id() + ".jpeg")); // добавлено
                try (var in = new URL(telegramBot.getFullFilePath(getFile.file())).openStream();
                     var out = new FileOutputStream(outFile)) {

                    in.transferTo(out);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }  else  telegramBot.execute(new SendMessage(update.message().chat().id(),
                    "Вы не отправили фото. Отчёт не полный."));
        }; return false;
    }
}
