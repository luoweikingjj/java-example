package com.example.advance;

public class MyGenericClass<MVP> {
    private MVP mvp;

    public MVP getMvp() {
        return mvp;
    }

    public void setMvp(MVP mvp) {
        this.mvp = mvp;
    }

    /**
     * 定义含有泛型变量的方法
     */
    public <MVP> void showMVP() {
        System.out.println(this.mvp);
    }

    /**
     * 定义含有泛型变量的方法, 并且返回对应的泛型类型
     * @param <MVP>
     * @return
     */
    public <MVP> MVP showMVP1() {
        return (MVP) this.mvp;
    }

    /**
     * 定义含有泛型变量的方法, 需传入值， 并且返回对应的泛型的值
     * @param mvp
     * @param <MVP>
     * @return
     */
    public <MVP> MVP showMVP2(MVP mvp){
        return mvp;
    }
}
