package com.ward_n6.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import com.ward_n6.Keyboard.Bot;
import com.ward_n6.entity.BotMessaging;
import com.ward_n6.service.BotMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class TelegramBotPetShelterUpdatesListener implements UpdatesListener {
    private Logger logger = LoggerFactory.getLogger(TelegramBotPetShelterUpdatesListener.class);

    private final BotMessageService botMessageService;
    private final TelegramBot telegramBot;

    public TelegramBotPetShelterUpdatesListener(TelegramBot telegramBot, BotMessageService botMessageService) {
        this.botMessageService = botMessageService;
        this.telegramBot = telegramBot;
    }


    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    private Bot bot;
    boolean startSelected = false; // переменная для подтверждения старта

    @Override
    public int process(List<Update> updates) {
        try {
            updates.stream() // получаем поток апдейтов из листа
                    .filter(update -> update.message() != null)// фильтруем по тем, что не нулл
                    .forEach(update -> { // итерируемся по ним
                        logger.info("Processing update: {}", update); // записываем лог апдейтов на уровне инфо
                        Message message = update.message(); // получаем сообщение из текущего обновления
                        Long chatId = message.chat().id(); // получаем идентификатор чата, к которому относится апдейт
                        String messageText = message.text(); // получаем текст сообщения
                        switch (messageText) {
                            case "/start":
                                startSelected = true;
                                sendMessage(chatId, "Здравствуйте. Это чатбот приюта для животных. " +
                                        "Какой приют Вас интересует?");
                                break;
                            case "/dogs":
                                if (startSelected) {
                                    sendMessage(chatId, "Вас приветствует приют для собак. " +
                                            "Выберите интересующий Вас пункт меню.");
                                }
                                break;
                            case "/cats":
                                if (startSelected) {
                                    sendMessage(chatId, "Вас приветствует приют для кошек. " +
                                            "Выберите интересующий Вас пункт меню.");
                                }
                                break;
                            case "/volunteer":
                                sendMessage(chatId,
                                        "Вы позвали волонтёра приюта. Ожидайте, с Вами свяжутся " +
                                                "в течение 30 мин.");
                            default:
                                if (messageText != null) { // проверяем, не пустой ли текст
                                    saveMessages(chatId, messageText);
                                }
                                break;
                        }
                    });
        } catch (Exception e) {
            logger.error(e.getMessage()); // ловим ошибку
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL; // успешно завершаем метод, без падения
    }


    private void saveMessages(long chatId, String messageText) {
        if (messageText.isEmpty()) { // обрабатываем нулловое значение из парсинга
            sendMessage(chatId, "Неверный формат сообщения");

        } else {
            BotMessaging botMessaging = new BotMessaging(); // создаём новое напоминание
            botMessaging.setChatId(chatId); // присваиваем созданному напоминанию значения из нашего апдейта
            botMessaging.setBotMessage(messageText);
            botMessageService.save(botMessaging); // сохранили наше сообщение в БД
        }
    }


    // ОТПРАВКА ОТВЕТА БОТА:
    private void sendMessage(Long chatId, String message) { // выносим отправку в отдельный метод
        SendMessage sendMessage = new SendMessage(chatId, message);
//        sendMessage.replyMarkup(replyKeyboardMarkup);
        SendResponse sendResponse = telegramBot.execute(sendMessage); // сохраняем в переменную sendMessage
        if (!sendResponse.isOk()) { // если отправка сообщения не удалась
            logger.error("Ошибка отправки сообщения: {}", sendResponse.description()); // сообщаем об ошибке

        }
    }

//******************************** ПРОБА КНОПОК (неудачно пока что) ************************************************
//    @Override
//    public int process(List<Update> updates) {
//        try {
//            updates.stream()
//                    .filter(update -> update.message() != null)
//                    .forEach(update -> {
//                        logger.info("Processing update: {}", update);
//                        Message message = update.message();
//                        Long chatId = message.chat().id();
//                        String messageText = message.text();
//                        switch (messageText) {
//                            case "/start":
//                                startSelected = true;
//                                sendMessage(chatId, "Здравствуйте. Это чатбот приюта для животных. " +
//                                        "Какой приют Вас интересует?", getMainMenu());
//
//
//                                break;
//                            case "/dogs":
//                                if (startSelected) {
//                                    sendMessage(chatId, "Вас приветствует приют для собак. " +
//                                            "Выберите интересующий Вас пункт меню.", getSheltersMenu());
//
//                                }
//                                break;
//                            case "/cats":
//                                if (startSelected) {
//                                    sendMessage(chatId, "Вас приветствует приют для кошек. " +
//                                            "Выберите интересующий Вас пункт меню.", getSheltersMenu());
//                                    getSheltersMenu();
//                                }
//                                break;
//                            case "/volunteer":
//                                sendMessage(chatId,
//                                        "Вы позвали волонтёра приюта. Ожидайте, с Вами свяжутся " +
//                                                "в течение 30 мин.", getMainMenu());
//                                break;
//                            default:
//                                if (messageText != null) {
//                                    saveMessages(chatId, messageText);
//                                }
//                                break;
//                        }
//                    });
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        }
//        return UpdatesListener.CONFIRMED_UPDATES_ALL;
//    }

    private ReplyKeyboardMarkup getMainMenu() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("/dogs"));
        row1.add(new KeyboardButton("/cats"));
        keyboard.add(row1);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup getSheltersMenu() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Информация о приюте"));
        row1.add(new KeyboardButton("Оформить пропуск"));
        keyboard.add(row1);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
}
