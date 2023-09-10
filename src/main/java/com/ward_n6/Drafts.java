package com.ward_n6;

import com.ward_n6.repository.owner.OwnerRepository;

import java.util.regex.Pattern;

/***
 * КЛАСС ДЛЯ ХРАНЕНИЯ ЧЕРНОВИКОВ МЕТОДОВ
 */
public class Drafts {
    private final OwnerRepository ownerRepository;

    private static final Pattern OWNER_DATA_PATTERN = Pattern.compile("([А-я])\\s|\\n + ([А-я]) \\s|\\n +" +
            "(\\d-\\d{3}-\\d{3}-\\d{2}-\\d{2})"); //символы и \\s - пробел, в (...) - группы паттерна

    public Drafts(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

//    // СОХРАНЕНИЕ ПЕРСОНЫ в БД (не используем)
//    private void saveOwner(long chatId, String messageText) {
//        Matcher matcher = OWNER_DATA_PATTERN.matcher(messageText); // поиск соответствия сообщения заданным параметрам
//        if (matcher.find()) {
//            Owner owner = new Owner();
//            String ownerLastName = matcher.group(1);
//            String ownerFirstName = matcher.group(2);
//            String ownerPhone = matcher.group(3);
//            owner.setLastName(ownerLastName);
//            owner.setFirstName(ownerFirstName);
//            owner.setPhoneNumber(ownerPhone);
//            ownerRepository.save(owner);
//            sendMessage(chatId, "Ваши данные добавлена в нашу базу: " + owner.toString() +
//                    "Для удаления Ваших данных из нашей базы обратитесь к волонтёру");
//        } else {
//            sendMessage(chatId, "Данные указаны неверно. Пожалуйста, введите Ваши данные в указанном формате.");
//        }
//    }

    //************************************************

//    private void sendOwnerHowReport(long chatId) {
//        SendMessage sendMessage = new SendMessage(chatId, EmojiParser.parseToUnicode(HOW_REPORT));
//        InlineKeyboardButton textButton = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Отправить текст :memo:"));
//        InlineKeyboardButton photoButton = new InlineKeyboardButton(EmojiParser
//                .parseToUnicode("Отправить фото :camera:"));
//        textButton.callbackData("ОТЧЁТ");
//        photoButton.callbackData("ОТЧЁТ_ФОТО");
//        Keyboard keyboard = new InlineKeyboardMarkup().addRow(textButton).addRow(photoButton);
//        sendMessage.replyMarkup(keyboard);
//
//    }

    //************************  PET_CONTROLLER****
    //        @PostMapping
//        @Operation(summary = "Добавление животного в список", description = "нужно заполнить все поля карточки животного в Body")
//        public ResponseEntity<Pet> createPet(@RequestBody Pet pet) throws JsonProcessingException, PutToMapException {
//            Pet newPet = petService.addPet(pet);
//            return ResponseEntity.ok(newPet);
//        }
    //    @PostMapping("/json")
//    @Operation(summary = "Добавление рецепта из файла в книгу", description = "будем читать файл pets.json")
//    public ResponseEntity<Pet> readPetFromJsonFile() {
//        return ResponseEntity.ok().build();
//    }
//        @GetMapping("/{petId}")
//        @Operation(summary = "Показать одно животное по id", description = "нужно указать id животного")
//        public ResponseEntity<Pet> getPet(@PathVariable int petId) {
//            Pet pet = petService.getPetById(petId);
//            if (pet == null) {
//                return ResponseEntity.notFound().build();
//            }
//            return ResponseEntity.ok(pet);
//        }


    //**************************************** фОТО ******************************
//    @Value("${path.to.file}")
//    String folderPath; // путь к файлам
//
//    private void getPhoto(Update update) {
//        PhotoSize[] messagePhoto = update.message().photo(); // получаем сообщение из текущего обновления
//        Long chatId = update.message().chat().id(); // получаем идентификатор чата, к которому относится апдейт
////       PhotoSize[] messagePhoto = message.photo();
//        if (messagePhoto != null) {
//            var photo = update.message().photo()[3]; // 3 - самое лучшее качество
//            var getFile = telegramBot.execute(new GetFile(photo.fileId()));
//            var outFile = new File(folderPath, (photo.fileId() + "-owner-" + chatId + ".jpeg")); // добавлено
//            try (var in = new URL(telegramBot.getFullFilePath(getFile.file())).openStream();
//                 var out = new FileOutputStream(outFile)) {
//                // для примера просто сделал случайное название файла, лучше прописать путь и расширение
//                in.transferTo(out);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
    //ИЛИ ФОТО ПО-ДРУГОМУ
//    public void getPhoto (Update update, long chatId,long petId) {
//        GetFile getFile = new GetFile(update.message().photo()[2].fileId());
//        GetFileResponse getFileResponse = telegramBot.execute(getFile);
//        var messagePhoto = update.message().photo(); //создаём переменную и присваиваем ей значение из сообщения
//        if (messagePhoto != null && messagePhoto.length > 0) {
//            try {
//                File file = getFileResponse.file();
//                file.fileSize();
//
//                byte[] fileContent = telegramBot.getFileContent(file);
//                photo.setOwnerId(chatId);
//                photo.setPetId(petId);
//                photo.setFileName(folderPath + file.fileId() + "-owner-" + chatId);
//                photo.setDateTime(LocalDateTime.now());
//                photo.setPhoto(fileContent);
//                photoRepository.save(photo);
//                isPhoto = true;
//
//                telegramBot.execute(new SendMessage(update.message().chat().id(), "Фото загружено!" + REPORT));
//
//            } catch (IOException e) {
//                System.out.println("Ошибка загрузки фото!");
//                logger.error("Ошибка: файл не загружен");
//            }
//        } else {
//            telegramBot.execute(new SendMessage(update.message().chat().id(), "Вы не загрузили фото" + REPORT));
//
//        }
//    }
//********************************************АРХИВ
    //    public Boolean removePetsOwnerToArchive(PetsOwner petsOwner) {
//        // убираем парочку из таблицы PetsOwner и заносим в одноименный архив
//        // после успешного прохождения (окончания) испытательного срока
//        try {
//            PetsOwnerArchive newPetsOwnerArchive = new PetsOwnerArchive(
//                    petsOwner.getDateBegin(),
//                    petsOwner.getDateEnd(),
//                    petsOwner.getOwnerId(),
//                    petsOwner.getFirstName(),
//                    petsOwner.getLastName(),
//                    petsOwner.getPhoneNumber(),
//                    petsOwner.getPetId(),
//                    petsOwner.getBread(),
//                    petsOwner.getPetBirthDay(),
//                    petsOwner.getPetName()
//                    );
//            petsOwnerArchiveRepository.save(newPetsOwnerArchive);
//            petsOwnerRepository.deleteById(petsOwner.getId());
//            return true;
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
//    }
//    ********* ОВНЕР-ПЕТС-ХЭНДЛЕР-НАЧАЛЬНЫЙ
//    @Override
//    public boolean handle(Update update) {
//        if (actionOnNextMessage != null) {
//            actionOnNextMessage.accept(update);
//            actionOnNextMessage = null;
//            return false;
//        }
//        var text = update.message().text();
//        switch (text) {
//            case "/ID":
//                telegramBot.execute(new SendMessage(update.message().chat().id(),
//                        PET_ID_REQUEST_FOR_PET_BOOKING));
//                actionOnNextMessage = upd -> {
//                    Session session = getSessionFactory().openSession();
//                    var ownerId = update.message().chat().id();
//                    var idMessage = upd.message().text();
//                    if (idMessage.matches("\\d+")) { // проверяем, что число
//                        long petId = Long.parseLong(idMessage); // парсим строку в число
//
//                        // КОШКИ
//                        if (TelegramBotPetShelterUpdatesListener.catSelect) { // если кошачий приют, ищем в кошках
//
//                            petsOwner.setPetsType(PetsType.CAT); // присваиваем тип животного
//
//                            Cat cat = session.get(Cat.class, petId);
//
//                            if (cat != null) { // проверяем на кошках, что такой ID есть
//                                petsOwner.setPet(cat);
//                                cat.setOwnerId(ownerId);// заносим ID пользователя в таблицу питомца
//                                catRepository.save(cat); // обновляем кощку
//                                session.close();
//                                telegramBot.execute(new SendMessage(update.message().chat().id(),
//                                        "Питомец" + catRepository.getById(petId).getPetsType().getTitle() + " "
//                                                + catRepository.getById(petId).getId() + " "
//                                                + catRepository.getById(petId).getPetName() + "забронирован за Вами"));
//
//                            } else {
//                                telegramBot.execute(new SendMessage(update.message().chat().id(),
//                                        "Питомец с указанным ID отсутствует в нашем приюте. " +
//                                                "Уточните ID интересующего Вас питомца."));
//                            }
//
//                            // СОБАКИ
//                        } else if (TelegramBotPetShelterUpdatesListener.dogSelect) {
//
//                            petsOwner.setPetsType(PetsType.DOG);
//
//                            Pet dog = session.get(Dog.class, petId);
//
//                            if (dog != null) { // проверяем, что такая собака есть в приюте
//                                petsOwner.setPet(dog);
//                                dog.setOwnerId(ownerId);
//                                session.close();
//                                telegramBot.execute(new SendMessage(update.message().chat().id(),
//                                        "Питомец" + dogRepository.getById(petId).getPetsType().getTitle() + " "
//                                                + dogRepository.getById(petId).getId() + " "
//                                                + dogRepository.getById(petId).getPetName() + "забронирован за Вами."));
//
//                            } else {
//                                telegramBot.execute(new SendMessage(update.message().chat().id(),
//                                        "Питомец с указанным ID отсутствует в нашем приюте. " +
//                                                "Уточните ID интересующего Вас питомца."));
//                            }
//                        }
//
//                        petsOwner.setOwnerId(ownerId); // присваиваем ID пользователя
//                        petsOwner.setPetId(petId); // записываем ID питомца
//                        Session session1 = getSessionFactory().openSession();
//                        Owner owner = session1.get(Owner.class, ownerId);
//                        petsOwner.setOwner(owner);
//                        session1.close();
//                        petsOwnerServiceImpl.save(petsOwner);
//                        telegramBot.execute(new SendMessage(update.message().chat().id(),
//                                "Спасибо. Скоро с Вами свяжется волонтёр!"));
//                    } else {
//                        telegramBot.execute(new SendMessage(update.message().chat().id(),
//                                "Формат ID неверный, введите числовое значение ID выбранного питомца, нажмите или введите /ID"));
//                    }
//                };return true;
//        }
//        return false;
//    }
//    @Test
//    public void testAddOwnerReport() {
//        OwnerReport ownerReport = new OwnerReport(12L, 15L, LocalDateTime.now(), PetsType.CAT, true,
//                "Pedigree", "good", "Ok", 17L);
//        ownerReportService.addOwnerReport(ownerReport);
//        verify(ownerReportRepository, times(1)).save(ownerReport);
//        ArgumentCaptor<OwnerReport> ownerReportArgumentCaptor = ArgumentCaptor.forClass(OwnerReport.class);
//        verify(ownerReportRepository).save(ownerReportArgumentCaptor.capture());
//        OwnerReport ownerReportCreated = ownerReportArgumentCaptor.getValue();
//        Assertions.assertNotNull(ownerReportCreated.getId());
//        assertEquals("good", ownerReportCreated.getPetsHealth());
//    }
//    @Test
//    public void shouldReturnExceptionWhenReportOrIdIsNull() throws Exception {
//// проверяем бросание исключений при ownerReport or id = null
//        OwnerReport nullOwnerReport = new OwnerReport();
//        OwnerReport editedOwnerReport = OwnerReport.builder()
    //пропустили id
//                .reportDateTime(LocalDateTime.now())
//                .havePhoto(true)
//                .nutrition("Whiskas")
//                .petsHealth("good")
//                .petsBehavior("Ok")
//                .petId(1L)
//                .ownerId(3L)
//                .build();

//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/report")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(nullOwnerReport));
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isBadRequest())
//                .andExpect(result ->
//                        assertTrue(result.getResolvedException() instanceof NullPointerException))
//                .andExpect(result ->
//                        assertEquals(("OwnerRecord или Id не должны быть null"), result.getResolvedException().getMessage()));
//    }

