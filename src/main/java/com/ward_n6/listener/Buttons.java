package com.ward_n6.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.vdurmont.emoji.EmojiParser;
import org.springframework.stereotype.Component;

import static com.ward_n6.listener.MessageStringsConstants.*;
@Component
public class Buttons extends Keyboards {
    private final TelegramBot telegramBot;
    public Buttons(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;


    }

    public void afterStartMenu(long chatId) {
        Keyboards keyboards = new Keyboards();
        SendMessage sendMessage = new SendMessage(chatId, "Здравствуйте. Это чат-бот приюта для животных. \n Какой приют Вас интересует?");
        afterStartMenuKeyboard();
        sendMessage.replyMarkup(keyboards.afterStartMenuKeyboard());
        telegramBot.execute(sendMessage);
    }

    // КОШКИ
    public void catButton(long chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "Вы выбрали приют для кошек!\n" + CAT_DESCRIPTION);
        Keyboards keyboards = new Keyboards();
//        InlineKeyboardButton catHouseInfoButton = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Информация о приюте " + ":information_source:"));
//        catHouseInfoButton.callbackData("ИНФО_КОШКИ");
//        InlineKeyboardButton userRegisterData = new InlineKeyboardButton("РЕГИСТРАЦИЯ В НАШЕЙ БАЗЕ ДАННЫХ");
//        userRegisterData.callbackData("РЕГИСТРАЦИЯ_ПОЛЬЗОВАТЕЛЯ");
//        InlineKeyboardButton catHouseHowToTakeButton = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Как взять кошку из приюта " + ":cat:"));
//        catHouseHowToTakeButton.callbackData("КАК_ЗАБРАТЬ_КОШКУ");
//        InlineKeyboardButton catHouseOwnerReportButton = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Прислать отчёт о питомце " + ":memo:"));
//        catHouseOwnerReportButton.callbackData("ОТЧЁТ");
//        InlineKeyboardButton callVoluntier = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Позвать волонтёра " + ":necktie:"));
//        callVoluntier.callbackData("ВОЛОНТЁР");
//
//        InlineKeyboardButton chooseOwnerDataButton = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Оставить контакты" + ":white_check_mark:"));
//        chooseOwnerDataButton.callbackData("ЗАРЕГИСТРИРОВАТЬСЯ_В_ПРИЮТЕ");
//
//        Keyboard keyboard = new InlineKeyboardMarkup()
//                .addRow(catHouseInfoButton)
//                .addRow(catHouseHowToTakeButton)
//                .addRow(catHouseOwnerReportButton)
//                .addRow(callVoluntier)
//                .addRow(chooseOwnerDataButton);

        catButtonKeyboard();
        sendMessage.replyMarkup(keyboards.catButtonKeyboard());
        telegramBot.execute(sendMessage);
    }

    //СОБАКИ
    public void dogButton(long chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "Вы выбрали приют для собак!\n" + DOG_DESCRIPTION);
        Keyboards keyboards = new Keyboards();
