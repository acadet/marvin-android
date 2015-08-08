package com.adriencadet.marvin.utils;

import com.coshx.chocolatine.utils.funcs.Func0;

/**
 * @class Lazy
 * @brief
 */
public class Lazy<T> {
    private static Object _lock = new Object();

    private Func0<T> _builder;
    private T        _nestedObject;

    public Lazy() {
    }

    public Lazy(Func0<T> builder) {
        _builder = builder;
    }

    public T get() {
        if (_nestedObject == null) {
            synchronized (_lock) {
                if (_nestedObject == null) {
                    _nestedObject = _builder.run();
                }
            }
        }

        return _nestedObject;
    }

    public T get(Func0<T> builder) {
        _builder = builder;
        return get();
    }
}
