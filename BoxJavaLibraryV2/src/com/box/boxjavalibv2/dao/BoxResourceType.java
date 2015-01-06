package com.box.boxjavalibv2.dao;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Type of resources that can be requested by API's.
 */
public enum BoxResourceType implements IBoxType {
    /*** An item, which could be a file, a folder, a weblink... */
    ITEM,
    /** A plural format of {@link #ITEM}. */
    ITEMS,
    /** A box file. */
    FILE,
    /** A plural format of {@link #FILE}. */
    FILES,
    /** A box weblink. */
    WEB_LINK,
    /** A plural format of {@link #WEB_LINK}. */
    WEB_LINKS,
    /** Preview of a file. */
    PREVIEW,
    /** A box folder. */
    FOLDER,
    /** A box user. */
    USER,
    /** A plural format of {@link #USER}. */
    USERS,
    /** A group. */
    GROUP,
    /** A plural format of {@link #GROUP}. */
    GROUPS,
    /** A comment. */
    COMMENT,
    /** A plural format of {@link #COMMENT}. */
    COMMENTS,
    /** A version of a file. */
    FILE_VERSION,
    /** A plural format of {@link #FILE_VERSION}. */
    FILE_VERSIONS,
    /** Box's equivalent of access control lists. They can be used to set and apply permissions for users to folders. */
    COLLABORATION,
    /** A plural format of {@link #COLLABORATION}. */
    COLLABORATIONS,
    /** An email alias. */
    EMAIL_ALIAS,
    /** A plural format of {@link #EMAIL_ALIAS}. */
    EMAIL_ALIASES,
    /** OAuth data. */
    OAUTH_DATA,
    /** Error. */
    ERROR,
    /** Event. */
    EVENT,
    /** A plural format of {@link #EVENT}. */
    EVENTS,
    /** Realtime server. */
    REALTIME_SERVER,
    /** File lock (shows up in event stream). */
    LOCK,
    /** permissions */
    ITEM_PERMISSIONS,
    /** Service action is a subtype of file lock. */
    SERVICE_ACTION,
    /** group membership. */
    GROUP_MEMBERSHIP,
    /** A plural format of {@link #GROUP_MEMBERSHIP}. */
    GROUP_MEMBERSHIPS, THUMBNAIL,
    /** A collection */
    COLLECTION,
    /** Plural collections */
    COLLECTIONS,
    /** A document of view api */
    VIEW_ITEM;

    // As a performance optimization, set up string values for all types.
    private static final Map<BoxResourceType, String> typeToLowercaseString = new HashMap<BoxResourceType, String>();
    static {
        for (BoxResourceType type : values()) {
            String str = type.name().toLowerCase(Locale.US);
            typeToLowercaseString.put(type, str);
        }
    }

    @Override
    public String toString() {
        return typeToLowercaseString.get(this);
    }

    /**
     * Get the String representing plural format of a resource.
     * 
     * @return the String representing plural format of a resource
     */
    public String toPluralString() {
        return toString() + "s";
    }

    /**
     * Get the BoxResourceType from a lower case string value. For example "file" would return BoxResourceType.FILE Deprecated, use getTypeFromLowercaseString
     * method in IBoxResourceHub instead.
     * 
     * @param string
     * @return
     */
    @Deprecated
    public static BoxResourceType getTypeFromLowercaseString(final String string) {
        return Enum.valueOf(BoxResourceType.class, string.toUpperCase(Locale.US));
    }
}
