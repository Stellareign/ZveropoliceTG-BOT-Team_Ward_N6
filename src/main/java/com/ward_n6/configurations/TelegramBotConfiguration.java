package com.ward_n6.configurations;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class TelegramBotConfiguration {


        @Bean // спринг помещает бота в свой контекст для дальнейшего инжекта
        public TelegramBot telegramBot(@Value("${telegram.bot.token}") String token) {
            return new TelegramBot(token);
        }

    }