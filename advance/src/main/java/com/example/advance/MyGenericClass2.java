package com.example.advance;

/**
 * 2. 始终不确定泛型的类型，直到创建对象时，确定泛型的类型
 *
 * @param <MVP>
 */
public class MyGenericClass2<MVP> implements MyGenericInterface<MVP> {
    public MVP mvp;

    @Override
    public void add(MVP mvp) {
        this.mvp = (MVP) mvp;
    }

    @Override
    public void unset() {
        this.mvp = null;
    }
}
