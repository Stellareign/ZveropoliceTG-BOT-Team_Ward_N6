package com.ward_n6.listener;

public class MessageStringsConstants {
    public static String REPORT = """
            Для загрузки отчёта следуйте указаниям бота. Пожалуйста, заполните все пункты отчёта.
            Сначала укажите ID питомца:\n
            /ID - указать id питомца\n
            Команды для текстового отчёта (нажмите или введите):\n
            1. /action - отчёт о поведении питомца\n
            2. /health - отчёт о здоровье питомца\n
            3. /feed - отчёт о питании питомца\n
            4. /save - сохранить отчёт\n
            Для загрузки фото нажмите или введите команду:\n
            /photo
                                                
            """;


    public static String PERSONAL_DATA_REQUEST = """
            Пожалуйста, укажите Ваши контактные данные, чтобы мы могли связаться с Вами (нажмите или введите команду):
            1. /ln - указать фамилию \n
            2. /fn - указать имя \n
            3. /phone - указать номер телефона \n
            4. /save - сохранить мои контактные данные в базе приюта \n
            5. /delete - удалить мои данные
            """;

    public static String PET_ID_REQUEST_FOR_PET_BOOKING = """
            Введите номер ID интересующего питомца, который Вам сообщил волонтёр.
            Если Вы не знаете ID питомца, позовите волонтёра:
            /volunteer \n
            Вернуться назад:\n
            /start - в начало\n
            /cat - приют для кошек\n
            /dog - приют для собак\n
            """;
    public static String HOW_REPORT = " Для отчёта нужно отправить текст , описывающий: самочувствие питомца, " +
            "рацион питания питомца, в каких условиях живёт питомец и фото питомца" +
            """
                    Введите ини нажмите команду: 
                    /report
                    """;

    public static String SHELTER_INFO = "Мы приветствуем вас в приюте «Мечта». Наш приют основан в 2015 году в г. Астана. " +
            "За это время через наши руки прошло более 500 собак и 200 кошек. Мы являемся некоммерческой организацией, " +
            "поэтому все средства к нашему существованию – это пожертвования неравнодушных жителей. Мы очень рады, что " +
            "вы заглянули к нам!\n" +
            "«Мечта» и его жители находятся по адресу: ул. Защитников Животных д.1. Мы открыты для посещений каждый день " +
            "с 11:00 до 18:00.\n\n" +
            "Борис на связи +77894561230. Он поможет вам оформить пропуск, а также ответить на интересующие вас вопросы.\n\n" +
            "Напоминаем, что во время нахождения на территории приюта посетители обязаны следовать указаниям сотрудников. " +
            "Безопасность питомцев и посетителей в наших с вами руках.\n\n" +
            "Приют нуждается в физической и материальной помощи. Требуются сотрудники для создания благоприятных условий. " +
            "Приют нуждается в кормах и медикаментах, а также хозяйственных принадлежностях – тряпках, полотенцах, " +
            "одеялах, амуниции и игрушек для животных. Пиар приветствуется. Помочь приюту можно переводом денежных " +
            "средств по реквизитам карт в банках, номерам электронных кошельков. Для согласования оказания физической " +
            "и материальной поддержки свяжитесь с волонтёром. Подробнее о нашей деятельности вы можете узнать в социальных " +
            "сетях. Пожалуйста, присоединяйтесь к нашим сообществам Вконтакте, Одноклассники и т.д.";
    public static String HOW_TO_TAKE_PET = "Рады, что вы заинтересованы стать обладателем кошки! Прежде чем оформить " +
            "документы, необходимо познакомиться с питомцем. Встреча и общение с животным проходят в присутствии и " +
            "под наблюдением ответственного сотрудника приюта. Для оформления договора потребуется ваш паспорт РФ. " +
            "Испытательный срок составляет 30 дней. В течение этого срока хозяин обязан присылать ежедневные отчеты " +
            "(в чат-бот, на электронную почту, на WhatsApp и пр.). Выбранный способ отчетности также фиксируется в договоре.\n\n " +
            ":no_entry:Почему мы можем отказать в усыновлении?:no_entry:\n" +
            ":one:\tЖивотное не пошло с вами на контакт.\n" +
            ":two:\tУсловия будущего проживания с вами не соответствуют необходимым для конкретного питомца.\n" +
            ":three:\tСемейные разногласия – нередко один член семьи готов завести питомца, а другой (другие) против. " +
            "В таком случае мы отказываем.\n" +
            ":four:\tОтказ усыновителя оформить документы и пройти испытательный срок. Желание ускорить процесс будет " +
            "для нас «красным маркером».\n" +
            ":five:\tЧасто мы отказываем в усыновлении, если в семье уже имеется какое-нибудь животное или несколько " +
            "животных. В зависимости от характера нашего питомца, мы пристраиваем его в семьи без животных, либо с животными.\n";
    public static String DOG_RECOMMEDATION =  "Рекомендации по транспортировке :blue_car:: Собак всех возрастов рекомендуется НЕ кормить перед поездкой. Последний прием пищи за 10-12 часов. Собаки маленьких пород перевозятся в специальных переносках. Собаки средних и крупных пород перевозятся в специальных авто-гамаках, либо также в переносках. \n\n"+
            " Рекомендации по обустройству дома для животного :house_with_garden::\n "+
            "Щенки: необходимо обустроить его место (лежанка, коврик) и снабдить его игрушками, в т.ч. «грызунками» (на период прорезывания зубов). Также необходимо разместить миски для корма и воды. \n "+
            "Взрослые собаки: необходимо обустроить место (лежанка, коврик) и снабдить его игрушками. Также необходимо разместить миски для корма и воды. \n\n"+
            " Для получения рекомендаций по работе с кинологом, пожалуйста, обращайтесь к Борису  +77894561230. ";
    public static String CAT_RECOMMENDATION = "Рекомендации по транспортировке :blue_car: : Кошек всех возрастов рекомендуется НЕ кормить перед поездкой. Последний прием пищи за 10-12 часов. Кошки перевозятся в специальных переносках. \n\n"+
            " Рекомендации по обустройству дома для животного :house_with_garden:: \n "+
            "Котята: разместить лоток в удобное для вас и доступное для животного место. Также необходимо разместить миски для корма и воды. Для котят мы рекомендуем приобрести когтеточку и некоторое количество игрушек.\n"+
            "Взрослые кошки : разместить лоток в удобное для вас и доступное для животного место. Также необходимо разместить миски для корма и воды. ";

    public static String CAT_DESCRIPTION = "В приюте для кошек единовременно содержится более 600 кошек самых разных пород и возрастов. Все они привиты, чипированы и стерилизованы. \n"+
            " За годы работы мы нашли новый дом более чем для 7400 питомцев и хотим, чтобы на улицах не было бездомных животных.";
    public static String DOG_DESCRIPTION = "Здесь содержатся ~300 бездомных, потерянных или брошенных собак. " +
            "Все привиты, чипированы и давно мечтают найти себе дом!\n"+
            " За годы работы мы нашли новый дом более чем для 7400 питомцев и хотим, чтобы на улицах не было бездомных животных.";
}

