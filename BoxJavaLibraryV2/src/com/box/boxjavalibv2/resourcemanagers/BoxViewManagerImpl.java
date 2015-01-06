package com.box.boxjavalibv2.resourcemanagers;

import com.box.boxjavalibv2.IBoxConfig;
import com.box.boxjavalibv2.dao.BoxResourceType;
import com.box.boxjavalibv2.dao.BoxViewItem;
import com.box.boxjavalibv2.exceptions.AuthFatalFailureException;
import com.box.boxjavalibv2.exceptions.BoxServerException;
import com.box.boxjavalibv2.jsonparsing.IBoxJSONParser;
import com.box.boxjavalibv2.jsonparsing.IBoxResourceHub;
import com.box.boxjavalibv2.requests.ViewUrlUploadItemRequest;
import com.box.restclientv2.IBoxRESTClient;
import com.box.restclientv2.authorization.IBoxRequestAuth;
import com.box.restclientv2.exceptions.BoxRestException;

public class BoxViewManagerImpl extends AbstractBoxResourceManager implements IBoxViewManager {
	
	public BoxViewManagerImpl (IBoxConfig config, IBoxResourceHub resourceHub, IBoxJSONParser parser, IBoxRequestAuth auth, IBoxRESTClient restClient) {
        super(config, resourceHub, parser, auth, restClient);
    }

	@Override
	public BoxViewItem postDocumentByUrl(String publicUrl, String apiKey) throws BoxRestException, 
	AuthFatalFailureException, BoxServerException {
		ViewUrlUploadItemRequest request = ViewUrlUploadItemRequest.getUrlUploadRequest(getConfig(), getJSONParser(), publicUrl, apiKey);
		return  (BoxViewItem) getResponseAndParseAndTryCast(request, BoxResourceType.VIEW_ITEM, getJSONParser());
	}

}
