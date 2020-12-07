import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TelegramBot extends TelegramLongPollingBot {
    private final WeatherGetter weatherGetter = new WeatherGetter();
    private final Subscribers subscribers = new Subscribers();
    private final HashMap<String, User> users = new HashMap<>();

    public WeatherGetter getWeatherGetter() {
        return weatherGetter;
    }

    public TelegramBot() {
        super();
        User.setTelegramBot(this);
        User.setWeatherGetter(weatherGetter);
        subscribers.start();
    }

    @Override
    public String getBotToken() {
        return "1456615883:AAHv0T4ySbE4x6ZrlpbSDhSFPwQMjwhb4kY";
    }

    @Override
    public String getBotUsername() {
        return "T1WEATHER_bot";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message inMsg = update.getMessage();
            answer(inMsg);
        }
    }

    private void answer(Message inMsg) {
        String chatId = String.valueOf(inMsg.getChatId());
        String inText = inMsg.getText().toLowerCase();
        User user;
        if (users.containsKey(chatId)) {
            user = users.get(chatId);
        } else {
            user = new User(chatId, inMsg.getChat().getFirstName());
            users.put(chatId, user);
        }

        if (inText.equals("/start")) {
            user.send("Здравствуй, юный подаван (@_@)");
            if (!user.hasLocation()) {
                user.send("Откуда ты, желаю знать я");
            }
        } else {
            if (!user.hasLocation()) {
                try {
                    weatherGetter.getCurrent(inText);
                    user.setLocation(inText);
                    user.send("Твое местоположение известно мне стало");
                } catch (IOException e) {
                    user.send("Не известен город " + inText + " мне");
                    user.send("Откуда ты, знать я желаю");
                }
            } else {
                command(user, inText);
            }
        }
    }

    public void command(User user, String command) {
        switch (command) {
            case "сегодня" -> user.sendCurrent();
            case "завтра" -> {
                user.sendTomorrow();
                user.send("Пока что не работает");
            }
            case "неделя" -> {
                user.sendWeek();
                user.send("Пока что не работает");
            }
            case "месяц" -> {
                user.sendMonth();
                user.send("Пока что не работает");
            }
            case "подписаться" -> {
                subscribers.add(user);
                user.send("Каждый день получать погоду будешь ты");
            }
            case "отписаться" -> {
                subscribers.remove(user);
                user.send("Получать погоду больше не будешь ты");
            }
            case "изменить расположение" -> {
                user.setLocation(null);
                user.send("Куда отправился ты?");
            }
        }
    }

    public void sendMsg(String id, String text, boolean withMenu) {
        try {
            SendMessage outMsg = new SendMessage();
            setKeyBoard(outMsg, subscribers.hasId(id), withMenu);
            outMsg.setChatId(id);
            outMsg.setText(text);
            outMsg.setParseMode("HTML");
            execute(outMsg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void setKeyBoard(SendMessage outMsg, boolean isSubscribed, boolean withMenu) {
        if (withMenu) {
            // Configuring
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setSelective(true);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setOneTimeKeyboard(false);
            KeyboardRow row1 = new KeyboardRow();
            row1.add("Сегодня");
            row1.add("Завтра");
            KeyboardRow row2 = new KeyboardRow();
            row2.add("Неделя");
            row2.add("Месяц");
            KeyboardRow row3 = new KeyboardRow();
            if (isSubscribed) {
                row3.add("Отписаться");
            } else {
                row3.add("Подписаться");
            }
            KeyboardRow row4 = new KeyboardRow();
            row4.add("Изменить расположение");
            List<KeyboardRow> keyboard = new ArrayList<>();
            keyboard.add(row1);
            keyboard.add(row2);
            keyboard.add(row3);
            keyboard.add(row4);
            replyKeyboardMarkup.setKeyboard(keyboard);
            outMsg.enableMarkdown(true);
            outMsg.setReplyMarkup(replyKeyboardMarkup);
        } else {
            ReplyKeyboardRemove replyKeyboardRemove = new ReplyKeyboardRemove();
            replyKeyboardRemove.setSelective(true);
            replyKeyboardRemove.setRemoveKeyboard(true);
            outMsg.setReplyMarkup(replyKeyboardRemove);
        }
    }

    private void log(Message msg, String answer) {
        String firstName = msg.getChat().getFirstName();
        String lastName = msg.getChat().getLastName();
        String userName = msg.getChat().getUserName();
        String msgText = msg.getText();
        String chatId = String.valueOf(msg.getChatId());
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("\n ---------MESSAGE-----------");
        System.out.println("        " + dateFormat.format(new Date()));
        System.out.println("    First name: " + firstName);
        System.out.println("    Last name:  " + lastName);
        System.out.println("    Username:   " + userName);
        System.out.println("    Chat ID:    " + chatId);
        System.out.println("    Text:       " + msgText);
        System.out.println("    +++++++++++++++++++++++");
        System.out.println("    Answer:     " + answer);
        System.out.println(" -----------END-------------");
    }
}
