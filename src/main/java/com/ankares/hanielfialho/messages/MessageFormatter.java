package com.ankares.hanielfialho.messages;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class MessageFormatter<T> {

    @Getter
    protected final String prefix;

    public String getMessage(String message) {
        return MessageUtils.translateColorCodes(prefix + message);
    }

    public abstract void send(T sender, String message);

    public void sendDefault(T sender, DefaultMessage defaultMessage, Object... objects) {
        send(sender, defaultMessage.format(objects));
    }
}
