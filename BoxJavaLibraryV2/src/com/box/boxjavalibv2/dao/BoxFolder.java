package com.box.boxjavalibv2.dao;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Box folder.
 */
public class BoxFolder extends BoxItem {

    public static final String FIELD_FOLDER_UPLOAD_EMAIL = "folder_upload_email";
    public static final String FIELD_ITEM_COLLECTION = "item_collection";
    public static final String FIELD_HAS_COLLABORATIONS = "has_collaborations";
    public static final String FIELD_SYNC_STATE = "sync_state";
    public static final String FIELD_IS_EXTERNALLY_OWNED = "is_externally_owned";

    /**
     * Constructor.
     */
    public BoxFolder() {
        setType(BoxResourceType.FOLDER.toString());
    }

    /**
     * Copy constructor, this does deep copy for all the fields.
     *
     * @param obj
     */
    public BoxFolder(BoxFolder obj) {
        super(obj);
    }

    /**
     * Instantiate the object from a map. Each entry in the map reflects to a field.
     *
     * @param map
     */
    public BoxFolder(Map<String, Object> map) {
        super(map);
    }

    /**
     * This is folder specific field, get the email that can be used to upload file into the folder.
     *
     * @return email
     */
    @JsonProperty(FIELD_FOLDER_UPLOAD_EMAIL)
    public BoxEmail getFolderUploadEmail() {
        return (BoxEmail) getValue(FIELD_FOLDER_UPLOAD_EMAIL);
    }

    /**
     * Setter. This is only used by @see <a href="http://jackson.codehaus.org">Jackson JSON processer</a>.
     *
     * @param folderUploadEmail
     */
    @JsonProperty(FIELD_FOLDER_UPLOAD_EMAIL)
    protected void setFolderUploadEmail(BoxEmail folderUploadEmail) {
        put(FIELD_FOLDER_UPLOAD_EMAIL, folderUploadEmail);
    }

    /**
     * Getter.Get the items(files, subfolders, web links...) under this box folder.
     *
     * @return collection of children items.
     */
    @JsonProperty(FIELD_ITEM_COLLECTION)
    public BoxCollection getItemCollection() {
        return (BoxCollection) getValue(FIELD_ITEM_COLLECTION);
    }

    /**
     * Setter. This is only used by @see <a href="http://jackson.codehaus.org">Jackson JSON processer</a>.
     *
     * @param itemCollection
     *            children item.
     */
    @JsonProperty(FIELD_ITEM_COLLECTION)
    protected void setItemCollection(BoxCollection itemCollection) {
        put(FIELD_ITEM_COLLECTION, itemCollection);
    }

    /**
     * Getter.Get whether this box folder has collaborations.
     *
     * @return whether this box folder has collaborations
     */
    @JsonProperty(FIELD_HAS_COLLABORATIONS)
    public Boolean hasCollaborations() {
        return (Boolean) getValue(FIELD_HAS_COLLABORATIONS);
    }

    public boolean hasCollaborations(boolean defaultValue) {
        Boolean hasCollabs = hasCollaborations();
        return hasCollabs != null ? hasCollabs : defaultValue;
    }

    /**
     * Setter. This is only used by @see <a href="http://jackson.codehaus.org">Jackson JSON processer</a>.
     *
     * @param hasCollaborations
     *            whether folder has collaborations.
     */
    @JsonProperty(FIELD_HAS_COLLABORATIONS)
    protected void setHasCollaborations(Boolean hasCollaborations) {
        put(FIELD_HAS_COLLABORATIONS, hasCollaborations);
    }

    /**
     * Getter.Get whether this box folder is externally owned.
     *
     * @return whether this box folder is externally owned
     */
    @JsonProperty(FIELD_IS_EXTERNALLY_OWNED)
    public Boolean isExternallyOwned() {
        return (Boolean) getValue(FIELD_IS_EXTERNALLY_OWNED);
    }

    /**
     * Setter. This is only used by @see <a href="http://jackson.codehaus.org">Jackson JSON processer</a>.
     *
     * @param isExternallyOwned
     *            whether folder is externally owned.
     */
    @JsonProperty(FIELD_IS_EXTERNALLY_OWNED)
    protected void setExternallyOwned(Boolean isExternallyOwned) {
        put(FIELD_IS_EXTERNALLY_OWNED, isExternallyOwned);
    }

    /**
     * Whether this folder will be synced by Box sycn clients or not. Can be "synced", "not_synced", or "partially_synced".
     * 
     * @return sync state
     */
    @JsonProperty(FIELD_SYNC_STATE)
    public String getSyncState() {
        return (String) getValue(FIELD_SYNC_STATE);
    }

    /**
     * Setter. This is only used by {@see <a href="http://jackson.codehaus.org">Jackson JSON processer</a>}
     * 
     * @param syncState
     *            sync state
     */
    @JsonProperty(FIELD_SYNC_STATE)
    private void setSyncState(String syncState) {
        put(FIELD_SYNC_STATE, syncState);
    }

    public BoxFolder(IBoxParcelWrapper in) {
        super(in);
    }
}
