package basic.reflact;

public interface Adapt {
    public <T> T unformat(String content, Class<T> cls) throws Exception;
}