//        InlineKeyboardButton dogHouseInfoButton = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Информация о приюте " + ":information_source:"));
//        dogHouseInfoButton.callbackData("ИНФО_СОБАКИ");
//        InlineKeyboardButton dogHouseHowToTakeButton = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Как взять собаку из приюта " + ":dog:"));
//        dogHouseHowToTakeButton.callbackData("КАК_ЗАБРАТЬ_СОБАКУ");
//        InlineKeyboardButton dogHouseOwnerReportButton = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Прислать отчёт о питомце " + ":memo:"));
//        dogHouseOwnerReportButton.callbackData("ОТЧЁТ");
//        InlineKeyboardButton callVoluntier = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Позвать волонтёра " + ":necktie:"));
//        callVoluntier.callbackData("ВОЛОНТЁР");
//
//        InlineKeyboardButton chooseOwnerDataButton = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Оставить контакты" + ":white_check_mark:"));
//        chooseOwnerDataButton.callbackData("ЗАРЕГИСТРИРОВАТЬСЯ_В_ПРИЮТЕ");
//
//        Keyboard keyboard = new InlineKeyboardMarkup()
//                .addRow(dogHouseInfoButton)
//                .addRow(dogHouseHowToTakeButton)
//                .addRow(dogHouseOwnerReportButton)
//                .addRow(callVoluntier)
//                .addRow(chooseOwnerDataButton);
        dogButtonKeyboard();
        sendMessage.replyMarkup(keyboards.dogButtonKeyboard());
        telegramBot.execute(sendMessage);
    }

    //INFO DOG
    public void dogInfoButton(long chatId) {
//        SendMessage sendMessage = new SendMessage(chatId, petShelter.getDescription()+"\n"+petShelter.getShelterAddress()+"\n"+petShelter.getSecurityContact()+"\n"+petShelter.getSafetyAdvice()+"\n"+petShelter.getHelpShelter());
        SendMessage sendMessage = new SendMessage(chatId, SHELTER_INFO);
        Keyboards keyboards = new Keyboards();
//        InlineKeyboardButton wantToHelpButton = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode(":two_hearts: " + "Я хочу пожертвовать в приют ".toUpperCase() + ":two_hearts:"));
//        wantToHelpButton.callbackData("СДЕЛАТЬ_ПОЖЕРТВОВАНИЕ");
//        InlineKeyboardButton callVoluntier = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Позвать волонтёра " + ":necktie:"));
//        callVoluntier.callbackData("ВОЛОНТЁР");
//        Keyboard keyboard = new InlineKeyboardMarkup()
//                .addRow(wantToHelpButton)
//                .addRow(callVoluntier);
        dogInfoButtonKeyboard();
        sendMessage.replyMarkup(keyboards.dogInfoButtonKeyboard());
        telegramBot.execute(sendMessage);
    }

    // INFO CAT
    public void catInfoButton(long chatId) {
//        SendMessage sendMessage = new SendMessage(chatId, petShelter.getDescription()+"\n"+petShelter.getShelterAddress()+"\n"+petShelter.getSecurityContact()+"\n"+petShelter.getSafetyAdvice()+"\n"+petShelter.getHelpShelter());
        SendMessage sendMessage = new SendMessage(chatId, SHELTER_INFO);
        Keyboards keyboards = new Keyboards();
//        InlineKeyboardButton wantToHelpButton = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode(":two_hearts: " + "Я хочу пожертвовать в приют ".toUpperCase() + ":two_hearts:"));
//        wantToHelpButton.callbackData("СДЕЛАТЬ_ПОЖЕРТВОВАНИЕ");
//        InlineKeyboardButton callVoluntier = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Позвать волонтёра " + ":necktie:"));
//        callVoluntier.callbackData("ВОЛОНТЁР");
//        Keyboard keyboard = new InlineKeyboardMarkup()
//                .addRow(wantToHelpButton)
//                .addRow(callVoluntier);
        catInfoButtonKeyboard();
        sendMessage.replyMarkup(keyboards.catInfoButtonKeyboard());
        telegramBot.execute(sendMessage);
    }

    //TAKE PET DOG
    public void wantToTakeDogButton(long chatId) {
        SendMessage sendMessage = new SendMessage(chatId, EmojiParser.parseToUnicode(HOW_TO_TAKE_PET));
        Keyboards keyboards = new Keyboards();
//        InlineKeyboardButton callVoluntier = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Позвать волонтёра " + ":necktie:"));
//        callVoluntier.callbackData("ВОЛОНТЁР");
//        InlineKeyboardButton recommendationDog = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode(":point_up: Рекомендации перед тем, как завести собаку! :point_up:"));
//        recommendationDog.callbackData("РЕКОМЕНДАЦИЯ_СОБАКИ");
//
//        InlineKeyboardButton chooseDog = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Забрать собаку" + ":dog:"));
//        chooseDog.callbackData("ЗАБРОНИРОВАТЬ_ПИТОМЦА");
//        Keyboard keyboard = new InlineKeyboardMarkup()
//                .addRow(recommendationDog)
//                .addRow(callVoluntier)
//                .addRow(chooseDog);
        wantToTakeDogButtonKeyboard();
        sendMessage.replyMarkup(keyboards.wantToTakeDogButtonKeyboard());
        telegramBot.execute(sendMessage);
    }

    //TAKE PET CAT
    public void wantToTakeCatButton(long chatId) {
        SendMessage sendMessage = new SendMessage(chatId, EmojiParser.parseToUnicode(HOW_TO_TAKE_PET));
        Keyboards keyboards = new Keyboards();
//        InlineKeyboardButton callVoluntier = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Позвать волонтёра " + ":necktie:"));
//        callVoluntier.callbackData("ВОЛОНТЁР");
//        InlineKeyboardButton recommendationCat = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode(":point_up: Рекомендации перед тем, как завести кошку! :point_up:"));
//        recommendationCat.callbackData("РЕКОМЕНДАЦИЯ_КОШКИ");
//
//        InlineKeyboardButton chooseCat = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Забрать кошку" + ":cat:"));
//        chooseCat.callbackData("ЗАБРОНИРОВАТЬ_ПИТОМЦА");
//
//        Keyboard keyboard = new InlineKeyboardMarkup()
//                .addRow(recommendationCat)
//                .addRow(callVoluntier)
//                .addRow(chooseCat);
        wantToTakeCatButtonKeyboard();
        sendMessage.replyMarkup(keyboards.wantToTakeCatButtonKeyboard());
        telegramBot.execute(sendMessage);
    }

    //ВОЛОНТЁР
    public void callVoluntier(long chatId) {
        SendMessage sendMessage = new SendMessage(chatId, EmojiParser.parseToUnicode(":white_check_mark:Через " +
                "некоторое время с Вами свяжется волонтёр и ответит на интересующие вопросы!:wink:"));
        telegramBot.execute(sendMessage);
    }

    // ОТЧЁТ
    public void sendOwnerHowReport(long chatId) {
        SendMessage sendMessage = new SendMessage(chatId, EmojiParser.parseToUnicode(HOW_REPORT));
        TelegramBotPetShelterUpdatesListener.reportSelect = true;
        telegramBot.execute(sendMessage);
    }

    // ДАННЫЕ УСЫНОВИТЕЛЯ
    public void sendOwnerData(long chatId) {
        SendMessage sendMessage = new SendMessage(chatId, EmojiParser.parseToUnicode("""
                :white_check_mark: Введите или нажмите команду
                 /myData"""
        ));
        TelegramBotPetShelterUpdatesListener.getOwnerDataSelect = true;
        telegramBot.execute(sendMessage);
    }

    // БРОНИРОВАНИЕ ПИТОМЦА
    public void reservePet(long chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "Чтобы забронировать питомца, " +
                "введите или нажмите команду:\n /takePet");
        telegramBot.execute(sendMessage);
    }

    // РЕКОМЕНДАЦИИ ДЛЯ КОШЕК
    public void dogRecommendation(long chatId) {
        SendMessage sendMessage = new SendMessage(chatId, EmojiParser.parseToUnicode(DOG_RECOMMEDATION));
        telegramBot.execute(sendMessage);
    }

    // РЕКОМЕНДАЦИИ ДЛЯ СОБАК
    public void catRecommendation(long chatId) {
        SendMessage sendMessage = new SendMessage(chatId, EmojiParser.parseToUnicode(CAT_RECOMMENDATION));
        telegramBot.execute(sendMessage);

    }



}
