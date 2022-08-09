package club.yiwuyu.zcgl.util.page;

import org.springframework.cglib.beans.BeanCopier;

/**
* @author: fate
* @description: 对象属性值复制
* @date: 2021-07-09 13:15:25
**/
public class ConverterUtils {

    private ConverterUtils() {
    }

    /**
     * 对象值转换（同属性）
     * @param source
     * @param target
     * @return
     */
    public static <S, T> T convert(S source, Class<T> target) {
        if (source == null) {
            return null;
        }
        BeanCopier copier = BeanCopier.create(source.getClass(), target, false);
        T instance = null;
        try {
            instance = target.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        copier.copy(source, instance, null);
        return instance;
    }

}
