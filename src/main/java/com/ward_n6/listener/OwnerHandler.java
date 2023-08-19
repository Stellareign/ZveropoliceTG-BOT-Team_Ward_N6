package com.ward_n6.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.ward_n6.entity.owners.Owner;
import com.ward_n6.repository.Impl.OwnerServiceImpl;

import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OwnerHandler implements EventHandler {
    private final OwnerServiceImpl ownerServiceImpl;
    private final TelegramBot telegramBot;
    private Owner owner = new Owner();

    public OwnerHandler(OwnerServiceImpl ownerServiceImpl, TelegramBot telegramBot) {
        this.ownerServiceImpl = ownerServiceImpl;
        this.telegramBot = telegramBot;
    }

    private static final Pattern OWNER_PHONE_NUMBER_PATTERN = Pattern.compile("8-\\d{3}-\\d{3}-\\d{2}-\\d{2}");
    private Consumer<Update> actionOnNextMessage; // переменная для определения действий над поступаемым сообщением

    @Override
    public boolean handle(Update update) {
        if (actionOnNextMessage != null) {
            actionOnNextMessage.accept(update);
            actionOnNextMessage = null;
            return false;
        }
        var text = update.message().text();
        switch (text) {
            case "/ln":
                telegramBot.execute(new SendMessage(update.message().chat().id(), "Укажите Вашу фамилию с заглавной буквы"));
                actionOnNextMessage = upd -> {
                    owner.setLastName(upd.message().text());
                    telegramBot.execute(new SendMessage(update.message().chat().id(), "Фамилия записана!"+
                            """
                                Команды для отчёта:
                                1. /ID - указать id питомца
                                2. /action - отчёт о поведении питомца
                                3. /health - отчёт о здоровье питомца
                                4. /feed - отчёт о питании питомца
                                5. /save - сохранить отчёт
                                    """
                    ));
                };
                break;

            case "/fn":
                telegramBot.execute(new SendMessage(update.message().chat().id(), "Укажите Ваше имя с заглавной буквы"));
                actionOnNextMessage = upd -> {
                    owner.setFirstName(upd.message().text());
                    telegramBot.execute(new SendMessage(update.message().chat().id(), "Имя записано!"+
                            """
                                Команды для отчёта:
                                1. /ID - указать id питомца
                                2. /action - отчёт о поведении питомца
                                3. /health - отчёт о здоровье питомца
                                4. /feed - отчёт о питании питомца
                                5. /save - сохранить отчёт
                                    """

));
                };
                break;


            case "/phone":
                Matcher matcher = OWNER_PHONE_NUMBER_PATTERN.matcher(update.message().text());
                telegramBot.execute(new SendMessage(update.message().chat().id(), "Укажите Ваш телефон для связи в формате: " +
                        "" + "\n" + "8-XXX-XXX-XX-XX"));
                actionOnNextMessage = upd -> {
//                    if (matcher.matches()) {
                    owner.setPhoneNumber(upd.message().text());
                    telegramBot.execute(new SendMessage(update.message().chat().id(), "Номер записан!"));
//                    } else {
//                        telegramBot.execute(new SendMessage(update.message().chat().id(), "Телефон указан неверно, попробуйте ещё раз"));
//                    }
                };
                break;

            case "/save":

                owner.setOwnerId(update.message().chat().id().longValue());
                ownerServiceImpl.save(owner);
                telegramBot.execute(new SendMessage(update.message().chat().id(), "Ваши данные " + "\n" + owner.toString()
                        + "добавлены в нашу базу. Для удаления данных из нашей базы обратитесь в волонтёру"));

               return true;


            case "/delete":
                telegramBot.execute(new SendMessage(update.message().chat().id(), "К сожалению, эта функция пока не работает. " +
                        "Для удаления данных из нашей базы обратитесь в волонтёру."));
                ownerServiceImpl.deleteById(update.message().chat().id());
                telegramBot.execute(new SendMessage(update.message().chat().id(), "Ваши данные " + owner.toString() + "добавлены в нашу базу." +
                        "Для удаления данных из нашей базы обратитесь в волонтёру"));
                return true;

        }

        return false;
    }
}


