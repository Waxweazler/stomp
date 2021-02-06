package de.waxweazler.stomp.app;

import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ApplicationConfig {

    private final ObservableList<String> messages = new ObservableList<>();

    public void addMessage(String message) {
        messages.add(message);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void onMessage(Consumer<String> callback) {
        this.messages.asSubject().subscribe(callback::accept);
    }

}
