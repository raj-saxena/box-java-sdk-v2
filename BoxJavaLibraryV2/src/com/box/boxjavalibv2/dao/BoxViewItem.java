package com.box.boxjavalibv2.dao;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", defaultImpl = BoxViewItem.class)
public class BoxViewItem extends BoxTypedObject {
	
	public static final String FIELD_NAME = "name";
	public static final String FIELD_STATUS = "status";
	
    /**
     * Constructor.
     */
    public BoxViewItem() {
        setType(BoxResourceType.VIEW_ITEM.toString());
    }

    /**
     * Copy constructor, this does deep copy for all the fields.
     * 
     * @param obj
     */
    public BoxViewItem(BoxViewItem obj) {
        super(obj);
    }
    
    /**
     * Instantiate the object from a map. Each entry in the map reflects to a field.
     * 
     * @param map
     */
    public BoxViewItem(Map<String, Object> map) {
        super(map);
    }
    
    /**
     * @return name of the file.
     */
    @JsonProperty(FIELD_NAME)
    public String getName() {
        return (String) getValue(FIELD_NAME);
    }
    
    /**
     * This is only used by {@see <a href="http://jackson.codehaus.org">Jackson JSON processer</a>}
     * @param name
     */
    @JsonProperty(FIELD_NAME)
    private void setName(String name) {
        put(FIELD_NAME, name);
    }
    
    /**
     * @return status of the file.
     */
    @JsonProperty(FIELD_STATUS)
    public String getStatus() {
        return (String) getValue(FIELD_STATUS);
    }
    
    /**
     * This is only used by {@see <a href="http://jackson.codehaus.org">Jackson JSON processer</a>}
     * @param status
     */
    @JsonProperty(FIELD_STATUS)
    private void setStatus(String status) {
        put(FIELD_NAME, status);
    }
    
    
    public BoxViewItem(IBoxParcelWrapper in) {
        super(in);
    }
}
