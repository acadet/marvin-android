package com.adriencadet.marvin.models.beans.utils;

public class TodoListColor {
    public final static int RED = 0;

    private final int _value;

    public TodoListColor(int value) {
        _value = value;
    }

    public int toInt() {
        return _value;
    }
}