    //    @Test
//    public void shouldReturnExceptionWhenReportNotFound() throws Exception {
// проверяем бросание исключений если запись ownerReport не обнаружена
//    OwnerReport nullOwnerReport = new OwnerReport();
//        OwnerReport editedOwnerReport = OwnerReport.builder()
//                .id(321L)
//                .reportDateTime(LocalDateTime.now())
//                .havePhoto(true)
//                .nutrition("Whiskas")
//                .petsHealth("good")
//                .petsBehavior("Ok")
//                .petId(1L)
//                .ownerId(3L)
//                .build();

//        Mockito.when(ownerReportRepository.findById(nullOwnerReport.getId())).thenReturn(null);
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/report")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(nullOwnerReport));
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isBadRequest())
//                .andExpect(result ->
//                        assertTrue(result.getResolvedException() instanceof NotFoundException))
//                .andExpect(result ->
//                        assertEquals(("Записи OwnerRecord с Id = 321 не существует"), result.getResolvedException().getMessage()));
//    }


//    @Test
//    public void deleteOwnerReportByIdTestWhenNotFoundException()throws Exception{
//        Mockito.when((ownerReportRepository.findById(5L))).thenReturn(null);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .delete(("/report/2"))
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest())
//                .andExpect(result ->
//                        assertTrue(result.getResolvedException() instanceof NotFoundException))
//                .andExpect(result -> assertEquals("В базе нет отчёта с id = 5 ",
//                        result.getResolvedException().getMessage()));
//    }
//public void getOwnerReportByIdTest() throws Exception {
//        //тест для метода getById()
//        when(ownerReportRepository.findById(ownerReport1.getId())).thenReturn(java.util.Optional.of(ownerReport1));
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/report/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect(jsonPath("$.nutrition", Matchers.is("Pedigree")));
//}
//}

