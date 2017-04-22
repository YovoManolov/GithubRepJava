package app.bussinessLayer.Factories.Interfaces;

import app.common.models.ViewModels.EventView;
import app.dataLayer.domain.models.EventDA;


/**
 * Created by Ico on 29.12.2016 г..
 */
public interface EventFactory {
    EventDA createEvent(EventView inputEvent);
}
