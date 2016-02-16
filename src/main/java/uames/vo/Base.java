package uames.vo;

public class Base<T extends uames.po.Base> {
    private T po;

    public T getPo() {
        return po;
    }

    public void setPo(T po) {
        this.po = po;
    }
}
