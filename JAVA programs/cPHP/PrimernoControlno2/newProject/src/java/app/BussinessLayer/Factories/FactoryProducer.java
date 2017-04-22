package app.bussinessLayer.Factories;

import app.bussinessLayer.Factories.Interfaces.EventFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Ico on 29.12.2016 г..
 */
@Component
public class FactoryProducer {

    public EventFactory createFactory(String factoryType) {
        EventFactory finalFactory = null;

        try {
            Class<?> wildFactory = Class.forName("app.BussinessLayer.Factories." + factoryType + "Factory");

            Class<? extends EventFactory > mySubTypeFactory =
                    (wildFactory.asSubclass(EventFactory.class));

            finalFactory = mySubTypeFactory.newInstance();
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return finalFactory;
    }
}
