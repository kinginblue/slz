package cn.shana.slz.boot.orika;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by kinginblue on 2017/8/8.
 */
public class Orika {

    private static final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private static final MapperFacade mapperFacade = mapperFactory.getMapperFacade();

    /**
     * Orika simple map: Create and return a new instance of type D mapped with the properties of sourceObject.
     * @param sourceObject the object to map from
     * @param destinationClass the type of the new object to return
     * @param <S> type of object to map from
     * @param <D> the type of the new object to return
     * @return a new instance of type D mapped with the properties of sourceObject
     */
    public static <S, D> D map(S sourceObject, Class<D> destinationClass) {
        return mapperFacade.map(sourceObject, destinationClass);
    }

}
