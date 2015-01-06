package com.box.boxjavalibv2.requests;

import org.apache.http.HttpStatus;

import com.box.boxjavalibv2.IBoxConfig;
import com.box.boxjavalibv2.jsonparsing.IBoxJSONParser;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;
import com.box.restclientv2.requestsbase.BoxDefaultRequestObject;
import com.box.restclientv2.requestsbase.DefaultViewRequest;

/**
 * Request for uploading a file to view api using public Url of the file.
 *
 */
public class ViewUrlUploadItemRequest extends DefaultViewRequest {

	private static final String URL_STRING = "url";

	/**
	 * @param config
	 * @param parser
	 * @param publicUrl
	 * @param apiKey
	 * @param requestObject
	 * @throws BoxRestException
	 */
	private ViewUrlUploadItemRequest(final IBoxConfig config, final IBoxJSONParser parser,
			final BoxDefaultRequestObject requestObject) throws BoxRestException {
		super(config, parser, null, RestMethod.POST, requestObject);
		this.setExpectedResponseCode(HttpStatus.SC_ACCEPTED);
	}
	
	public static ViewUrlUploadItemRequest getUrlUploadRequest(IBoxConfig config, IBoxJSONParser parser, String publicUrl, 
			final String apiKey) throws BoxRestException {
		BoxDefaultRequestObject requestObject = new BoxDefaultRequestObject();
		requestObject.put(URL_STRING, publicUrl);
		requestObject.getRequestExtras().addHeader("Authorization", "Token " + apiKey);
		requestObject.getRequestExtras().addHeader("Content-Type", "application/json");
		return new ViewUrlUploadItemRequest(config, parser, requestObject);
	}

}