//    @Test
//    public void getAllOwnerReportsTest() throws Exception {
//        //тест для метода getAll()
//        List<OwnerReport> ownerReports = new ArrayList<>(Arrays.asList(ownerReport1, ownerReport2, ownerReport3));
//
//        when(ownerReportRepository.findAll()).thenReturn(ownerReports);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/report")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(3)))
//                .andExpect(jsonPath("$[1].nutrition", Matchers.is("meat")));
//    }

//    @Test
//    public void editOwnerReportByIdTest() throws Exception {
//        //тест для метода editById()
//        OwnerReport editedOwnerReport = OwnerReport.builder()
//                .id(1L)
//                .reportDateTime(LocalDateTime.now())
//                .havePhoto(true)
//                .nutrition("Whiskas")
//                .petsHealth("good")
//                .petsBehavior("Ok")
//                .petId(1L)
//                .ownerId(3L)
//                .petsType(PetsType.CAT)
//                .build();
//
//        when(ownerReportRepository.findById(ownerReport1.getId())).thenReturn(Optional.of(ownerReport1));
//        when(ownerReportRepository.save(editedOwnerReport)).thenReturn(editedOwnerReport);
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/report")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(editedOwnerReport));
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect(jsonPath("$.nutrition", Matchers.is("Whiskas")));
//    }
}