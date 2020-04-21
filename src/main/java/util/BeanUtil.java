package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现深度的BeanOfClasssA<->BeanOfClassB复制
 *
 * @author zhengzhongping
 */
public class BeanUtil {

    private BeanUtil() {
    }

    private static final MapperFacade MAPPER_FACADE = new DefaultMapperFactory.Builder().build().getMapperFacade();

    /**
     * 简单的复制出新类型对象.
     *
     * @param <S>              parameter
     * @param <D>              parameter
     * @param source           source
     * @param destinationClass destination class
     * @return the d
     */
    public static <S, D> D map(S source, Class<D> destinationClass) {
        return map(source, destinationClass, MAPPER_FACADE);
    }

    /**
     * 复制出新类型对象.
     *
     * @param <S>              parameter
     * @param <D>              parameter
     * @param source           source
     * @param destinationClass destination class
     * @param mapperFacade     mapper facade
     * @return the d
     */
    public static <S, D> D map(S source, Class<D> destinationClass, MapperFacade mapperFacade) {
        return mapperFacade.map(source, destinationClass);
    }

    /**
     * 简单的复制出新对象ArrayList
     *
     * @param <S>              parameter
     * @param <D>              parameter
     * @param sourceList       source list
     * @param destinationClass destination class
     * @return the list
     */
    public static <S, D> List<D> mapList(Iterable<S> sourceList, Class<D> destinationClass) {
        return mapList(sourceList, destinationClass, MAPPER_FACADE);
    }

    /**
     * 复制出新对象ArrayList
     *
     * @param <S>              parameter
     * @param <D>              parameter
     * @param sourceList       source list
     * @param destinationClass destination class
     * @param mapperFacade     mapper facade
     * @return the list
     */
    public static <S, D> List<D> mapList(Iterable<S> sourceList, Class<D> destinationClass, MapperFacade mapperFacade) {
        List<D> destinationList = new ArrayList<D>();
        if (sourceList != null) {
            for (S source : sourceList) {
                if (source != null) {
                    destinationList.add(mapperFacade.map(source, destinationClass));
                }
            }
        }
        return destinationList;
    }

    /**
     * 简单复制出新对象数组
     *
     * @param <S>              parameter
     * @param <D>              parameter
     * @param sourceArray      source array
     * @param destinationClass destination class
     * @return the d [ ]
     */
    public static <S, D> D[] mapArray(final S[] sourceArray, final Class<D> destinationClass) {
        D[] destinationArray = newArray(destinationClass, sourceArray.length);

        int i = 0;
        for (S source : sourceArray) {
            if (source != null) {
                destinationArray[i] = MAPPER_FACADE.map(sourceArray[i], destinationClass);
                i++;
            }
        }

        return destinationArray;
    }

    /**
     * 传入类型与大小创建数组.
     * <p>
     * Array.newInstance()的性能并不差
     */
    @SuppressWarnings("unchecked")
    private static <T> T[] newArray(Class<T> type, int length) {
        return (T[]) Array.newInstance(type, length);
    }

    /**
     * To json string
     *
     * @param <S>    parameter
     * @param source source
     * @return string string
     */
    public static <S> String toJson(S source) {
        return toJson(source, false);
    }

    /**
     * To json string
     *
     * @param <S>     parameter
     * @param source  source
     * @param nonNull non null
     * @return the string
     */
    public static <S> String toJson(S source, boolean nonNull) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(source);
        } catch (Exception e) {
            return nonNull ? "{}" : null;
        }
    }
}
