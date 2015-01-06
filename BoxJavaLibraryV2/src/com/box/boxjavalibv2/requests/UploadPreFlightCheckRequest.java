package com.box.boxjavalibv2.requests;

import org.apache.http.HttpStatus;

import com.box.boxjavalibv2.IBoxConfig;
import com.box.boxjavalibv2.jsonentities.MapJSONStringEntity;
import com.box.boxjavalibv2.jsonparsing.IBoxJSONParser;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.requestsbase.BoxDefaultRequestObject;
import com.box.restclientv2.requestsbase.DefaultBoxRequest;

public class UploadPreFlightCheckRequest extends DefaultBoxRequest {
	private static final String URI_UPLOAD = "/files/content";
	private static final String URI_UPLOAD_NEW_VERSION = "/files/%s/content";
	private static final String EMPTY_STRING = "";

	private UploadPreFlightCheckRequest(IBoxConfig config, IBoxJSONParser parser, String id, BoxDefaultRequestObject requestObject)
			throws BoxRestException {
		super(config, parser, getUri(id), RestMethod.OPTIONS, requestObject);
		setExpectedResponseCode(HttpStatus.SC_OK);
	}
	
	private static String getUri(final String fileId) {
        return (fileId != null && !EMPTY_STRING.equals(fileId)) ? String.format(URI_UPLOAD_NEW_VERSION, fileId) : URI_UPLOAD;
    }
	
	public static UploadPreFlightCheckRequest getUploadPreFlightCheckRequest(IBoxConfig config, IBoxJSONParser parser, 
			String fileId, String filename, String parentId, long size ) throws BoxRestException {
		BoxDefaultRequestObject requestObject = new BoxDefaultRequestObject();
		requestObject.put("name", filename);
		MapJSONStringEntity parent = new MapJSONStringEntity();
		parent.put("id", parentId);
		requestObject.put("parent", parent);
		requestObject.put("size", size);
		return new UploadPreFlightCheckRequest(config, parser, fileId, requestObject);
	}
}
