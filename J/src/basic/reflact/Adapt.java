package basic.reflact;

import java.io.UnsupportedEncodingException;

public interface Adapt {
    public <T> T unformat(String content, Class<T> cls) throws Exception;
}