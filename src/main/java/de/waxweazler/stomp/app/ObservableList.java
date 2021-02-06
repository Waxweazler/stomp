package de.waxweazler.stomp.app;

import io.reactivex.rxjava3.subjects.PublishSubject;

import java.util.ArrayList;
import java.util.List;

public class ObservableList<T> {

    private final List<T> list;
    private final PublishSubject<T> subject;

    public ObservableList() {
        this.list = new ArrayList<>();
        this.subject = PublishSubject.create();
    }

    public PublishSubject<T> asSubject() {
        return this.subject;
    }

    public List<T> asList() {
        return this.list;
    }

    public void add(T value) {
        this.list.add(value);
        this.subject.onNext(value);
    }

}
