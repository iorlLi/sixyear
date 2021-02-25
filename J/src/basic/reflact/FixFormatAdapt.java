package basic.reflact;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 根据cls参数获取表示字段长度注解
 */
public class FixFormatAdapt implements Adapt {
    @Override
    public <T> T unformat(String content, Class<T> cls) throws Exception {
        //
        byte[] bytes = content.getBytes();

        //注意需要有无参构造器
        T obj = cls.newInstance();

        Field[] declaredFields = cls.getDeclaredFields();
        List<FixField> fixFieldLinkedList = new ArrayList<>();
        for (Field field : declaredFields) {
            if (!field.isAnnotationPresent(FixFieldDef.class)) {
                continue;
            }

            field.setAccessible(Boolean.TRUE.booleanValue());

            FixFieldDef fieldAnnotation = field.getAnnotation(FixFieldDef.class);
            fixFieldLinkedList.add(new FixField(field, fieldAnnotation.order(),
                    fieldAnnotation.length(), fieldAnnotation.align(), fieldAnnotation.padSpace()));
        }

        //fixFieldLinkedList.stream().sorted(Comparator.comparing(FixField::getOrder));
        Collections.sort(fixFieldLinkedList);

        //将bytes 根据fixField的注解中的长度进行截取
        int position = 0;
        for (FixField fixField : fixFieldLinkedList) {
            Field field = fixField.getField();
            byte[] fieldByte = Arrays.copyOfRange(bytes, position, fixField.getLength());
            String value = new String(fieldByte);

            if(String.class == field.getType()){
                field.set(obj, value);
            }else if(Integer.class == field.getType()){
                field.set(obj, Integer.valueOf(value));
            }else{
                System.out.println("不支持");
            }
        }
        return obj;
    }
}
