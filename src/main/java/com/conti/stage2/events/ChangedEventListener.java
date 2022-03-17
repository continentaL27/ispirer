package com.conti.stage2.events;

import com.conti.stage2.SomeList;

import java.time.LocalDateTime;

public class ChangedEventListener implements EventListener {

    private final SomeList<?> list;

    public ChangedEventListener(SomeList<?> list) {
        this.list = list;
    }

    @Override
    public void update(EventType event, Object object) {
        System.out.println(LocalDateTime.now() + " list " + list.hashCode()
                + ", " + event);
    }
}
