package ua.remzsolutions.onlinespreadsheets.web.request;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE,
        include = JsonTypeInfo.As.PROPERTY)
public abstract class AbstractRequest {

}
